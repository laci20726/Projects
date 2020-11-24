public class Megbeszeles extends Teendo {

    private String kivel;
    private String hol;
    public static int MEGBESZELES_DARAB = 0;

    public String getKivel() {
        return kivel;
    }

    public void setKivel(String kivel) {
        this.kivel = kivel;
    }

    public String getHol() {
        return hol;
    }

    public void setHol(String hol) {
        this.hol = hol;
    }

    public int getMEGBESZELES_DARAB() {
        return MEGBESZELES_DARAB;
    }

    @Override
    public void setPrioritas(int prioritas) {
        super.setPrioritas(1);
    }


    public Megbeszeles(String ido, String kivel, String hol) {
        super("Megbeszeles", ido, 1);
        this.kivel = kivel;
        this.hol = hol;
        Megbeszeles.MEGBESZELES_DARAB += 1;
    }

    

    @Override
    public String toString() {
        return "Megbeszeles, partner: "+ kivel + ". Idopont: "+ super.getIdo() + ". Helyszin: " + hol;
    }

    public static void main(String[] args) {
        Megbeszeles megb = new Megbeszeles("most", "kutyuval", "itthon");
        System.out.println(megb);
        System.out.println(Megbeszeles.MEGBESZELES_DARAB);
    }
    
}