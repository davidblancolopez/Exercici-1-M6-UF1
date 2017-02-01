package exercici.pkg1.m6.uf1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class GestioNombres {

    File fitxer = new File("C:\\proves\\Execici1");

    /**
     * Generar el següent nombre primer, a continuació de l'últim emmagatzemat
     * en un fitxer i afegir-lo a aquest.
     *
     * @throws FileNotFoundException
     */
    public void generarNextNombre() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(fitxer, "rw");
        try {
            if (fitxer.length() == 0) {
                
            } else {

                raf.seek(fitxer.length() - 4);
                int ultimNum = raf.readInt();

                int numeroPrimSeguent = calculNumeroPrim(ultimNum);
                raf.seek(fitxer.length());
                raf.writeInt(numeroPrimSeguent);
            }

            raf.close();
        } catch (Exception e) {

        }
    }

    /**
     * Metode que s'encarrega de realitzar el calcul de numeros prims.
     *
     * @param contador
     * @return
     */
    public int calculNumeroPrim(int contador) {
        boolean seguir = true;
        int num = 0;
        do {
            if ((contador + 1) % 2 == 0) {
                num = contador + 1;
                seguir = false;
            }
            contador++;
        } while (seguir);
        return num;
    }

    /**
     * Poder obtenir el nombre de primer que ocupa una determinada posició.
     *
     * @param posicio
     * @return
     * @throws FileNotFoundException
     */
    public int numeroEnPosicio(int posicio) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(fitxer, "rw");
        int numPrim = 0;

        int posicioNumero = (posicio * 4) - 4;

        raf.seek(posicioNumero);

        numPrim = raf.readInt();

        raf.close();
        return numPrim;
    }

    /**
     * Poder conèixer quants nombres primers hi ha emmagatzemats.
     *
     * @return
     * @throws FileNotFoundException
     */
    public long numerosPrimsTotal() throws FileNotFoundException {

        long total = 0;

        total = fitxer.length() / 4;

        return total;
    }

    /**
     * Quin és el valor de l'últim emmagatzemat.
     *
     * @return
     */
    public int ultimNumeroPrim() throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(fitxer, "rw");
        int ultimPrim = 0;

        raf.seek(fitxer.length() - 4);
        ultimPrim = raf.readInt();

        raf.close();
        return ultimPrim;
    }

    /**
     * Poder cercar en el fitxer de primers, els nombres primers existents entre
     * dos valors donats.
     *
     * @param num1
     * @param num2
     */
    public ArrayList mostrarNumerosEntre2(int num1, int num2) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(fitxer, "rw");

        raf.seek(0);
        ArrayList entreValores = new ArrayList<>();
        boolean prim = true;
        boolean seg = true;

        while (prim) {
            int comparar = raf.readInt();

            if (num1 >= comparar) {
                entreValores.add(comparar);
                while (seg) {

                    int comparar2 = raf.readInt();

                    if (num2 >= comparar2) {
                        seg = false;
                    } else {
                        entreValores.add(comparar);
                    }

                }
                prim = false;
            }

        }
        raf.close();
        
        
        return entreValores;
    }
}
