public class Heroes {
    public static void main(String[] args) {
        int time = 150;
        int unitNumber = 25 ;
        for (int i = 0; i < time; i++) {
            int growth = unitNumber / 25;
            unitNumber += growth;
            System.out.println(unitNumber);
        }
    }
}