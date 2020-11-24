public class Raktar extends Tarolo {

    public Raktar(int kapacitas, int telitettseg, int vedelem) {
        super(kapacitas, telitettseg, vedelem);
    }

    @Override
    public void eltarol(int asvanyMennyiseg) {
        int data1 = getTelitettseg();
        int osszeg = data1 + asvanyMennyiseg;
        this.setTelitettseg(osszeg);
    }

    public void feldolgoz(Taska batyu){
        try{
            for (int i = 0; i < batyu.getAsvanyMennyisegek().size(); i++) {
                this.eltarol( batyu.getAsvanyMennyisegek().get(i));
            }
            batyu.kiurit();
        } catch(IllegalArgumentException kuty) {
            batyu.kiurit();
            throw new IllegalArgumentException("Telitettseg hataron kivul");
        }
    }


    public static void main(String[] args) {
        Taska tatyo = new Taska(100, 0, 5);
        Taska tatyo2 = new Taska(100, 0, 5);
        Taska tatyo3 = new Taska(100, 0, 5);
        Raktar shop = new Raktar(200, 0, 100);

        tatyo3.eltarol(5);
        
        tatyo3.eltarol(5);
        
        tatyo3.eltarol(5);
        
        tatyo3.eltarol(5);

        tatyo3.eltarol(5);
        
        tatyo3.eltarol(5);

        for (int i = 0; i < tatyo3.getAsvanyMennyisegek().size(); i++) {
            System.out.println(tatyo3.getAsvanyMennyisegek().get(i));
        }
        shop.feldolgoz(tatyo3);
        
        for (int i = 0; i < tatyo3.getAsvanyMennyisegek().size() ; i++) {
            System.out.println(tatyo3.getAsvanyMennyisegek().get(i));
        }

    }
}

