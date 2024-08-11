package UcobetAPP.App;

import UcobetAPP.Dominio.Apuesta;
import UcobetAPP.Dominio.Sorteo;
import UcobetAPP.Dominio.Usuario;
import UcobetAPP.Dominio.HistorialBase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppUCOBET {
    public static void main(String[] args) {
        /*Sorteo sorteo = new Sorteo(25,new ArrayList<>(Arrays.asList("2432", "3546")),
                LocalDateTime.of(LocalDate.of(2024, Month.JULY,26),
                        LocalTime.of(20,0)),0.15);
        sorteo.establecerNumeroGanador("27132");
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
*/

        HistorialBase historialSorteo = new HistorialBase();
        Scanner scanner = new Scanner(System.in);

        boolean opcionMenuSalida;


        boolean opcionAdminUsuarioValida = true;
        do {
            clearConsole();
            System.out.println("Seleccionar tipo de usuario. ");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3 Salir");
            char opcionAdminUsuario = scanner.next().charAt(0);
            scanner.nextLine();
            if (opcionAdminUsuario == '1') {
                boolean opcionAdminValida = true;
                do {
                    clearConsole();
                    System.out.println("Menú:");
                    System.out.println("1. Crear Sorteo");
                    System.out.println("2. Mostrar Sorteos");
                    System.out.println("1. Mostrar Sorteos");
                    System.out.println("2. Volver");
                    System.out.print("Elige una opción: ");
                    char opcionAdmin = scanner.next().charAt(0);
                    scanner.nextLine();
                    switch (opcionAdmin) {

                        case '1':
                            System.out.println("Crear Sorteo:");

                            int idSorteo;
                            while (true) {
                                System.out.print("Ingrese el ID del sorteo: ");
                                String idInput = scanner.nextLine();
                                if (idInput.matches("\\d+")) { // Verifica que solo contenga dígitos
                                    idSorteo = Integer.parseInt(idInput);
                                    break;
                                } else {
                                    System.out.println("Ingrese un valor válido.");
                                }
                            }

                            List<String> numerosProhibidos = new ArrayList<>();
                            char agregarNumero;
                            do {
                                System.out.print("¿Desea añadir un número prohibido? (s/n): ");
                                agregarNumero = scanner.next().charAt(0);
                                scanner.nextLine(); // Limpia el buffer
                                if (agregarNumero == 's' || agregarNumero == 'S') {
                                    while (true) {
                                        System.out.print("Ingrese el número prohibido (máximo 4 dígitos): ");
                                        String numeroProhibido = scanner.nextLine();
                                        if (numeroProhibido.matches("\\d{1,4}")) { // Verifica que el número tenga entre 1 y 4 dígitos
                                            numerosProhibidos.add(numeroProhibido);
                                            break;
                                        } else {
                                            System.out.println("Ingrese un valor válido.");
                                        }
                                    }
                                }
                            } while (agregarNumero == 's' || agregarNumero == 'S');

                            LocalDateTime horaJuego;
                            while (true) {
                                try {
                                    System.out.print("Ingrese la fecha y hora del juego (dd-MM-yyyy HH:mm): ");
                                    String fechaInput = scanner.nextLine();
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                                    horaJuego = LocalDateTime.parse(fechaInput, formatter);
                                    break;
                                } catch (DateTimeParseException e) {
                                    System.out.println("Ingrese un valor válido.");
                                }
                            }

                            double incentivo = 0.0;
                            System.out.print("Ingrese el incentivo en porcentaje (0-100) o presione Enter para omitir: ");
                            String incentivoInput = scanner.nextLine();
                            if (!incentivoInput.isEmpty()) {
                                try {
                                    double porcentaje = Double.parseDouble(incentivoInput);
                                    if (porcentaje >= 0 && porcentaje <= 100) {
                                        incentivo = porcentaje / 100;
                                    } else {
                                        System.out.println("Ingrese un valor válido.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Ingrese un valor válido.");
                                }
                            }

                            // Crear el sorteo con los datos ingresados
                            Sorteo nuevoSorteo = new Sorteo(idSorteo, numerosProhibidos, horaJuego, incentivo);
                            System.out.println("Sorteo creado exitosamente.");
                            pause(scanner);
                            break;
                        case '2':
                            boolean opcionExaminarValida = true;
                            do {
                                clearConsole();
                                historialSorteo.mostrarSorteos();
                                System.out.println("¿Examinar sorteo especifico?");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                char opcionExaminar = scanner.next().charAt(0);
                                scanner.nextLine();
                                switch (opcionExaminar) {
                                    case '1':
                                        boolean idSorteoValida = false;
                                        do {
                                            clearConsole();
                                            System.out.println("ID del sorteo a examinar : ");
                                            String idExaminar = scanner.next();
                                            scanner.nextLine();
                                            if (idExaminar.matches("\\d+")) {
                                                int idNumerico = Integer.parseInt(idExaminar);
                                                historialSorteo.mostrarSorteoEspecifico(idNumerico);
                                                idSorteoValida = true;
                                                char opcionParaSorteo;
                                                boolean opcionParaSorteoValido = true;
                                                do {
                                                    clearConsole();
                                                    System.out.println("1. Definir numero ganador");
                                                    System.out.println("2. Cambiar hora de juego");
                                                    System.out.println("3. Salir");
                                                    opcionParaSorteo = scanner.next().charAt(0);

                                                    switch (opcionParaSorteo) {
                                                        case '1':
                                                            boolean numGanadorValido = false;
                                                            do {
                                                                clearConsole();
                                                                System.out.println("Escriba el número ganador: ");
                                                                String numGanador = scanner.next();
                                                                if (numGanador.matches("\\d+") && numGanador.length() <= 4) {
                                                                    historialSorteo.getSorteo(idNumerico).setNumeroGanador(numGanador);
                                                                    numGanadorValido = true;
                                                                } else {
                                                                    System.out.println("Ingrese un número válido. ");
                                                                    pause(scanner);
                                                                }
                                                            } while (!numGanadorValido);
                                                            break;
                                                        case '2':

                                                            break;

                                                        case '3':
                                                            opcionParaSorteoValido = false;
                                                            break;

                                                        default:
                                                            System.out.println("Seleccione una opción válida. ");
                                                            pause(scanner);
                                                            break;


                                                    }
                                                } while (opcionParaSorteoValido);
                                            } else {

                                            }

                                        } while (!idSorteoValida);
                                        break;

                                    case '2':
                                        opcionExaminarValida = false;
                                        break;
                                    default:

                                        break;
                                }
                            } while (opcionExaminarValida);
                            pause(scanner);
                            break;
                        case '3':
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opción no válida. Inténtalo de nuevo.");
                            pause(scanner);
                            break;
                    }
                } while (opcionAdminValida);
            } else if (opcionAdminUsuario == '2') {


            } else if (opcionAdminUsuario == '3') {
                opcionAdminUsuarioValida = false;
            } else {
                System.out.println("Seleccione una opción válida");
                pause(scanner);
            }
        } while (opcionAdminUsuarioValida);


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
