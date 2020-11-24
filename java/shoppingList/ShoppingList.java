import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product termek) {
        this.items.add(termek);
    }

    public int countProducts() {
        return this.items.size();
    }

    public Product getProduct(int melyik) {
        if(this.items.size() > melyik && melyik >= 0) {
            return this.items.get(melyik);
        } else {
            return null;    
        }
    }
    
    public void printProducts() {
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println(this.items.get(i).getName());
        }
    }

    public void delete(Product torlendo) {
        this.items.remove(torlendo);
    }

    public int deleteUnimportant() {
        int kutya = 0;
        for (int i = this.items.size() ; i > 0 ; i--) {
           if(this.items.get(i - 1).isImportant() == false) {
                this.items.remove(this.items.get(i - 1));
                kutya++;
           }
        }
        return kutya;
    }

}