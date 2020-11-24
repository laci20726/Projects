import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Taska extends Tarolo {
    private List<Integer> asvanyMennyisegek;

    public List<Integer> getAsvanyMennyisegek() {
        List<Integer> masolat = new ArrayList<>();
        masolat.addAll(this.asvanyMennyisegek);
        return masolat;
    }

    public Taska(int kapacitas, int telitettseg, int vedelem) {
        super(kapacitas, telitettseg, vedelem);
        this.asvanyMennyisegek = new ArrayList<>();
    }

    @Override
    public void eltarol(int asvanyMennyiseg) {
        int data1 = getTelitettseg();
        int osszeg = data1 + asvanyMennyiseg;
        this.setTelitettseg(osszeg);
        this.asvanyMennyisegek.add(asvanyMennyiseg);
    }

    public double atlagMennyiseg() {
        double osszeg = 0;
        if(!this.asvanyMennyisegek.isEmpty()){
            for (Integer szam : this.asvanyMennyisegek) {
                osszeg += szam.doubleValue();
            }   
            return osszeg / this.asvanyMennyisegek.size();
        } else {
            return osszeg;
        }
    }
    public void kiurit() {
        this.asvanyMennyisegek.clear();
        setTelitettseg(0);
    }
    
    public static List<Taska> taskakatBetolt(String filename) {
        List<Taska> tatyi = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while(scanner.hasNextLine()) {
                String data[] = scanner.nextLine().split(";");
                Taska uj = new Taska(Integer.parseInt(data[0]), 0, Integer.parseInt( data[1]));
                for (int i = 2; i < data.length; i++) {
                    uj.eltarol(Integer.parseInt(data[i]));
                }
                tatyi.add(uj);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            tatyi.clear();
            return tatyi;
        }
        return tatyi;
    }

    public static void main(String[] args) {
        Taska batyu = new Taska(40, 0, 3);
        System.out.println(batyu.telitettseg);
        batyu.eltarol(5);
        System.out.println(batyu.telitettseg);
        batyu.eltarol(5);
        System.out.println(batyu.telitettseg);
        batyu.eltarol(5);
        System.out.println(batyu.telitettseg);
    }

    public void setAsvanyMennyisegek(List<Integer> asvanyMennyisegek) {
        this.asvanyMennyisegek = asvanyMennyisegek;
    }

}