
public class Product {
    private String name;
    private int amount;
    private boolean important;

    public Product(String name, int amount, boolean important) {
        this.name = name;
        this.amount = amount;
        this.important = important;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    
    

}