import java.util.Arrays;

public class Pizza extends MenuItem{
 private String name;
 private String[] ingredients;

 private String size;

    public Pizza(String name, String size) {
        super( 87.00);
        this.name = name;
        this.ingredients = new String[]{"crust","cheese","toppings"};
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + " name: " +getName()+ " size: " +getSize()+ " ingredients: "+Arrays.toString(getIngredients());
    }
}
