package UcobetAPP.Dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sorteo {
    private int id;
    private LocalDateTime horaJuego;
    private List<String> numerosProhibidos;
    private List<Apuesta> apuestasRecibidas;
    private double recaudo;
    private String numeroGanador;
    private double incentivo;

    public Sorteo(int id, List<String> numerosProhibidos,LocalDateTime horaJuego, double incentivo) {
        this.id = id;
        this.horaJuego = horaJuego;
        this.numerosProhibidos = numerosProhibidos;
        this.apuestasRecibidas = new ArrayList<>();
        this.incentivo = incentivo;
        this.recaudo = 0;
    }

    public void agregarApuesta(Apuesta apuesta) {
        // Que nos debe verificar primero?
        //1 Que el numero no sea prohibido
        //2 La fecha
        //3 El tipo
        if(apuesta.getHoraCreacion().isBefore(LocalDateTime.from(this.horaJuego.minusMinutes(5)))) {
            if (!numerosProhibidos.contains(apuesta.getNumeroApostado())){
                apuestasRecibidas.add(apuesta);
                recaudo += apuesta.getCantidadApostada();
            } else {
                System.out.println("El número que desea apostar está prohibido.");
            }
        } else {
            System.out.println("Muy tarde para jugar.");
        }

    }

    public void establecerNumeroGanador(String numeroGanador) {
        if (numerosProhibidos.contains(numeroGanador)) {
            throw new IllegalArgumentException("El número ganador escogido está entre los números prohibidos.");
        }

        this.numeroGanador = numeroGanador;

    }

    public void realizarSorteo() {
        // Hace falta el reconocimiento de las apuestas con digitos especificos
        // Cómo lo pienso sería mejor una verificación digito a digito con un for each de chars
        if (this.numeroGanador == null){
            System.out.println("El número ganador no ha sido escogido");
        }

        System.out.println("El número ganador es: " + numeroGanador);

        for (Apuesta apuesta : apuestasRecibidas) {
            if (apuesta.getNumeroApostado().equals(numeroGanador)) {
                double premio = ((apuesta.getCantidadApostada()  + (apuesta.getCantidadApostada() * incentivo))* 10000);
                System.out.println("Premio ganado por " + apuesta.getUsuario().getNombre() + " es de: " + premio + " pesos.");
                estimarRecaudo();
            }
        }
    }

    public double estimarRecaudo() {
       return apuestasRecibidas.stream()
               .mapToDouble(Apuesta::getCantidadApostada)
               .sum();
    }

    public int getId() {
        return id;
    }

    public String getNumeroGanador() {
        return numeroGanador;
    }

    public void setNumeroGanador(String numeroGanador) {
        this.numeroGanador = numeroGanador;
    }

    public void setRecaudo(long recaudo) {
        this.recaudo = recaudo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getHoraJuego() {
        return horaJuego;
    }

    public void setHoraJuego(LocalDateTime horaJuego) {
        this.horaJuego = horaJuego;
    }

    public List<String> getNumerosProhibidos() {
        return numerosProhibidos;
    }

    public void setNumerosProhibidos(List<String> numerosProhibidos) {
        this.numerosProhibidos = numerosProhibidos;
    }

    public List<Apuesta> getApuestasRecibidas() {
        return apuestasRecibidas;
    }

    public void setApuestasRecibidas(List<Apuesta> apuestasRecibidas) {
        this.apuestasRecibidas = apuestasRecibidas;
    }

    public double getRecaudo() {
        return recaudo;
    }

    public void setRecuado(long recaudo) {
        this.recaudo = recaudo;
    }
}

