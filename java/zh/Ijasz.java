public class Ijasz extends Zsoldos {
    private final double loTav;
    private int nyilvesszoSzam;

    public double getLoTav() {
        return loTav;
    }

    public int getNyilvesszoSzam() {
        return nyilvesszoSzam;
    }

    public void setNyilvesszoSzam(int nyilvesszoSzam) {
        this.nyilvesszoSzam = nyilvesszoSzam;
    }

    public Ijasz(String nev, int egeszseg, int zsold, double loTav) {
        super(nev, egeszseg, zsold);
        this.loTav = loTav;
        this.nyilvesszoSzam = 10;
    }
@Override
public boolean joMoral() {
    return true;
}
    @Override
    public void tamad(int tav) {
        if(tav > this.loTav) {
            throw new SikertelenAkcio(0);
        } else if (this.nyilvesszoSzam < 1) {
            throw new SikertelenAkcio(0);
        } else {
            this.nyilvesszoSzam--;
        }
    }

    @Override
    public void vedekezik(int ved) {
        this.egeszseg -= ved;
        if(this.egeszseg < 0) {
            this.egeszseg = 0;
        }
    }
    @Override
    public final void gyogyul(int gyogyulas) {
        if(this.egeszseg != 0) {
            super.gyogyul(gyogyulas);
        }
    }
    @Override
    public String toString() {
        return "Ez az ijasz " + this.loTav + " tavolsagra kepes elloni " + this.nyilvesszoSzam + " db nyilvesszot.";
    }
}