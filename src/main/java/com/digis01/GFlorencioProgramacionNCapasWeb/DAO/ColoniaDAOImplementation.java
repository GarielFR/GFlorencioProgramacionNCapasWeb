/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GFlorencioProgramacionNCapasWeb.DAO;

import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Colonia;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Rol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public class ColoniaDAOImplementation implements IColoniaDAO {

    private EntityManager  entityManager;
    
    @Autowired// inyeccion de metodoa 
    public ColoniaDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    
    @Override
    public List<Colonia> GetAll() {
        TypedQuery<Colonia> query = entityManager.createQuery("FROM Colonia", Colonia.class);
        List<Colonia> colonias = query.getResultList();

        return colonias;
    }

    @Override
    public List<Colonia> GetByIdMunicipio(int IdMunicipio) {
        TypedQuery<Colonia> query = entityManager.createQuery("FROM Colonia WHERE municipio.idmunicipio = :id", Colonia.class);

        query.setParameter("id", IdMunicipio);
        List<Colonia> colonias = query.getResultList();

        return colonias;
    }
    
    
}