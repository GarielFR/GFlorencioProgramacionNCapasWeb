/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GFlorencioProgramacionNCapasWeb.restController;

import com.digis01.GFlorencioProgramacionNCapasWeb.entity.NumerosOperacion;
import com.digis01.GFlorencioProgramacionNCapasWeb.entity.Resultado;
import com.digis01.GFlorencioProgramacionNCapasWeb.entity.Saludo;
import com.digis01.GFlorencioProgramacionNCapasWeb.service.DemoServiceImplementation;
import com.digis01.GFlorencioProgramacionNCapasWeb.service.IDemoServicio;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/Api")
public class restController {
     private IDemoServicio demoService;

    @Autowired
    public restController(IDemoServicio demoService) {
        this.demoService = demoService;
    }

    @PostMapping("/saludar")
    public ResponseEntity<Saludo> saludar(@RequestParam String nombre) {
        String saludo = demoService.saludo(nombre); // Llama al método saludo del servicio
        Saludo response = new Saludo(saludo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    private DemoServiceImplementation demoServiceImplementation;
    
    @Autowired
    public restController(DemoServiceImplementation demoServiceImplementation){
        this.demoServiceImplementation = demoServiceImplementation;
    }
    
    @PostMapping("/suma")
	public Resultado suma(@RequestBody NumerosOperacion numeros){
		DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation ();
		return demoServiceImplementation.suma(numeros);
        }
//    @PostMapping("/saludar")
//    public ResponseEntity<Saludo> saludar(@RequestParam String nombre) {
//        String saludo = 
//        Saludo response = new Saludo(saludo);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    
//    @PostMapping("/hOla")
//        public Resultado hOla(@RequestBody Saludo nombre ){
//                DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
//                return demoServiceImplementation.saludo(nombre)
//                
//        }
        
        
    @GetMapping("/saludo")
    public Map<String, Object> Saludo() {
        Map<String,Object> response = new HashMap<>();
        response.put("Saludo", "Hola mundo");
        return response;
    }
}