/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoFinal.Final.repositorios;

import ProyectoFinal.Final.entidades.Trabajo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRepositorio extends JpaRepository<Trabajo, String> {

    @Query("SELECT t FROM Trabajo t WHERE t.estado = :estado")
    public Trabajo buscarTrabajoPorEstado(@Param("estado") String estado);

    @Query("SELECT t FROM Trabajo t WHERE t.calificacion = :calificacion")
    public Trabajo buscarTrabajoPorCalificacion(@Param("calificacion") String calificacion);

    @Query("SELECT t FROM Trabajo t WHERE t.IdCliente = :IdCliente")
    public List<Trabajo> buscarTrabajoPorIdCliente(@Param("IdCliente") String IdCliente);

    @Query("SELECT t FROM Trabajo t WHERE t.IdProveedor = :IdProveedor")
    public List<Trabajo> buscarTrabajoPorIdProveedor(@Param("IdProveedor") String IdProveedor);

}
