import java.util.ArrayList;
import java.util.List;


public class Megye {

    private String nev;
    private List<Telepules> telepulesek;
    private String web = "";

    public Megye(String nev) {
        this.nev = nev;
        this.telepulesek = new ArrayList<>();
    }

    public boolean ujTelepules(String nev) {
        int kettospont = 0;
        boolean sikere = false;
        for (int i = 0; i < nev.length(); i++) {
            if(nev.charAt(i) == ':') {
                kettospont++;
            }
        }
        if(kettospont > 1){
            sikere = true;
            String[] darabolt = nev.split(":");
            Telepules uj;
            try {
                uj = new Telepules(darabolt[0], Double.valueOf(darabolt[1]));
                uj.emailFrissitese(darabolt[2]);
            } catch (TelepuleskezeloException exp) {
                uj = null;
                sikere = false;
            }

            if(sikere == true) {
                this.telepulesek.add(uj);
            }

            return sikere;
        }
        return sikere;
    }

    public void webcimFrissites(String webcim){
        String alap = webcim.toLowerCase();
        String parosito = this.nev.toLowerCase();
        
        if(alap.contains(parosito)) {
            this.web = webcim;
        } else {
            throw new IllegalArgumentException("Hibas webcim: " + webcim);
        }
    }

    public void ujLakok (int hanyadik, String kerulet, int hanyan) {
        if(hanyadik >= this.telepulesek.size() || hanyadik < 0) {
            throw new IllegalArgumentException("Nem letezik a megadott indexu varos!");
        } else {
            try{
            this.telepulesek.get(hanyadik).ujLakok(kerulet, hanyan);
            } catch (TelepuleskezeloException tele) {
                throw new IllegalArgumentException( this.telepulesek.get(hanyadik).getNev() + " varosban nem letezik a megadott kerulet!", tele);
            }
        }
    }

    public int keres(String mit) {
        int mennyi = 0;
        for (int i = 0; i < this.telepulesek.size(); i++) {
            if(this.telepulesek.get(i).getNev().contains(mit)) {
                mennyi++;
            }
        }

        return mennyi;
    }

    public int lakossag() {
        int osszeg = 0;
        for (int i = 0; i < this.telepulesek.size(); i++) {
            osszeg += this.telepulesek.get(i).getLakosokSzama();
        }

        return osszeg;
    }

    @Override
    public String toString() {
        
        return this.nev +  " megye (" + this.web + ")";
    }

    
    public static void main(String[] args) {
        String testCase = "Kutya:201:301.1:valami@valami.hu";
        Megye ujMegye = new Megye("bacs");

        ujMegye.ujTelepules(testCase);

    }
}

