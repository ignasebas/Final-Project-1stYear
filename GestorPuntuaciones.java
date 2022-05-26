import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class GestorPuntuaciones {
    private static Formatter arch;

    public static void crearPuntuacion(int contador, String nombreGanador) {
        try{
            arch = new Formatter("./puntuacion.txt");
            arch.format("%s %s %s ", 1, nombreGanador, contador);
            System.out.println("Se ha creado correctamente el archivo de puntuaciones");
        }catch(Exception e){
            System.out.println("La creación del archivo de puntuaciones ha fallado");
        }
    }

    public void escribeArchivo(int posicion, String nombre, int puntacion){
        System.out.println("Escribiendo...");
        arch.format("%s %s %s ", posicion, nombre, puntacion);
    }

    public static void cierraArchivo() {
        System.out.println("Reiniciando...");
        arch.close();
    }

    public void leerPuntuacion(){
        
    }

    public static boolean diezAnterior(int contador, String nombreGanador) {

        try{
            File miObj = new File("./puntuacion.txt");
            Scanner miFileBuffer = new Scanner(miObj);
            String posicion, nombre,puntuacion = "";
            int counter = 0;
            boolean cambio = false;
            System.out.println("------------------------------------------");
            System.out.println("");
            System.out.println("TOP 10");
            System.out.println("");
            System.out.println("POSICION\t\tNOMBRE\t\tPUNTUACION");

            while(miFileBuffer.hasNext() && counter < 11){
                posicion = miFileBuffer.next();
                nombre = miFileBuffer.next();
                puntuacion = miFileBuffer.next();
                if (contador >= Integer.parseInt(puntuacion)) {
                    if (cambio == false) {
                        System.out.printf("%s.-\t\t%s\t\t%s\n",posicion,nombreGanador,contador);
                        arch.format("%s %s %s ", posicion,nombreGanador,contador);
                        cambio = true;
                        System.out.printf("%s.-\t\t%s\t\t%s\n",posicion+1,nombre,puntuacion);
                        arch.format("%s %s %s ", posicion+1,nombre,puntuacion);
                    }else{
                        System.out.printf("%s.-\t\t%s\t\t%s\n",posicion+2,nombreGanador,contador);
                        arch.format("%s %s %s ", posicion+2,nombreGanador,contador);
                    }
                }else{
                    System.out.printf("%s.-\t\t%s\t\t%s\n",posicion,nombre,puntuacion);
                }
                counter += 1;
            }
            

            miFileBuffer.close();
            cierraArchivo();
            return false;
            
        }catch(FileNotFoundException e){
            crearPuntuacion(contador,nombreGanador);
            return false;
        }catch (Exception e) {
            System.out.println("Error al leer las puntuaciones");
            return false;
        }
        

    }

    public static void diezNuevo(int contador, String nombreGanador) {
    }
}
