package UcobetAPP.App;

import UcobetAPP.Dominio.Apuesta;
import UcobetAPP.Dominio.Sorteo;
import UcobetAPP.Dominio.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

public class AppUCOBET {
    public static void main(String[] args) {
        Sorteo sorteo = new Sorteo(25,new ArrayList<>(Arrays.asList("2432", "3546")),
                LocalDateTime.of(LocalDate.of(2024, Month.JULY,26),
                        LocalTime.of(20,0)),0.15);
        sorteo.establecerNumeroGanador("2732");
        Usuario user = new Usuario(134,"Nacho","juevesdemotomami@gmail.com","3147635467");
        sorteo.agregarApuesta(new Apuesta(35,user,500, "2732",LocalDateTime.now()));
        sorteo.realizarSorteo();


    }
}
