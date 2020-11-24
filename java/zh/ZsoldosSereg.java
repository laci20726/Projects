import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public final class ZsoldosSereg {
    public String tipus;
    public Set<Zsoldos> zsoldosok;

    public ZsoldosSereg(String tipus) {
        this.tipus = tipus;
        this.zsoldosok = new HashSet<>();
    }

    public boolean sorozas(Zsoldos uj) {
        if(zsoldosok.contains(uj)) {
            return false;
        } else {
            this.zsoldosok.add(uj);
            return true;
        }
    }
    
    public void seregTamad(int vedelem) {
        for (Zsoldos zsoldos : zsoldosok) {
           try{
            zsoldos.tamad(vedelem);
           } catch(SikertelenAkcio aj) {
            continue;
           }
        }
    }

    public void seregVisszavonul (int tamadok) {
        for (Zsoldos zsoldos : zsoldosok) {
            try{
                zsoldos.vedekezik(tamadok);
            } catch(SikertelenAkcio aj) {
                continue;
            }
        }
    }

    public boolean uralkodoOldalanAll() {
        if(this.tipus == "csaszari" || this.tipus == "kiralyi") {
            return true;
        } else {
            return false;
        }
    }

    public boolean mindenRendben() {
        int jo = 0;
        int rossz = 0;
        for (Zsoldos zsoldos : zsoldosok) {
            if(zsoldos.joMoral()){
                jo++;
            } else {
                rossz++;
            }
        }
        if (jo > rossz){
            return true;
        } else {
            return false;
        }
    }

    public int elbocsatas() {
        int mennyi = 0;
        Set<Zsoldos> zsoldosok2 = new HashSet<>();
        zsoldosok2.addAll(zsoldosok);
        for (Zsoldos zsoldos : zsoldosok2) {
            if(zsoldos.getClass() == Alabardos.class && zsoldos.joMoral() == false && zsoldos.egeszseg > 10 && zsoldos.zsold > 10) {
                zsoldosok.remove(zsoldos);
                mennyi++;
            }
        }
        
        return mennyi;
    }

    public boolean zsoldosokAtvetele(String filename){
        File uj = new File(filename);
        if(uj.exists()){
            return true;
        } else {
            return false;
        }
    } 

    public static boolean viadal(int dij ,TreeMap<Integer , Zsoldos> map) {
        return true;
    }
}