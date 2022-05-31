import java.util.ArrayList;
import java.util.Collections;

public class Carton {
    private ArrayList<Integer> numeros = new ArrayList<Integer>(15);
    
    //Crea cartón con 15 números únicos aleatorios
    public Carton(){
        ArrayList<Integer> numerosPosibles = new ArrayList<Integer>();
        for (int i = 1; i < 91; i++) numerosPosibles.add(i);
        Collections.shuffle(numerosPosibles);
        for (int i=0; i<15; i++) numeros.add(numerosPosibles.get(i));
        
    }

    @Override
    public String toString() {
        String info = "";
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) != 0){
                if (i == numeros.size() - 1) {
                    info += numeros.get(i);
                }else{
                info += numeros.get(i) + " - ";
                }
            }
        }
        return info;
    }

    //Tacha el número del cartón 
    public boolean tacharNumero(int numero) {
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == numero) {
                numeros.remove(i);
                return true;
            }
        }
        return false;
    }

    //Revisa si el cartón está vacio
    public boolean rellenado() {
        if (numeros.size()==0) {
            return true;
        }
        return false;
    }
}
