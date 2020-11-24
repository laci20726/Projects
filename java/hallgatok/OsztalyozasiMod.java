import java.io.*;
import java.util.Scanner;

class OsztalyozasiMod {

    private final int erdemjegyek[] = new int[4];

    public OsztalyozasiMod(int kettes, int harmas, int negyes, int otos) {
        this.erdemjegyek[0] = kettes;
        this.erdemjegyek[1] = harmas;
        this.erdemjegyek[2] = negyes;
        this.erdemjegyek[3] = otos;
    }
 
    public int erdemjegy(int szam) {
        int jegy = 1;
        for (int i = 0; i < erdemjegyek.length; i++) {
            if(szam >= this.erdemjegyek[i]) {
               jegy++;
            }
        }
        return jegy;
    }   

    public static OsztalyozasiMod beolvas(String fajlnev) {
        int[] szamok = new int[4];
        int i = 0;
        try (Scanner scanner = new Scanner(new File(fajlnev))) {
            while(scanner.hasNextLine()) {
                szamok[i] = Integer.parseInt(scanner.nextLine());
                i++;
            }
        } catch (IOException e) {
            System.err.println("Hiba történt: " + e.getMessage());
        }
        OsztalyozasiMod uj = new OsztalyozasiMod(szamok[0],szamok[1],szamok[2],szamok[3]);

        return uj;
    }
    
}