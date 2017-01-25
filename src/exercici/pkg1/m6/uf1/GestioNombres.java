package exercici.pkg1.m6.uf1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

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
                boolean seguir = true;
                
                raf.seek(fitxer.length() - 4);
                int ultimNum = raf.readInt();
                
                
            }

            raf.close();
        } catch (Exception e) {

        }
    }

    /**
     * Poder obtenir el nombre de primer que ocupa una determinada posició.
     *
     * @param posicio
     * @return
     * @throws FileNotFoundException
     */
    public int numeroEnPosicio(int posicio) throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(fitxer, "rw");
        int numPrim = 0;

        for (int i = 0; i < (posicio - 1); i++) {
            raf.readInt(fitxer);
        }

        return numPrim;
    }

    /**
     * Poder conèixer quants nombres primers hi ha emmagatzemats.
     *
     * @return
     * @throws FileNotFoundException
     */
    public int numerosPrimsTotal() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(fitxer, "rw");
        int total = 0;

        return total;
    }

    /**
     * Quin és el valor de l'últim emmagatzemat.
     *
     * @return
     */
    public int ultimNumeroPrim() {
        int ultimPrim = 0;

        return ultimPrim;
    }
}
