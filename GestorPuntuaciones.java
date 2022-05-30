import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class GestorPuntuaciones {
    private static Formatter arch;

    private static int[] puntuacionTop10 = new int[10];
    private static String[] nombresTop10 = new String[10];

    public static void crearPuntuacion(int contador, String nombreGanador) {
        try{
            arch = new Formatter("./puntuacion.txt");
            arch.format("%s\n", nombreGanador);
            arch.format("%s\n", contador);
            for (int index = 2; index < 11; index++) {
                arch.format("%s\n", "-");
                arch.format("%s\n", 0);
            }
            System.out.println("Se ha creado correctamente el archivo de puntuaciones");
            arch.close();
        }catch(Exception e){
            System.out.println("La creación del archivo de puntuaciones ha fallado");
        }
    }

    public static void actualizarArchivo(){
        try{
            arch = new Formatter("./puntuacion.txt");
            for (int index = 0; index < 10; index++) {
                arch.format("%s\n", nombresTop10[index]);
                arch.format("%s\n", puntuacionTop10[index]);
            }
            System.out.println("Se ha actualizado correctamente el archivo de puntuaciones");
            arch.close();
        }catch(Exception e){
            System.out.println("La actualización del archivo de puntuaciones ha fallado");
        }
    }

    public static void cierraArchivo() {
        System.out.println("Reiniciando...");
        arch.close();
    }

    public static void diezAnterior(int contador, String nombreGanador) {
        System.out.println("Nombre Ganador es: " + nombreGanador);
        try{
            File miObj = new File("./puntuacion.txt");
            Scanner miFileBuffer = new Scanner(miObj);
            String nombre,puntuacion = "";
            int counter = 1;
            boolean cambio = false;
            System.out.println("------------------------------------------");
            System.out.println("");
            System.out.println("TOP 10");
            System.out.println("");
            System.out.println("POSICION\t\tNOMBRE\t\t\tPUNTUACION");

            while(miFileBuffer.hasNext() && counter < 12){
                nombre = miFileBuffer.nextLine();
                puntuacion = miFileBuffer.nextLine();
                
                try {
                    if (contador >= Integer.parseInt(puntuacion)) {
                        if (cambio == false) {
                            nombresTop10[counter-1] = nombreGanador;
                            puntuacionTop10[counter-1] = contador;
                            System.out.printf("%s.-\t\t\t%s\t\t\t%s\n",counter,nombreGanador,contador);

                            cambio = true;
                            
                            nombresTop10[counter] = nombre;
                            puntuacionTop10[counter] = Integer.parseInt(puntuacion);
                            System.out.printf("%s.-\t\t\t%s\t\t\t%s\n",counter+1,nombre,puntuacion);

                        }else{
                            nombresTop10[counter] = nombre;
                            puntuacionTop10[counter] = Integer.parseInt(puntuacion);
                            System.out.printf("%s.-\t\t\t%s\t\t\t%s\n",counter+1,nombre,puntuacion);
                        }
                    }else{
                        nombresTop10[counter-1] = nombre;
                        puntuacionTop10[counter-1] = Integer.parseInt(puntuacion);
                        System.out.printf("%s.-\t\t\t%s\t\t\t%s\n",counter,nombre,puntuacion);
                    }
                    counter += 1;

                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
            miFileBuffer.close();
            actualizarArchivo();
            cierraArchivo();
            
        }catch(FileNotFoundException e){
            crearPuntuacion(contador,nombreGanador);
        }catch(Exception e){
            System.out.println("Error al leer las puntuaciones.");
        }
        
        

    }
}
