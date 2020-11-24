import java.io.*;
import java.util.Scanner;

public class Kurzus {
    private String kurzuskod;
    private String nev;
    private int maxpont;
    private int kreditertek;
    private OsztalyozasiMod osztalyozasiMod;

    public String getKurzuskod() {
        return kurzuskod;
    }

    public String getNev() {
        return nev;
    }

    public int getMaxpont() {
        return maxpont;
    }

    public int getKreditertek() {
        return kreditertek;
    }

    public OsztalyozasiMod getOsztalyozasiMod() {
        return osztalyozasiMod;
    }

    public Kurzus(String kurzuskod, String nev, int maxpont, OsztalyozasiMod osztalyozasiMod, int kreditertek) {
        this.kurzuskod = kurzuskod;
        this.nev = nev;
        this.maxpont = maxpont;
        this.osztalyozasiMod = osztalyozasiMod;
        this.kreditertek = kreditertek;
    }

    public static Kurzus beolvas(String fajlnev) {
        String adatok = null;
        String filename = null;
        int i = 0;
        try (Scanner scanner = new Scanner(new File(fajlnev))) {
            while(scanner.hasNextLine()) {
                if(i == 0) {
                    adatok = scanner.nextLine();
                    i++;
                } else {
                    filename = scanner.nextLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Hiba történt: " + e.getMessage());
        }
        String[] adatokTomb = adatok.split(";");
        OsztalyozasiMod mod = OsztalyozasiMod.beolvas(filename);
        Kurzus uj = new Kurzus(adatokTomb[0], adatokTomb[1], Integer.parseInt(adatokTomb[2]), mod, Integer.parseInt(adatokTomb[3]));
        return uj;

    }

    

}