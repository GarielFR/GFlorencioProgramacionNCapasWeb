/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GFlorencioProgramacionNCapasWeb.DAO;

import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Tipoinmueble;
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
public class TipoinmuebleDAOImplementation implements ITipoinmuebleDAO {    
    private EntityManager entityManager;
    @Autowired//inyeccion de independencias 
    public TipoinmuebleDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Tipoinmueble> GetAll() {

        TypedQuery<Tipoinmueble> query = entityManager.createQuery("FROM Tipoinmueble", Tipoinmueble.class);
        List<Tipoinmueble> Tipoinmuebles = query.getResultList();
        return Tipoinmuebles;
    }
    @Override
    @Transactional
    public int Add( Tipoinmueble tipoinmueble) {
        entityManager.persist(tipoinmueble);
        return tipoinmueble.getidtipoinmueble();
    }

    @Override
    public Tipoinmueble GetById(int tipomueble) {
        //JPQL
        TypedQuery<Tipoinmueble> query = entityManager.createQuery("FROM Usuario WHERE idtipoinmueble=:tipomueble", Tipoinmueble.class);
        query.setParameter("idtipoinmueble", tipomueble);

        return query.getSingleResult();
    }
    @Override
    @Transactional
    public void Update(Tipoinmueble tipoinmueble) {
        entityManager.merge(tipoinmueble);
    }
}
