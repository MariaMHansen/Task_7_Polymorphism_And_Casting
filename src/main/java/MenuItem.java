import java.util.Arrays;
import java.util.Random;

public class MenuItem {
    private double price;


    public MenuItem( double price) {
        this.price = price;
    }


    public String toString() {
        return " price: "+ getPrice();
    }

    public double getPrice() {
        return price;
    }

}
