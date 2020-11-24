import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Adminisztracio {

    public void tomegesKatasztrofa(List<Hallgato> lista, String mappaNev) {
        if(mappaNev != null && lista.isEmpty() == false) {
            File tmp = new File(mappaNev);
            tmp.mkdir();    
            
            
            for (Hallgato hallgato : lista) {
                String path = tmp.getPath() +  File.separator + hallgato.getNeptun() + ".student";
                hallgato.katasztrofa(path);   
            }
        }
    }

    public List<Hallgato> hallgatokatFelvesz(String fileName) {
        int pontszam = 0;
        List<Hallgato> ujLista = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while(scanner.hasNextLine()) {
                String sor = scanner.nextLine();
                if(sor.contains("pontszam")) {
                    String[] tomb = sor.split("-");
                    pontszam = Integer.parseInt(tomb[1]);
                } else if(sor.contains("hallgato")) {
                    String[] adatok = sor.split("-");
                    if(Integer.parseInt(adatok[3]) >= pontszam) {
                        Hallgato ujHallgato = new Hallgato(adatok[1], adatok[2]);
                        ujLista.add(ujHallgato);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Hiba történt: " + e.getMessage());
        }

        return ujLista;
    }

    private class HallgatoAtlag {
        private String neptunk;
        private double atlag;

        private HallgatoAtlag(String neptunk, double atlag) {
            this.neptunk = neptunk;
            this.atlag = atlag;
        }
        
    }

    private List<HallgatoAtlag> keres(String mappaNev){

        File dir = new File(mappaNev);

        File[] container = dir.listFiles();
        List<HallgatoAtlag> eredmeny = new ArrayList<>();
        for (int i = 0; i < container.length; i++) {
            if(container[i].getName().endsWith(".student")) {
                try (Scanner scanner = new Scanner(container[i])) {
                    double atlag = 0;
                    String[] neptun = container[i].getName().split("\\.");
                    while(scanner.hasNextLine()) {
                        String szam = scanner.nextLine().replace(",", ".");
                        atlag = Double.parseDouble(szam);    
                    }
                    HallgatoAtlag ujBoi = new HallgatoAtlag(neptun[0], atlag);
                    eredmeny.add(ujBoi);
                } catch (IOException e) {
                    System.err.println("Hiba történt: " + e.getMessage());
                }
            } else if(container[i].isDirectory()){
                String newRoot = mappaNev + File.separator + container[i].getName();
                List<HallgatoAtlag> uj = keres(newRoot);
                eredmeny.addAll(uj);
            }
        }
        return eredmeny;
    } 

    
    public void legjobbHallgato(String mappaNev) {
        List<HallgatoAtlag> alap = keres(mappaNev);
        HallgatoAtlag top = null;
        for (int i = 0; i < alap.size(); i++) {
           HallgatoAtlag keresett = alap.get(i);
           if(top == null) {
               top = keresett;
           } else if(keresett.atlag > top.atlag) {
               top = keresett;
           }
        }
        File dest = new File(mappaNev, "legjobbhallgato.txt");
        try (PrintStream printStream = new PrintStream(dest.getPath())) {   
            String topAtlag = String.valueOf(top.atlag);
            printStream.println(top.neptunk + ";" + topAtlag);
        } catch (IOException e) {
            System.err.println("Hiba történt: " + e.getMessage());
        }
    }

   public static void main(String[] args) {
        List<Hallgato> lista = new ArrayList<>();
        Hallgato egy = new Hallgato("kutya", "B0973W");
        Hallgato ketto = new Hallgato("macska", "B0963W");
        Hallgato harom = new Hallgato("zsíráf", "B0983W");
        Adminisztracio uj = new Adminisztracio();
        lista.add(egy);
        lista.add(ketto);
        lista.add(harom);
        uj.legjobbHallgato("hallgatok/hmmmm");

   }

       

}