public class Teendo {

    private String nev;
    private String ido;
    private int prioritas;
    private boolean teljesitettuk;

    public String getNev() {
        return this.nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getIdo() {
        return this.ido;
    }

    public void setIdo(String ido) {
        this.ido = ido;
    }

    public int getPrioritas() {
        return this.prioritas;
    }
    
    public void setPrioritas(int prioritas) {
        if(prioritas > 5 || prioritas < 1) {
            this.prioritas = 5;
            System.err.println("Ez nem okay!");
        } else {
            this.prioritas = prioritas;
        }

    }

    public boolean isTeljesitettuk() {
        return this.teljesitettuk;
    }

    public void atvalt() {
        this.teljesitettuk = !this.teljesitettuk;
    }

    public Teendo(){
        this.nev = "valami";
        this.ido = "ma";
        this.prioritas = 5;
    }

    public Teendo(String nev, String ido, int prioritas ){
        this.nev = nev;
        this.ido = ido;
        this.setPrioritas(prioritas);
    }

    @Override
    public String toString() {
        String ukno = "";
        if( teljesitettuk == false){
            ukno = "nem";
        } else {
            ukno = "igen";
        }
        return "Teendo neve: " + nev + ", ideje: " +  ido + ", prioritasa: " + prioritas + ", teljesitettuk: " + ukno;
    }

    public static Teendo legfontosabb(Teendo[] lista) {
        if(lista.length < 1){
            return null;
        }

        Teendo legfontosabb = lista[0];

        for (int i = 1; i < lista.length; i++) {
            if (legfontosabb.prioritas > lista[i].prioritas) {
                legfontosabb = lista[i];
            }
        }

        return  legfontosabb;
    }

    public static void main(String[] args) {
        Teendo tennikell = new Teendo("huh", "kutya", 10);
        System.out.println(tennikell);
    }





}