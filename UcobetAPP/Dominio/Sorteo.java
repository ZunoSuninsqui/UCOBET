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
    private List<Apuesta> apuestasGanadoras;
    private boolean finalizado;

    public Sorteo(int id, List<String> numerosProhibidos,LocalDateTime horaJuego, double incentivo) {
        this.id = id;
        this.horaJuego = horaJuego;
        this.numerosProhibidos = numerosProhibidos;
        this.apuestasRecibidas = new ArrayList<>();
        this.incentivo = incentivo;
        this.recaudo = 0;
        this.finalizado = false;
    }

    public void agregarApuesta(Apuesta apuesta) {
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
                apuestasGanadoras.add(apuesta);
                double premio = ((apuesta.getCantidadApostada()  + (apuesta.getCantidadApostada() * incentivo))* 10000);
                System.out.println("Premio ganado por " + apuesta.getUsuario().getNombre() + " es de: " + premio + " pesos.");
                estimarRecaudo();
            }
        }
    }

    /*public void realizarSorteo() {
        if (this.numeroGanador == null) {
            System.out.println("El número ganador no ha sido escogido");
            return;
        }

        System.out.println("El número ganador es: " + numeroGanador);

        for (Apuesta apuesta : apuestasRecibidas) {
            int matchCount = contarCoincidencias(apuesta.getNumeroApostado(), numeroGanador);
            if (matchCount > 0) {
                apuestasGanadoras.add(apuesta);
                double premio = calcularPremio(apuesta.getCantidadApostada(), matchCount);
                System.out.println("Premio ganado por " + apuesta.getUsuario().getNombre() + " es de: " + premio + " pesos.");
            }
        }
        estimarRecaudo();
    }*/

    public void mostrarApuestasTotales(){
        for (Apuesta ap : apuestasRecibidas){
            System.out.println();
        }

    }

    public double estimarRecaudo() {
       return apuestasRecibidas.stream()
               .mapToDouble(Apuesta::getCantidadApostada)
               .sum();
    }

    private int contarCoincidencias(String apostado, String ganador) {
        int coincidencias = 0;
        for (int i = 0; i < ganador.length(); i++) {
            if (i < apostado.length() && apostado.charAt(i) == ganador.charAt(i)) {
                coincidencias++;
            }
        }
        return coincidencias;
    }

    private double calcularPremio(double cantidadApostada, int coincidencias) {
        double multiplicador = 0;
        switch (coincidencias) {
            case 1:
                multiplicador = 10;
                break;
            case 2:
                multiplicador = 25;
                break;
            case 3:
                multiplicador = 50;
                break;
            case 4:
                multiplicador = 10000;
                break;
        }
        return cantidadApostada * multiplicador;
    }

    /*public double estimarRecaudo() {
        return apuestasRecibidas.stream()
                .mapToDouble(Apuesta::getCantidadApostada)
                .sum();
    }*/

    public void finalizar(){this.finalizado = true;}

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

    public List<Apuesta> getApuestasGanadoras() {
        return apuestasGanadoras;
    }

    public double getIncentivo() {
        return incentivo;
    }
}

