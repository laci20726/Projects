public abstract class Zsoldos {
    protected String nev;
    protected int egeszseg;
    protected int zsold;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getEgeszseg() {
        return egeszseg;
    }

    public void setEgeszseg(int egeszseg) {
        this.egeszseg = egeszseg;
    }

    public int getZsold() {
        return zsold;
    }

    public void setZsold(int zsold) {
        this.zsold = zsold;
    }

    public Zsoldos(String nev, int egeszseg, int zsold) {
        this.nev = nev;
        if(egeszseg > 0) {
            this.egeszseg = egeszseg;
        }
        if(zsold > 0) {
            this.zsold = zsold;
        }
        
    }
    public void gyogyul(int gyogyulas) {
        this.egeszseg += gyogyulas;
        if (this.zsold - gyogyulas < 0) {
            this.zsold = 0;
        } else {
            this.zsold -= gyogyulas;
        }
    }

    public boolean joMoral() {
        boolean joe = false;
        if(this.egeszseg > 10 && this.zsold > 10) {
            joe = true;
        }
        return joe;
    }
    public abstract void tamad(int sebez);

    public abstract void vedekezik(int ved);

    @Override
    public String toString() {
        String allapot = "gyenge";
        if(egeszseg > 10) {
            allapot = "kivalo";
        }
        return "A zsoldos neve " + this.nev + ", havi " + this.zsold + " aranyat keres, es az egeszsege " + allapot + ".";
    }

    public static Zsoldos leginkabbMegeri( Zsoldos[] zsoldosok) {
        if (zsoldosok == null || zsoldosok.length == 0) {
            return null;
        } else {
            double leg = 0;
            int melyik = 0;
                for (int i = 0; i < zsoldosok.length; i++) {
                    if( zsoldosok[i].zsold <= 0 || zsoldosok[i].egeszseg <= 0) {
                        continue;
                    }
                    double ertek = zsoldosok[i].zsold / zsoldosok[i].egeszseg;
                    if(i == 0) {
                        leg = ertek;
                        melyik = i ;
                    } else if( leg >= ertek) {
                        leg = ertek;
                        melyik = i ;
                    }
                }  
                return zsoldosok[melyik];
            }
        }
    }
