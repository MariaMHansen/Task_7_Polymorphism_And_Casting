public class PizzeriaManager {

    public PizzeriaManager() {
    }

      public double calculateTotalPrice(Order order){
        double totalPrice = 0.0;
        for (MenuItem menuItem: order.getMenuItems()) {
            if(menuItem!=null){
                totalPrice+=menuItem.getPrice();
            }
        }
        return totalPrice;
    }

    public void printReceipt(Order order) {
        System.out.println("Receipt ");
        for (MenuItem m : order.getMenuItems()) {
            if(m!=null) {
                System.out.println(m);
            }
        }
        System.out.println("Total Price: " + calculateTotalPrice(order));
    }
}
