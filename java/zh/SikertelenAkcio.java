
public class SikertelenAkcio extends RuntimeException{

    public SikertelenAkcio(int siker) {
        super(siker == 0 ? "Sikertelen tamadas." : "Sikertelen vedekezes."  );
    }

}