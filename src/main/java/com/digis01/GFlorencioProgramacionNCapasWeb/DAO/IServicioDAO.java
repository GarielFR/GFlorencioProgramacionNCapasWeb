/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.GFlorencioProgramacionNCapasWeb.DAO;

import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Servicio;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IServicioDAO {
    List<Servicio> GetAll();
    
}
