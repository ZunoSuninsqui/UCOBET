package UcobetAPP.Dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Apuesta {
    private int id;
    private Usuario usuario;
    private String numeroApostado;
    private double cantidadApostada;
    private String tipo;
    private LocalDateTime horaCreacion;

    public Apuesta(int id, Usuario usuario, long cantidadApostada, String numeroApostado, LocalDateTime horaCreacion) {
        this.id = id;
        this.usuario = usuario;
        this.cantidadApostada = cantidadApostada;
        this.numeroApostado = numeroApostado;
        this.horaCreacion = horaCreacion;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario1) {
        this.usuario = usuario1;
    }

    public double getCantidadApostada() {
        return cantidadApostada;
    }

    public void setCantidadApostada(long cantidadApostada) {
        this.cantidadApostada = cantidadApostada;
    }

    public String getNumeroApostado() {
        return numeroApostado;
    }

    public void setNumeroApostado(String numeroApostado) {
        this.numeroApostado = numeroApostado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public LocalDateTime getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(LocalDateTime horaCreacion) {
        this.horaCreacion = horaCreacion;
    }
}
