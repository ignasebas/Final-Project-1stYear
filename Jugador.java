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

    public String getNombreJugador() {
        return nombreJugador;
    }

    public boolean tacharNumeros(int numero){

        int numeroCartones = 0;

        for (Carton carton : cartones) {
            if(carton.tacharNumero(numero)){
                numeroCartones += 1;
                System.out.println(carton);
            }
            if (carton.rellenado()) {
                return true;
            }
        }
        
        if (numeroCartones != 0) {
            if (numeroCartones > 1) {
                System.out.println("El jugador "+ nombreJugador + " ha tachado el numero " + numero + " en " + numeroCartones + " cartones.");
            }else{
                System.out.println("El jugador "+ nombreJugador + " ha tachado el numero " + numero + " en " + numeroCartones + " carton.");
            }
        }
        return false;
    }

    public void mostrarCartones() {
        System.out.println("Estos son los cartones de " + nombreJugador + ":");
        for (int index = 1; index < cartones.size()+1; index++) {
            System.out.println("\t" + index + ".- " + cartones.get(index-1));
        }
    }

    public void borrarCartones() {
        for (Carton carton : cartones) {
            System.out.println(carton);
            carton = null;
        }
        cartones.clear();
    }

}
