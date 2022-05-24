public class Carton {
    int numeros[] = new int [15];
    
    public Carton(){
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)Math.floor(Math.random()*(90-1+1)+1);
        }
    }

    @Override
    public String toString() {
        String info = "";
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] != 0){
                info += numeros[i] + " - ";
                if (i == numeros.length - 1) {
                    info += numeros[i];
                }
            }
        }
        return info;
    }

    public boolean tacharNumero(int numero) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numero) {
                numeros[i] = 0;
                return true;
            }
        }
        return false;
    }
}
