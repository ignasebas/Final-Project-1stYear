import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class GestorPuntuaciones {
    private Formatter arch;

    public void crearPuntucion() {
        try{
            arch = new Formatter("./puntuacion.txt");
            System.out.println("Se ha creado correctamente");
        }catch(Exception e){
            System.out.println("La creación del archivo ha fallado");
        }
    }

    public void escribeArchivo(String nom, String ape, int age){
        System.out.println("Escribiendo...");
        arch.format("%s %s %s ", nom, ape, age);
    }

    public void cierraArchivo() {
        System.out.println("Cerrando...");
        arch.close();
    }

    public void leerPuntuacion(){
        try{
            File miObj = new File("./Sebas.txt");
            Scanner miFileBuffer = new Scanner(miObj);
            while(miFileBuffer.hasNext()){
                String columna1 = miFileBuffer.next();
                String columna2 = miFileBuffer.next();
                String columna3 = miFileBuffer.next();

                System.out.printf("%s %s %s\n",columna1,columna2,columna3);
            }
            miFileBuffer.close();
        }catch(FileNotFoundException e){
            System.out.println("Error al abrir el archivo");
        }
    }
}
