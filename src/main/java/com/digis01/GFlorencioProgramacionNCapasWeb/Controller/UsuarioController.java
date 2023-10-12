/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GFlorencioProgramacionNCapasWeb.Controller;

import ch.qos.logback.classic.pattern.Util;
import com.digis01.GFlorencioProgramacionNCapasWeb.DAO.ColoniaDAOImplementation;
import com.digis01.GFlorencioProgramacionNCapasWeb.DAO.DireccionDAOImplementation;
import com.digis01.GFlorencioProgramacionNCapasWeb.DAO.EstadoDAOImplementation;
import com.digis01.GFlorencioProgramacionNCapasWeb.DAO.MunicipioDAOImplementation;
import com.digis01.GFlorencioProgramacionNCapasWeb.DAO.PaisDAOImplementation;
import com.digis01.GFlorencioProgramacionNCapasWeb.DAO.RolDAOImplementation;
import com.digis01.GFlorencioProgramacionNCapasWeb.DAO.ServicioDAOImplementation;
import com.digis01.GFlorencioProgramacionNCapasWeb.DAO.TipoinmuebleDAOImplementation;
import com.digis01.GFlorencioProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Colonia;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Direccion;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Estado;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Municipio;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Rol;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Servicio;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Tipoinmueble;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.Usuario;
import com.digis01.GFlorencioProgramacionNCapasWeb.JPA.UsuarioDireccion;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/Usuario/")
public class UsuarioController {

    private UsuarioDAOImplementation usuarioDAOImplementation;
    private DireccionDAOImplementation direccionDAOImplementation;
    private RolDAOImplementation rolDAOImplementation;
    private ColoniaDAOImplementation coloniaDAOImplementation;
    private PaisDAOImplementation paisDAOImplementation;
    private EstadoDAOImplementation estadoDAOImplementation;
    private MunicipioDAOImplementation municipioDAOImplementation;
    private TipoinmuebleDAOImplementation tipoinmuebleDAOImplementation;
    private ServicioDAOImplementation servicioDAOImplementation;
    

    @Autowired//INYECCION DE DEPENDENCIAS
    public UsuarioController(UsuarioDAOImplementation usuarioDAOImplementation,
            DireccionDAOImplementation direccionDAOImplementation,
            RolDAOImplementation rolDAOImplementation,
            ColoniaDAOImplementation coloniaDAOImplementation,
            PaisDAOImplementation paisDAOImplementation,
            EstadoDAOImplementation estadoDAOImplementation,
            MunicipioDAOImplementation municipioDAOImplementation,
            TipoinmuebleDAOImplementation tipoinmuebleDAOImplementation,
            ServicioDAOImplementation servicioDAOImplementation) {
        this.usuarioDAOImplementation = usuarioDAOImplementation;
        this.direccionDAOImplementation = direccionDAOImplementation;
        this.rolDAOImplementation = rolDAOImplementation;
        this.coloniaDAOImplementation = coloniaDAOImplementation;
        this.paisDAOImplementation = paisDAOImplementation;
        this.estadoDAOImplementation = estadoDAOImplementation;
        this.municipioDAOImplementation = municipioDAOImplementation;
        this.tipoinmuebleDAOImplementation = tipoinmuebleDAOImplementation;
        this.servicioDAOImplementation = servicioDAOImplementation;
    }

    @GetMapping("listado")
    private String listadoUsuarios(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("");
        usuario.setApellidopaterno("");
        usuario.setApellidomaterno("");
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuario); // recuperación de datos
        model.addAttribute("usuarios", usuarios); //envío de datos para HTML
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuariobusqueda", new Usuario());
        return "listadoUsuarios";
    }

    @PostMapping("listado")
    private String listadoAlumnos(Model model, @ModelAttribute("usuariobusqueda") Usuario usuarioBusqueda) {
        model.addAttribute("usuariobusqueda", (usuarioBusqueda));
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuarioBusqueda); // recuperación de datos
        model.addAttribute("usuarios", usuarios); //envío de datos para HTML
        model.addAttribute("usuario", new Usuario());
        return "listadoUsuarios";
    }

    @GetMapping("Tipoinmueble")
    private String listamuebles(Model model) {
        List<Tipoinmueble> Tipoinmuebles = tipoinmuebleDAOImplementation.GetAll();
        model.addAttribute("Tipoinmuebles", Tipoinmuebles);
        model.addAttribute("Tipoinmueble", new Tipoinmueble());
        return "listamuebles";
    }
     @GetMapping("Servicio")
    private String listaservicios(Model model){
         List<Servicio> servicios = servicioDAOImplementation.GetAll();
         model.addAttribute("servicios", servicios);
         model.addAttribute("Servicio", new Servicio());
         return "listaservicios";
    }
    @GetMapping("/formulario/{idtipoinmueble}")
    public String Formulario(@PathVariable int idtipoinmueble, Model model){
        
        if(idtipoinmueble == 0){  
            model.addAttribute("tipoinmueble", new Tipoinmueble());
            return "formularioinmueble";
        }
        else {     
            Tipoinmueble tipoinmueble = tipoinmuebleDAOImplementation.GetById(idtipoinmueble);
            model.addAttribute("tipoinmueble", tipoinmueble);
            return "formularioinmueble";
        }
    }
    @PostMapping("/formulario/{idtipoinmueble}")
    public String Update(@Valid @ModelAttribute ("tipoinmueble") Tipoinmueble tipoinmueble){
        if(tipoinmueble.getidtipoinmueble()> 0){
            tipoinmuebleDAOImplementation.Update(tipoinmueble);
        } else {
            tipoinmuebleDAOImplementation.Add(tipoinmueble);
        }
        return "redirect:/Usuario/listado"; 
    }
    

    //Metodo update
    @GetMapping("/form/{idusuario}")
    public String Form(@PathVariable int idusuario, Model model) {
//        List<Rol> rol = rolDAOImplementation.GetAll();
//        List<Colonia> colonia= coloniaDAOImplementation.GetAll();
//        model.addAttribute("rol", rol);
//        model.addAttribute("colonia",colonia);
        model.addAttribute("rol", rolDAOImplementation.GetAll());
        model.addAttribute("paises", paisDAOImplementation.GetAll());
        model.addAttribute("estados", estadoDAOImplementation.GetAll());
        model.addAttribute("municipios", municipioDAOImplementation.GetAll());
        model.addAttribute("colonias", coloniaDAOImplementation.GetAll());
        
        if (idusuario == 0) {//ADD
            model.addAttribute("usuariodireccion", new UsuarioDireccion());
            return "formUsuarioEditable";
        } else {//UPDATE
            UsuarioDireccion usuarioDireccion = new UsuarioDireccion();
            usuarioDireccion.setUsuario(usuarioDAOImplementation.GetById(idusuario));
            usuarioDireccion.setDireccion(direccionDAOImplementation.GetByIdUsuario(idusuario));
            
            model.addAttribute("estados", estadoDAOImplementation.GetByIdPais(usuarioDireccion.getDireccion().getEstado().getPais().getIdpais()));
            model.addAttribute("Municipios", municipioDAOImplementation.GetByIdEstado(usuarioDireccion.getDireccion().getColonia().getMunicipio().getEstado().getIdestado()));
            
            return "formUsuarioEditable";
        }
        //getByID --> precargar elforumalrio JPQL   
    }

    @PostMapping("/form")
    public String Update(@Valid @ModelAttribute("usuarioDireccion") UsuarioDireccion usuarioDireccion,
            @RequestParam("imagenFile") MultipartFile imagenFile,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("usuariodireccion", usuarioDireccion);
            return "formUsuarioEditable";
        }
        try {
            if (!imagenFile.isEmpty()) {
                byte[] bytes = imagenFile.getBytes();
                String imagenBase64 = Base64.encodeBase64String(bytes);
                usuarioDireccion.getUsuario().setImagen(imagenBase64);
            } else {
                usuarioDireccion.getUsuario().setImagen(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (usuarioDireccion.getUsuario().getIdusuario() > 0) {//Update
            usuarioDAOImplementation.Update(usuarioDireccion.getUsuario());
        } else {
            int idusuario = usuarioDAOImplementation.Add(usuarioDireccion.getUsuario());

            usuarioDireccion.getDireccion().setUsuario(new Usuario(idusuario));
            direccionDAOImplementation.Add(usuarioDireccion.direccion);
        }
        return "redirect:/Usuario/listado";
    }
    
    
    

    @GetMapping("/GetEstadoByIdPais")
    @ResponseBody
    public List<Estado> GetEstadoByIdPais(@RequestParam("IdPais") int IdPais) {
        List<Estado> estados = estadoDAOImplementation.GetByIdPais(IdPais); // Obtiene los datos del servicio
        return estados;
    }

    @GetMapping("/GetMunicipioByIdEstado")
    @ResponseBody
    public List<Municipio> GetMunicipioByIdEstado(@RequestParam("IdEstado") int IdEstado) {
        List<Municipio> municipios = municipioDAOImplementation.GetByIdEstado(IdEstado); // Obtiene los datos del servicio
        return municipios;
    }

    @GetMapping("/GetColoniaByIdMunicipio")
    @ResponseBody
    public List<Colonia> GetColoniaByIdMunicipio(@RequestParam("IdMunicipio") int IdMunicipio) {
        List<Colonia> colonias = coloniaDAOImplementation.GetByIdMunicipio(IdMunicipio);
        return colonias;
    }

    @GetMapping("/ChangeStatus")
    @ResponseBody
    public void ChangeStatus(@RequestParam("idusuario") int idusuario, @RequestParam("status") boolean status) {
        usuarioDAOImplementation.ChangeStatus(idusuario, status); // Obtiene los datos del servicio
    }

    
    
    
    //Metodo delete
    @GetMapping("/eliminar/{idusuario}")
    public String mostrarFormularioEliminar(@PathVariable int idusuario, Model model) {
        // Obtén el usuario por su ID antes de mostrar el formulario de confirmación
        Usuario usuario = usuarioDAOImplementation.GetById(idusuario);
        model.addAttribute("usuario", usuario);
        return "formulario_eliminar"; // Página de confirmación de eliminación
    }

    @PostMapping("/eliminar/{idusuario}")
    public String eliminarUsuario(@PathVariable int idusuario) {
        // Obtén el usuario por su ID antes de eliminarlo
        Usuario usuario = usuarioDAOImplementation.GetById(idusuario);

        if (usuario != null) {
            // Si se encuentra el usuario, procede a eliminarlo
            usuarioDAOImplementation.Delete(usuario);
        }
        return "redirect:/Usuario/listado"; // Redirige al listado después de la eliminación
    }
}
