package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return usuarioService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = usuarioService.eliminarUsuario(id);
        if ( ok ){
            return "Se elimino el usuario con id "+ id;
        }else{
            return "No se elimino el usuario con el id "+ id;
        }
    }

    @GetMapping(path = "/query/nombre/{nombre}")
    public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(@PathVariable("nombre") String nombre){
        return usuarioService.obtenerPorNombre(nombre);
    }

    @GetMapping(path = "/query/prioridad/{prioridad}")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@PathVariable("prioridad") Integer prioridad){
        return usuarioService.obtenerPorPrioridad(prioridad);
    }

    @GetMapping(path = "/find")
    public ArrayList<UsuarioModel> obtenerUsuarioPorNombreOrApellido(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido){
        if( apellido.isEmpty()){
            return usuarioService.obtenerPorNombre(nombre);
        }
        return usuarioService.obtenerPorNombreOrApellido(nombre, apellido);
    }
}
