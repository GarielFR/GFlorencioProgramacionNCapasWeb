/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.GFlorencioProgramacionNCapasWeb.service;

import com.digis01.GFlorencioProgramacionNCapasWeb.entity.NumerosOperacion;
import com.digis01.GFlorencioProgramacionNCapasWeb.entity.Resultado;

/**
 *
 * @author digis
    */
   public interface IDemoServicio {
       String saludo(String nombre);
       Resultado suma(NumerosOperacion numerosOperacion);
       
   }
