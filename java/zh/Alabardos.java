public class Alabardos extends Zsoldos {
    private int harcErtek;
    private boolean fegyverRendben;

    public int getHarcErtek() {
        return harcErtek;
    }

    public void setHarcErtek(int harcErtek) {
        this.harcErtek = harcErtek;
    }

    public boolean isFegyverRendben() {
        return fegyverRendben;
    }

    public void setFegyverRendben(boolean fegyverRendben) {
        this.fegyverRendben = fegyverRendben;
    }

    public Alabardos(String nev, int egeszseg, int zsold, int harcErtek) {
        super(nev, egeszseg < 0 ? 0 : egeszseg, zsold < 0 ? 0 : zsold);
        if(harcErtek < 0) {
            harcErtek = 0;
        }
        this.harcErtek = harcErtek;
        this.fegyverRendben = true;
    }
    @Override
    public boolean joMoral() {
        if(this.fegyverRendben == true) {
            return super.joMoral();
        } else {
            return false;
        }
    }
    @Override
    public void tamad(int sebez) {
        if(this.fegyverRendben == false) {
            throw new SikertelenAkcio(0);
        } else if (this.harcErtek > sebez ) {
            this.harcErtek++;
        }
    }
    @Override
    public void vedekezik(int ved) {
        if(this.fegyverRendben == false) {
            throw new SikertelenAkcio(1);
        } else if (this.harcErtek < ved && this.egeszseg > 0 ) {
            this.egeszseg--;
        }
    }

    public void zsoldEmeles(int emeles) {
        if(this.fegyverRendben == false) {
            throw new IllegalStateException("Fegyvertelen zsoldos zsoldjat nem emeljuk.");
        } else {
            this.zsold += emeles;
        }
    }

    public void elvesztettuk() {
        this.zsold = 0;
        this.egeszseg = 0;
        this.harcErtek = 0;
    }
}