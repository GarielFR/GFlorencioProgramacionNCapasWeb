/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GFlorencioProgramacionNCapasWeb.JPA;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author digis
 */
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idusuario;
    @Basic
        private String username;
        private String nombre;
        private String apellidopaterno;
        private String apellidomaterno;
        private String email;
        private String password;
        private String sexo;
        private String telefono;
        private String celular;
        private String curp;
        private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    
        
    
        
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
        private Date fechanacimiento;
    
    @ManyToOne// muchos usuarios tienen un mismo rol
    @JoinColumn (name = "idrol")//columna con la llave foranea 
    private Rol rol;
    
//    @ManyToOne// muchos usuarios tienen un mismo rol
//    @JoinColumn (name = "idcolonia")//columna con la llave foranea 
//    private Colonia colonia;
    @Lob
    private String imagen;
    
     public Usuario(){
    }
     
    public Usuario(int idusuario){
        this.idusuario = idusuario;
    } 

    public Usuario(String username, String nombre, String apellidopaterno, String apellidomaterno, String email, String password, String sexo, String telefono, String celular, String curp, Date fechanacimiento, Rol rol) {
        this.username = username;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.fechanacimiento = fechanacimiento;
        this.rol = rol;
    }

    public Usuario(int idusuario, String username, String nombre, String apellidopaterno, String apellidomaterno, String email, String password, String sexo, String telefono, String celular, String curp, Date fechanacimiento, Rol rol) {
        this.idusuario = idusuario;
        this.username = username;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.fechanacimiento = fechanacimiento;
        this.rol = rol;
//        this.imagen = imagen;
    }

    public Usuario(int idusuario, String username, String nombre, String apellidopaterno, String apellidomaterno, String email, String password, String sexo, String telefono, String celular, String curp, Date fechanacimiento) {
        this.idusuario = idusuario;
        this.username = username;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.fechanacimiento = fechanacimiento;
    }
    
     
//    public Usuario(int idusuario, String username, String nombre, String apellidopaterno, String apellidomaterno, String email, String password, String sexo, String telefono, String celular, String curp, Date fechanacimiento, Rol rol) {
//        this.idusuario = idusuario;
//        this.username = username;
//        this.nombre = nombre;
//        this.apellidopaterno = apellidopaterno;
//        this.apellidomaterno = apellidomaterno;
//        this.email = email;
//        this.password = password;
//        this.sexo = sexo;
//        this.telefono = telefono;
//        this.celular = celular;
//        this.curp = curp;
//        this.fechanacimiento = fechanacimiento;
//        this.rol = rol;
//        //this.colonia = colonia;
//    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public int getidusuario(){
        return idusuario;
    }
    
    public void setidusuario(int idusuario){
        this.idusuario = idusuario;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
//    public Colonia getColonia(){
//        return colonia;
//    }
//    public void setColonia(Colonia colonia){
//        this.colonia= colonia;
//    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        
    }

    public String getApellidopaterno() {
        return apellidopaterno;
        
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
        
    }

    public String getApellidomaterno() {
        return apellidomaterno;
        
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
        
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
        
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
        
    }

    
}