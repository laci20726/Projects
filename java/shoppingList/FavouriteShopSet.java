import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FavouriteShopSet {
    private Set<String> shops = new TreeSet<>();

    public void addShop(String bolt){
        this.shops.add(bolt);
    }

    public int countShops() {
        return this.shops.size();
    }

    public boolean isFavourite(String bolt) {
        if(this.shops.contains(bolt)) {
            return true;
        }
        return false;
    }

    public void printShops() {
        for(String elem : this.shops){
            System.out.println(elem);
        }
    }

    public void delete(String mit) {
        this.shops.remove(mit);
    }
}