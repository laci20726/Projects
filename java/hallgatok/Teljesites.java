
public class Teljesites {
    public Kurzus kurzus;
    public int pontszam;

    public Teljesites(Kurzus kurzus, int pontszam) {
        this.kurzus = kurzus;
        this.pontszam = pontszam;
    }

    public int erdemjegy() {
        int jegy = kurzus.getOsztalyozasiMod().erdemjegy(this.pontszam);
        return jegy;
    }
    

}