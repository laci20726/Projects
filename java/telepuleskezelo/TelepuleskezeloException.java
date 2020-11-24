
public class TelepuleskezeloException extends Exception{
    private Telepules okozo;


    public TelepuleskezeloException( Telepules okozo,String message) {
        super(message);
        this.okozo = okozo;
    }

    public Telepules getOkozo() {
        return okozo;
    }
    
}