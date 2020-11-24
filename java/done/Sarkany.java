public class Sarkany{

    private int eletero;
    private boolean ehes;

    public int getEletero() {
        return eletero;
    }

    public boolean isEhes() {
        return ehes;
    }

    public void setEletero(int eletero) {
        if( eletero < 0 ){
            this.eletero = 0;
            System.err.println("megolted a sarkanyt\n");
        } else {
            this.eletero = eletero;
        }
    }

    public void setEhes(boolean ehes) {
        if( eletero < 50) {
            this.ehes = true;
        } else {
            this.ehes = ehes;
        }
    }

    public Sarkany() {
        this.eletero = 100;
        this.ehes = true;
    }

    public Sarkany( int eletero, boolean ehes) {
        this.eletero = eletero;
        if ( eletero < 0) {
            this.eletero = 0;
        }
        this.ehes = ehes;
        if ( eletero < 50) {
            this.ehes = true;
        }
    }

    @Override
    public String toString() {
        String ehese = "";
        if (ehes == true) {
            ehese = "rettenetesen";
        } else {
            ehese = "veletlenul nem";
        }
        return "A sarkany eletereje "  +eletero + ", és jelenleg "+ ehese +" éhes.";
    }

    public boolean vajonElMeg() {
        if(eletero > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void eszik(int kaja) {

        if( kaja > 0) {
            this.eletero += kaja;
        } else {
            System.err.println("en a helyedben nem eheztetnek egy sarkanyt");
        }

    }




}