/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interivalle.Modelo;

/**
 *
 * @author mary_
 */
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "servicios_acotizar")
public class ServiciosACotizar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitud;

    @ManyToOne
    @JoinColumn(name = "correo_usuario")
    private Usuario usuario;

    @Column(name="tipo_solicitud")
    private String tipoSolicitud;

    @Column(name="fecha_visita")
    private LocalDate fechaVisita;

    @Column(name="hora_visita")
    private String horaVisita;

    @Column(name="lugar_visita")
    private String lugarVisita;

    @Column(name="fecha_solicitud")
    private LocalDate fechaSolicitud = LocalDate.now();

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<ServiciosDetalle> detalles;

    // ===== Getters y Setters correctos =====

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public LocalDate getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDate fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }

    public List<ServiciosDetalle> getDetalles() { return detalles; }
    public void setDetalles(List<ServiciosDetalle> detalles) { this.detalles = detalles; }
}

