import java.util.ArrayList;
import java.util.Random;

public class Partida {

    private ArrayList<Integer> bombo = new ArrayList<Integer>(90);
    private ArrayList<Jugador> jugadores;
  
    //Crear Partida(Bombo y Jugadores)
    public Partida(ArrayList<Jugador> jugadores){
        //números bombo
        this.jugadores = jugadores;
        for (int i = 1; i < 91; i++) {  
            bombo.add(i);
        }
    }

    //Ejecutar turnos(Saca número y cada jugador revisa y modifica su cartón)
    public String turno(String nombreGanador){
        boolean resultado;
        Random numeroRandom = new Random();
        Integer numero = bombo.get(numeroRandom.nextInt(bombo.size()));
        System.out.println("Ha salido el numero :" + numero );
        System.out.println("Los jugadores estan revisando sus cartones");
        for (Jugador jugador : jugadores) {
            resultado = jugador.tacharNumeros(numero);
            if (resultado != false) {
                nombreGanador = jugador.getNombreJugador();
                System.out.println("");
                System.out.println("------------------------------------------");
                System.out.println("Enhorabuena! " + nombreGanador + " has ganado la partida");
                return nombreGanador;
            }
        }
        bombo.remove(numero);
        return "";
    }
}
