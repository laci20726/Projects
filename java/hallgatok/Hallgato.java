import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.io.*;

public final class Hallgato {
    private String nev;
    private String neptun;
    private Map<String,Set<Teljesites>> teljesitesek;             // 1.string felevneve

    
    public Hallgato(String nev, String neptun) throws IllegalArgumentException {
        this.nev = nev;
        this.neptun = neptun;
        this.teljesitesek = new HashMap<>();
        if(this.neptun.length() != 6) {
            throw new IllegalArgumentException("hibas neptun kod");
        } else {
            char ch;
            for (int i = 0; i < 6; i++) {
                ch = this.neptun.charAt(i);
                if(Character.isDigit(ch) == false && Character.isUpperCase(ch) == false) {
                    throw new IllegalArgumentException("hibas neptun kod");
                }
            }
        }
    }
    
    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setNeptun(String neptun) {
        this.neptun = neptun;
    }
    
    
    public String getNeptun() {
        return neptun;
    }
    
    public String getNev() {
        return nev;
    }



    public void beiratkozik(String felevnev) {
        Set<Teljesites> emptyset = Collections.emptySet();
        if(this.teljesitesek.get(felevnev) == null) {
            this.teljesitesek.put(felevnev, emptyset);
        } else {
            System.err.println("nem lehet tobbszor beiratkozni");
        }

    }

    public void teljesiteseketFelvesz(String fileName) {
        ArrayList<String> teljesites = new ArrayList<>();
        Set<Teljesites> uj = new HashSet<>();
        String file = fileName;
        String[] nev = file.split("\\.");
        
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while(scanner.hasNextLine()) {
                teljesites.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Hiba történt: " + e.getMessage());
        }
            
        if(fileName != null){
            for (int i = 0; i < teljesites.size(); i++) {
                String[] adatok = teljesites.get(i).split(";");
                
                Kurzus kurzus = Kurzus.beolvas(adatok[0]);
                Teljesites itk = new Teljesites(kurzus, Integer.parseInt(adatok[1]));
                uj.add(itk);
            }
            this.teljesitesek.put(nev[0], uj);       
        } 
        
    }

    public int bukas(){
        int bukasok = 0;
        for(Entry<String, Set<Teljesites>> map : teljesitesek.entrySet()) {
            for(Teljesites jegy : map.getValue()) {
                if(jegy.erdemjegy() == 1) {
                    bukasok++;
                }
            }
        }
        return bukasok;
    }

    public void felvettKurzusok(String felevNev, String fileName) {
        try (PrintStream printStream = new PrintStream(fileName)) {   
            for(Entry<String, Set<Teljesites>> map : teljesitesek.entrySet()) {
                for(Teljesites kurzusNev : map.getValue()) {
                    if(map.getKey().equals(felevNev)){
                        printStream.println(kurzusNev.kurzus.getNev());
                    }
                   
                }
            }
        } catch (IOException e) {
            System.err.println("Hiba történt: " + e.getMessage());
        }
    }

    public void katasztrofa(String filename) {
        String legtobbB = null;
        int bukasokLeg = 0;
        boolean volteTobb = false;
        
        for(Entry<String, Set<Teljesites>> map : teljesitesek.entrySet()) {
            int bukasokSzama = 0;
            for(Teljesites bukas : map.getValue()) {
                if(bukas.erdemjegy() == 1) {
                    bukasokSzama++;
                }
            }
            if(bukasokSzama > bukasokLeg) {
                legtobbB = map.getKey();
                bukasokLeg = bukasokSzama;
                volteTobb = false;
            } else if (bukasokSzama == bukasokLeg && legtobbB != map.getKey() && bukasokSzama > 0) {
                volteTobb = true;
            }
        }

        try (PrintStream printStream = new PrintStream(filename)) {   
            if(legtobbB != null && volteTobb == true) {
                printStream.println("tobb ilyen felev is van");
            } else if(legtobbB != null && volteTobb == false) {
                printStream.println(legtobbB);
            } else {
                printStream.println("mindent teljesitett");
            }
            
        } catch (IOException e) {
            System.err.println("Hiba történt: " + e.getMessage());
        }
    }
    
    public double diplomaatlag() {
        double atlag = 0;
        double kredit = 0;
        for(Entry<String, Set<Teljesites>> map : teljesitesek.entrySet()) {
            for(Teljesites jegy : map.getValue()) {
                atlag += jegy.kurzus.getKreditertek() * jegy.erdemjegy();
                kredit += jegy.kurzus.getKreditertek();
            }
        }
        return atlag / kredit;
    }

    public static void main(String[] args) {
        
        Hallgato kutya = new Hallgato("kutya", "B0973W");

        kutya.teljesiteseketFelvesz("proba.txt");
    }




}