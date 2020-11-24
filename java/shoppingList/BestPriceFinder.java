import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;

public class BestPriceFinder {
    private Map<String ,String> bestBuys = new HashMap<>();

    public void addProduct(Product termek, String bolt ){
        this.bestBuys.put(termek.getName(), bolt);
    }

    public String getShopFor(String termek) {
        if(this.bestBuys.containsKey(termek)) {
            return this.bestBuys.get(termek);
        } else {
            return null;
        }
    }

    public void printBestBuys() {
        for(Map.Entry<String, String> elem : this.bestBuys.entrySet()) {
            System.out.println("Buy " + elem.getKey() + " at " + elem.getValue() + ".");
        }
        
    }

     /***************** */ //rewrite use the keyring 
    public int deleteShop(String mit) {                                               
        int torolt = 0;
        
        ArrayList<String> keyList = new ArrayList<String>(this.bestBuys.keySet());

        for (int i = 0; i < keyList.size(); i++) {
            if(this.bestBuys.get(keyList.get(i)) == mit) {
                this.bestBuys.remove(keyList.get(i));
                torolt++;
            }
        }
        return torolt;
    }
     /***************** */

}