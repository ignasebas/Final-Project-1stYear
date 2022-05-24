import java.util.Scanner;

public class Menu {

    public static void menuInicio(Scanner teclado){
        loop: while (true) {
            System.out.println("BIENVENIDO AL BINGO! Selecciona una opción");
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

    public static void crearJugadores(Scanner teclado){
        System.out.println("CREACIÓN DE JUGADOR");
        System.out.println("-------------------");
        System.out.print("Nombre: ");
        String nombreJugador = teclado.nextLine();
        while (true) {
            try {
                System.out.print("Cantidad de cartones: ");
                int cantidadJugador = Integer.parseInt(teclado.nextLine());
                new Jugador(nombreJugador,cantidadJugador);
                break;
            } catch (Exception e) {
                System.out.println("\tError: introduce un numero entero.");
            }
        }
    }

    public static void empezarPartida(Scanner teclado){
        System.out.println("EMPEZANDO PARTIDA");
        System.out.println("-------------------");
        System.out.print("Nombre: ");
        String nombreJugador = teclado.nextLine();
        while (true) {
            try {
                System.out.print("Cantidad de cartones: ");
                int cantidadJugador = Integer.parseInt(teclado.nextLine());
                new Jugador(nombreJugador,cantidadJugador);
                break;
            } catch (Exception e) {
                System.out.println("\tError: introduce un numero entero.");
            }
        }
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        menuInicio(teclado);

    }
}
