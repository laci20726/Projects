import java.util.ArrayList;
import java.util.List;

public class Telepules {

    private String nev;
    private double terulet;
    private List<Kerulet> keruletek;
    private String email = null;

    public String getNev() {
        return nev;
    }

    public double getTerulet() {
        return terulet;
    }

    public void setTerulet(double terulet) {
       if(terulet <= 0){
            this.terulet = 1;
       } else {
            this.terulet = terulet;
       }
    }

    public String getEmail() {
        return email;
    }

    public Telepules(String nev, double terulet) {
        if(nev.charAt(0) >= 97 && nev.charAt(0) <= 122 ) {
            throw new IllegalArgumentException("Hibas varosnev: " + nev);
        } else {
            this.nev = nev;
        }
        if(terulet <= 0){
            this.terulet = 1;
        } else {
            this.terulet = terulet;
        }
        this.keruletek = new ArrayList<>();
        
    }

    public void emailFrissitese(String email) throws TelepuleskezeloException {
        int kukac = 0;
        for (int i = 0; i < email.length(); i++) {
            if(email.charAt(i) == '@'){
                kukac++;
            }
        }
        if(!email.startsWith("info") || !email.endsWith(".hu") || kukac != 1  ) {
            throw new TelepuleskezeloException(this,"Hibas e-mail cim: " + email );
        } else {
            this.email = email;
        }
    }
    
    public void ujKerulet(String nev, int szam) {
        Kerulet uj = new Kerulet(nev, szam);
        keruletek.add(uj);
    }

    public void ujLakok(String nev, int szam) throws TelepuleskezeloException {
        boolean letezik = false;
        for (int i = 0; i < keruletek.size(); i++) {
            if(keruletek.get(i).nev.equalsIgnoreCase(nev)) {
                keruletek.get(i).lakosokSzama += szam;
                letezik = true;
            }
        }
        if(letezik == false) {
            throw new TelepuleskezeloException(this, "Nem talalhato a megadott kerulet: " + nev);
        }
    }

    public int getLakosokSzama() {
        int osszesLakos = 0;
        for (int i = 0; i < keruletek.size(); i++) {
            osszesLakos += keruletek.get(i).lakosokSzama;
        }
        return osszesLakos;
    }

    public double nepsuruseg() {
        return getLakosokSzama() / this.terulet;
    }

    public class Kerulet {
        private final String nev;
        private int lakosokSzama;

        public String getNev() {
            return nev;
        }

        public int getLakosokSzama() {
            return lakosokSzama;
        }

        public void setLakosokSzama(int lakosokSzama) {
            this.lakosokSzama = lakosokSzama;
        }

        private Kerulet(String nev, int lakosokSzama) {
            this.nev = nev;
            this.lakosokSzama = lakosokSzama;
        }
        
        public double lakokAranya() {
            double d = this.lakosokSzama;
            return d / Telepules.this.getLakosokSzama();
        }

    @Override
    public String toString() {
        return this.nev + " (" + Telepules.this.nev + ")";
    }

    }

}