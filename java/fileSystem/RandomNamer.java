import java.util.Random;

public class RandomNamer implements Namer {
    private Random rnd;
    private int length;
    private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";



    public RandomNamer(Random rnd, int length) {
        this.rnd = rnd;
        this.length = length;
    }
@Override
    public void rename(FileSystemEntry name) {
        FileSystemEntry newName = name;
        newName.setName("");
        for (int i = 0; i < length; i++) {
            newName.setName( newName.getName() + ALPHABET.charAt(rnd.nextInt(ALPHABET.length()))) ;
        }
        name = newName;
    }
}