
public abstract class Tarolo {
    int kapacitas;
    int telitettseg;
    int vedelem;

    public void setTelitettseg(int telitettseg){
        if(telitettseg < 0 || telitettseg > this.kapacitas) {
            throw new IllegalArgumentException("Telitettseg hataron kivul");
        } else {
            this.telitettseg = telitettseg;
        }
    }
    
    public int getTelitettseg() {
        return telitettseg;
    }

    public Tarolo(int kapacitas, int telitettseg, int vedelem) {
        this.kapacitas = kapacitas;
        if(telitettseg < 0 || telitettseg > this.kapacitas) {
            throw new IllegalArgumentException("Telitettseg hataron kivul");
        } else {
            this.telitettseg = telitettseg;
        }
        this.vedelem = vedelem;
    }

    public abstract void eltarol(int asvanyMennyiseg);
    
    public boolean elegBiztonsagos() {
        boolean elegeE = false;
        if(this.vedelem >= Math.sqrt(this.telitettseg)) {
            elegeE = true;
        }
        return elegeE;
    }
    
    public static void main(String[] args) {
       // Tarolo uj = new Tarolo(5,25, 5);
        //System.out.println(uj.elegBiztonsagos());
    }


}