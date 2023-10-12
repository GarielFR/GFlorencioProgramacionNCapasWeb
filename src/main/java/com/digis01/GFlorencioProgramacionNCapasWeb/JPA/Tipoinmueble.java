/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GFlorencioProgramacionNCapasWeb.JPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author digis
 */
@Entity
public class Tipoinmueble {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idtipoinmueble;
    @Basic
        private String nombre;

    public Tipoinmueble() {
    }

    public Tipoinmueble(int idTipoinmueble, String nombre) {
        this.idtipoinmueble = idTipoinmueble;
        this.nombre = nombre;
    }

    public int getidtipoinmueble() {
        return idtipoinmueble;
    }

    public void setidtipoinmueble(int idTipoinmueble) {
        this.idtipoinmueble = idTipoinmueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
