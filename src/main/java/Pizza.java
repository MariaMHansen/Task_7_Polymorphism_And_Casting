import java.util.Arrays;

public class Pizza extends MenuItem{
 private String name;
 private String[] ingredients;

    public Pizza(String name) {
        super("pizza", 87.00);
        this.name = name;
        this.ingredients = new String[]{"crust","cheese","ketchup", "pineapple","ham"};
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return super.toString() + " name: " +getName()+ " ingredients: "+Arrays.toString(getIngredients());
    }
}
