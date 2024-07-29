package UcobetAPP.Dominio;

import java.util.ArrayList;
import java.util.List;

public class HistorialBase {





    /*
    Para El historial propondría 1 lista solamente de sorteos
    el admin podrá acceder a los sorteos, el mayor problema es establecer una relación
    entre la lista de sorteos que participó el usuario, y la lista de apuestas,
    Siento que con la forma con la que estamos haciendolo, vamos a tener que usar 2 ID
    pero tengo la sensación de que se puede resumir a uno sólo pero aun no estoy seguro cómo

    imagina la relacilión:

    Responsable = admin = Alguién con el permiso de acceder a la información completa

    1 Se necesita una forma para que un responsable de UCObet pueda ver el historial de sortoes
    se le presenta una lista de sorteos, y si se selecciona un sorteo la lista completa de participaciones
    se mostrará

    2 Para el usuario se necesita una forma, más simple. con una idea directa de poder ver solamente las apuestas
    con un pequeño espacio para ver la info del sorteo; numero ganador y fecha de juego, si ganó o no

    O podría hacerse del mismo modo anteirior una lista de sorteos en las que participó, y seleccionar,
    el sorteo para acceder a su info de apuesta

    Aquí el problema es las relaciones

    1. Admin---ListaSorteos---ListaApuestas

    2.1. Usuario---Lista Apuestas Hechas ---Sorteo De Las Apuesta

    2.2. Usuario---Lista de sorteos donde participó --- lista de apuestas que hizo por el mismo sorteo

     */





    private int id;
    private List<Sorteo> historialSorteo;

    public HistorialBase(){
        this.historialSorteo = new ArrayList<Sorteo>();

    }
    public void mostrarSorteos(){
        if (!this.historialSorteo.isEmpty()){
            for(Sorteo sor : this.historialSorteo){
                System.out.println("ID : " + sor.getId());
                System.out.println("Número Ganador : " + sor.getNumeroGanador());
                System.out.println("Hora de juego : " + sor.getHoraJuego());
                System.out.println("Recaudo  : "+ sor.getRecaudo());
                System.out.println("-----------------------------------------");
            }
        } else{
            System.out.println("Lista Vacía");
        }

    }
    public void addSorteo(Sorteo sorteoNuevo){
        this.historialSorteo.add(sorteoNuevo);
    }

    }
