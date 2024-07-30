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
        historialSorteo.addSorteo(123, Arrays.asList("2876", "4734"),
                LocalDateTime.of(LocalDate.of(2024,7,29),
                        LocalTime.of(18,0)),0.1);

        historialSorteo.addSorteo(456, Arrays.asList("3785", "4856"),
                LocalDateTime.of(LocalDate.of(2024,7,29),
                        LocalTime.of(18,0)),0.1);



        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            clearConsole();
            System.out.println("Menú:");
            System.out.println("1. Mostrar Sorteos");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    historialSorteo.mostrarSorteos();
                    System.out.println("¿Examinar sorteo especifico?");
                    int examinar;
                    System.out.println("1. Si");
                    System.out.println("2. No");
                    examinar = scanner.nextInt();
                    if (examinar == 1){
                        System.out.println("ID del sorteo a examinar : ");
                        int idExaminar;
                        idExaminar = scanner.nextInt();
                        scanner.nextLine();
                        historialSorteo.mostrarSorteoEspecifico(idExaminar);
                        System.out.println("1. Definir numero ganador" );
                        System.out.println("2. Cambiar hora de juego");
                        int menu3;
                        menu3 = scanner.nextInt();
                        switch (menu3) {
                            case 1:
                                System.out.println("Escriba el número ganador: ");
                                String numGanador = scanner.next();
                                historialSorteo.getSorteo(idExaminar).setNumeroGanador(numGanador);
                        }

                    }
                    pause(scanner);
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
    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    public static void pause(Scanner scanner) {
        System.out.println("Presiona Enter para continuar...");
        try {
            scanner.nextLine(); // Consumir cualquier entrada previa
            scanner.nextLine(); // Esperar a que el usuario presione Enter
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
