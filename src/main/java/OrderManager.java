import java.util.ArrayList;

public class OrderManager {
    private ArrayList<MenuItem> menuItems;

    public OrderManager() {
        this.menuItems = new ArrayList<MenuItem>();
    }

    public void addMenuItem(MenuItem menuItem){
       menuItems.add(menuItem);
    }

    public double calculateTotalPrice(){
        double totalPrice = 0.0;
        for (MenuItem menuItem: this.getMenuItems()) {
                totalPrice+=menuItem.getPrice();
            if (menuItem instanceof Pizza){
                Pizza pizza = (Pizza) menuItem;
                if(pizza.getSize().equals("family")){
                    System.out.println("Extra charge for family pizza + 100.0");
                    totalPrice+=100;
                }
            }
        }
        return totalPrice;
        }

    public double calculateTotalPrice(double durumDiscount){
        double totalPrice = 0.0;
        for (MenuItem menuItem : this.getMenuItems()){
            totalPrice+=menuItem.getPrice();
            if (menuItem instanceof Durum){
                totalPrice-=durumDiscount;
            }
        }
        return totalPrice;
    }

    public void printMenuItems(){
        for (MenuItem menuItem : menuItems) {
            if(menuItem!=null){
                System.out.println(menuItem);
            }
        }
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
