import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtremeShopping {
    private Map<String, List<Product>> extremeList = new HashMap<>();
    
    public void addShoppingList( String bolt, List<Product> lista) {
        this.extremeList.put(bolt, lista);
    }


    public void printShoppingLists() {
        for(Map.Entry<String, List<Product>> elem : this.extremeList.entrySet()) {
            System.out.println(elem.getKey());
            for (int i = 0; i < elem.getValue().size(); i++) {
               if((i + 1) == elem.getValue().size()){
                System.out.println(elem.getValue().get(i).getName());
               } else {
                System.out.print(elem.getValue().get(i).getName() + " ");
               }              
            }
            
        }
    }
}