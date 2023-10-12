///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.digis01.GFlorencioProgramacionNCapasWeb.Controller;
//
//import com.digis01.GFlorencioProgramacionNCapasWeb.DAO.TipoinmuebleDAOImplementation;
//import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Tipoinmueble;
//import jakarta.validation.Valid;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// *
// * @author digis
// */
//@Controller
//@RequestMapping("/Inmueble/")
//public class InmuebleController {
//        private TipoinmuebleDAOImplementation tipoinmuebleDAOImplementation;
//        
//        @Autowired//INYECCION DE DEPENDENCIASli
//        public InmuebleController( TipoinmuebleDAOImplementation tipoinmuebleDAOImplementation){
//            this.tipoinmuebleDAOImplementation = tipoinmuebleDAOImplementation;
//        }
//        
//        @GetMapping("Tipoinmueble")
//        private String listamuebles(Model model) {
//                List<Tipoinmueble> Tipoinmuebles = tipoinmuebleDAOImplementation.GetAll();
//         model.addAttribute("Tipoinmuebles", Tipoinmuebles);
//        model.addAttribute("Tipoinmueble", new Tipoinmueble());
//            return "listamuebles";
//        }
//        @GetMapping("/formulario/{idtipoinmueble}")
//    public String Formulario(@PathVariable int idtipoinmueble, Model model){
//        
//        if(idtipoinmueble == 0){  
//            model.addAttribute("tipoinmueble", new Tipoinmueble());
//            return "formularioinmueble";
//        }
//        else {     
//            Tipoinmueble tipoinmueble = tipoinmuebleDAOImplementation.GetById(idtipoinmueble);
//            model.addAttribute("tipoinmueble", tipoinmueble);
//            return "formularioinmueble";
//        }
//    }
//    @PostMapping("/formulario/{idtipoinmueble}")
//    public String Update(@Valid @ModelAttribute ("tipoinmueble") Tipoinmueble tipoinmueble){
//        if(tipoinmueble.getidtipoinmueble()> 0){
//            tipoinmuebleDAOImplementation.Update(tipoinmueble);
//        } else {
//            tipoinmuebleDAOImplementation.Add(tipoinmueble);
//        }
//        return "redirect:/Usuario/Tipoinmueble"; 
//    }
//    
//}
