import java.util.ArrayList;

public class Jugador {

    private String nombreJugador;
    private ArrayList<Carton> cartones;

    /*crear dependiendo de la cantidad de cartones creare una arraylist de 15 de largo y luego creo 15 cartones random
      y los introduzco en la arraylist*/
    public Jugador(String nombre, int cantidadCartones){  

        this.nombreJugador = nombre;
        this.cartones = new ArrayList<Carton>(cantidadCartones);

        for (int i = 0; i < cantidadCartones; i++) {

            Carton nuevoCarton = new Carton();
            cartones.add(nuevoCarton);
            
        }

    }

    private void tacharNumeros(int numero){

        System.out.println("El jugador "+nombreJugador+" ha tachado el número "+numero);

        for (Carton carton : cartones) {

            if(carton.tacharNumero(numero)){
                System.out.println(carton);
            }
            
        }

    }

}
