import java.util.Arrays;

public class Order {
    private MenuItem[] menuItems;

    public Order() {
        this.menuItems = new MenuItem[10];
    }

    public void addMenuItem(MenuItem menuItem){
        for(int i = 0; i<menuItems.length; i++){
            if(menuItems[i]==null){
                menuItems[i] = menuItem;
                break;
            }
        }
    }

    public void printMenuItems(){
        for (MenuItem menuItem : menuItems) {
          if(menuItem!=null){
              System.out.println(menuItem);
          }
        }
    }


    public MenuItem[] getMenuItems() {
        return menuItems;
    }

}
