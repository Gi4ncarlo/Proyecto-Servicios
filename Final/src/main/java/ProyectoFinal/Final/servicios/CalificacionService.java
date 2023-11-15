/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoFinal.Final.servicios;

import ProyectoFinal.Final.entidades.Calificacion;
import ProyectoFinal.Final.excepciones.miException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ProyectoFinal.Final.repositorios.CalificacionRepositorio;


@Service
public class CalificacionService {
    
    
    @Autowired
    private CalificacionRepositorio caliRepo;
    
    @Transactional
    public void registrarCalificacion(String comentario, Integer puntaje) throws miException {
        validar(comentario, puntaje);

        Calificacion cali = new Calificacion();

        cali.setPuntaje(puntaje);
        cali.setComentario(comentario);
      

        caliRepo.save(cali);

    }
    
    @Transactional
    public void eliminarCalificacion(String id) throws miException {

        if (id == null || id.isEmpty()) {
            throw new miException("El id ingresado no es correcto");
        }

        caliRepo.deleteById(id);

    }
    
    public void validar(String comentario, Integer puntaje) throws miException{
        
        if(comentario.isEmpty() || comentario.length() < 20){
            throw new miException("El comentario debe tener por lo menos 20 caracteres."); //el comentario tiene que existir? o puede mandarse vacio
        }
        
        if(puntaje < 0 || puntaje == null){
            throw new miException("Ingrese un valor entre 0 y 5 incluidos");
        }
        
        
    }
    
}