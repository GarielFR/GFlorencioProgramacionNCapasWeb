/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GFlorencioProgramacionNCapasWeb.DAO;

import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Rol;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Usuario;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class UsuarioDAOImplementation implements IUsuarioDAO {

    private EntityManager entityManager;

    @Autowired//inyeccion de independencias 
    public UsuarioDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Usuario> GetAll(Usuario usuario) {

        //TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE UPPER (nombre) LIKE UPPER (:nombreusuario) AND UPPER(apellidopaterno) LIKE UPPER (:apellidopaterno) AND UPPER(apellidomaterno) LIKE UPPER (:apellidomaterno)", Usuario.class);
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE REPLACE(UPPER(nombre), ' ', '') LIKE REPLACE(UPPER(:nombreusuario), ' ', '') AND REPLACE(UPPER(apellidopaterno), ' ', '') LIKE REPLACE(UPPER(:apellidopaterno), ' ', '') AND REPLACE(UPPER(apellidomaterno), ' ', '') LIKE REPLACE(UPPER(:apellidomaterno), ' ', '')", Usuario.class);

        query.setParameter("nombreusuario", ('%' + usuario.getNombre().toUpperCase() + '%'));
        query.setParameter("apellidopaterno", ('%' + usuario.getApellidopaterno().toUpperCase() + '%'));
        query.setParameter("apellidomaterno", ('%' + usuario.getApellidomaterno().toUpperCase() + '%'));

        List<Usuario> usuarios = query.getResultList();

        return usuarios;

    }

    @Override
    @Transactional
    public int Add(Usuario usuario) {

        //usuario.setFechanacimiento(new Date());
        Rol rol = new Rol();
        rol.setIdrol(1);
        usuario.setRol(rol);
        entityManager.persist(usuario);

        return usuario.getIdusuario();
    }

    @Override
    public Usuario GetById(int idusuarioeditable) {
        //JPQL
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE idusuario=:idusuarioeditable", Usuario.class);
        query.setParameter("idusuarioeditable", idusuarioeditable);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void Update(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    @Transactional
    public void ChangeStatus(int idusuario, boolean status) {
        Usuario usuario = entityManager.find(Usuario.class, idusuario);
        String statusString = (status)? "Y" : "N";
        usuario.setStatus(statusString);
        entityManager.merge(usuario);
    }


    @Override
    @Transactional
    public void Delete(Usuario usuario) {
        if (!entityManager.contains(usuario)) {
            usuario = entityManager.merge(usuario);
        }
        entityManager.remove(usuario);
    }

}
