/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GFlorencioProgramacionNCapasWeb.service;

import com.digis01.GFlorencioProgramacionNCapasWeb.entity.NumerosOperacion;
import com.digis01.GFlorencioProgramacionNCapasWeb.entity.Resultado;
import org.springframework.stereotype.Service;

/**
 *
 * @author digis
 */
public class DemoServiceImplementation implements IDemoServicio {
    
   @Override
   public String saludo (String nombre){
       return "HOla," + nombre;
   }
   @Override
   public Resultado suma(NumerosOperacion numerosOperacion){
       return new Resultado(numerosOperacion.getNumero1() + numerosOperacion.getNumero2());
   }

}
