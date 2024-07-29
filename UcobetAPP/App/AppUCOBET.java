package UcobetAPP.App;

import UcobetAPP.Dominio.Apuesta;
import UcobetAPP.Dominio.Sorteo;
import UcobetAPP.Dominio.Usuario;
import UcobetAPP.Dominio.HistorialBase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AppUCOBET {
    public static void main(String[] args) {
        Sorteo sorteo = new Sorteo(25,new ArrayList<>(Arrays.asList("2432", "3546")),
                LocalDateTime.of(LocalDate.of(2024, Month.JULY,26),
                        LocalTime.of(20,0)),0.15);
        sorteo.establecerNumeroGanador("2732");
        Usuario user = new Usuario(134,"Nacho","juevesdemotomami@gmail.com","3147635467");
        sorteo.agregarApuesta(new Apuesta(35,user,500, "2732",LocalDateTime.now()));
        sorteo.realizarSorteo();

        HistorialBase historialSorteo = new HistorialBase();


        // Crear y finalizar algunos sorteos de ejemplo
        Sorteo sorteo1 = new Sorteo(123, Arrays.asList("Ganador 1", "Ganador 2"),
                LocalDateTime.of(LocalDate.of(2024,07,29),
                        LocalTime.of(18,0)),0.1);
        sorteo1.finalizar();
        historialSorteo.addSorteo(sorteo1);

        Sorteo sorteo2 = new Sorteo(456, Arrays.asList("Ganador 3", "Ganador 4"),
                LocalDateTime.of(LocalDate.of(2024,7,29),
                LocalTime.of(18,0)),0.1);
        sorteo2.finalizar();
        historialSorteo.addSorteo(sorteo2);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar historial sorteos");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    historialSorteo.mostrarSorteos();
                    break;
                case 2:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 2);

        scanner.close();


    }
}
