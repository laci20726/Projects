
public class Banyasz {
    private Taska taska;
    private Raktar raktar;

    public Banyasz(Raktar raktar) {
        this.raktar = raktar;
        this.taska = new Taska(15, 0, 4);
    }
    
    public boolean banyaszik(int asvanyMennyiseg) throws OmlasException{
        boolean notte = false;
        double elott = this.taska.atlagMennyiseg();
        try{
            this.taska.eltarol(asvanyMennyiseg);
        } catch(IllegalArgumentException kuty) {
            this.raktar.feldolgoz(this.taska);
            this.taska.eltarol(asvanyMennyiseg);
            if(this.raktar.elegBiztonsagos() == false) {
                throw new OmlasException();
            }
        }
        double utana = this.taska.atlagMennyiseg();
        if(elott > utana) {
            notte = false;
        } else {
            notte = true;
        }

        return notte;
    }

    public static void main(String[] args) {
        
    }


}