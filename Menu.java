import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static ArrayList<Jugador> jugadores  = new ArrayList<Jugador>();

    public static void menuInicio(Scanner teclado){
        loop: while (true) {
            System.out.println("\n------------------------------------------");
            System.out.println("BIENVENIDO AL BINGO! Seleccione una opción");
            System.out.println("------------------------------------------");
            System.out.println("1.Introducir nuevo jugador");
            System.out.println("2.Iniciar partida");
            System.out.println("3.Salir");
            try {
                int opcion = Integer.parseInt(teclado.nextLine());
                switch (opcion) {
                    case 1:
                        crearJugadores(teclado);
                        break;
                    case 2:
                        empezarPartida(teclado);
                        break;
                    case 3:
                        System.out.println("\tSaliendo...");
                        break loop;
                    default:
                        System.out.println("\tIntroduce una opción valida. (1 o 2)");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\tPorfavor, introduce un numero entre el 1 y el 2.");
            }
        }
        
    }

    //creación del Jugadores con sus cartones y nombres
    public static void crearJugadores(Scanner teclado){
        System.out.println("-------------------");
        System.out.println("CREACIÓN DE JUGADOR");
        System.out.println("-------------------");
        System.out.print("Nombre: ");
        String nombreJugador = teclado.nextLine();
        while (true) {
            try {
                System.out.print("Cantidad de cartones: ");
                int cantidadJugador = Integer.parseInt(teclado.nextLine());
                jugadores.add(new Jugador(nombreJugador,cantidadJugador));
                break;
            } catch (Exception e) {
                System.out.println("\tError: introduce un numero entero.");
            }
        }
    }

    //inicio de Partida
    public static void empezarPartida(Scanner teclado){
        if(jugadores.size()==0){
            return;
        }
        System.out.println("-----------------");
        System.out.println("EMPEZANDO PARTIDA");
        System.out.println("-----------------");
        Partida partidaActual = new Partida(jugadores);
        for (Jugador jugador : jugadores) {
            jugador.mostrarCartones();
        }
        String nombreGanador = "";
        int contador = 0;

        //Cada ronda de la partida
        while (true) {
            contador += 1;
            System.out.println("-    -   -   -   -   -   -");
            System.out.println("RONDA: " + contador);
            nombreGanador = partidaActual.turno(nombreGanador);
            if (nombreGanador != "") {
                break;
            }
            teclado.nextLine();
        }

        //Puntuación y Ganador
        System.out.println("Ha conseguido ganar en " + contador + " turnos.");
        contador = 90-contador;
        System.out.println("Ha conseguido una puntuación de " + contador + " puntos.");
        System.out.println("------------------------------------------");
        System.out.println("");

        //Top 10 
        GestorPuntuaciones.diezAnterior(contador,nombreGanador);
        
        //Reinicio de partida
        for (Jugador jugador : jugadores) {
            jugador.borrarCartones();
            jugador=null;
        }
        jugadores.clear();
        
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        menuInicio(teclado);

    }
}
