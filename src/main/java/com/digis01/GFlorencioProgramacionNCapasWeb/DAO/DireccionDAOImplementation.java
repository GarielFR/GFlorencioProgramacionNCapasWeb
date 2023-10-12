/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GFlorencioProgramacionNCapasWeb.DAO;

import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Colonia;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Direccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class DireccionDAOImplementation implements IDireccionDAO {
    private EntityManager entityManager;
    
    @Autowired // inyección
    public DireccionDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
     public List<Direccion> GetAll(){

        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion", Direccion.class);
        List<Direccion> direcciones = query.getResultList();

        return direcciones;
    }
     public Direccion GetByIdUsuario(int idUsuario){
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion WHERE Usuario.idUsuario=:idUsuario", Direccion.class);
        query.setParameter("idUsuario", idUsuario);
        Direccion direccion = query.getSingleResult();
        return direccion;
    }
    @Override  
    public Direccion GetByIdColonia(int idDireccionEditable){
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion WHERE Colonia.idUsuario=:idDireccionEditable", Direccion.class);
        
        query.setParameter("idDireccionEditable", idDireccionEditable);        
        return query.getSingleResult();
    }
     
     @Override
     @Transactional
     public void Add(Direccion direccion){
         entityManager.persist(direccion);
     }
     
    
}
