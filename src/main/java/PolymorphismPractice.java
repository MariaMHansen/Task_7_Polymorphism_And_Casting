/*
   Welcome to assignment seven, ...


   ------------------------------------------------------------
   Polymorphism
   -------------------------------------------------------------
   ...

   In this exercise, you will practice using Polymorphism to ......
   We will continue working on the pizzeria application and
   add we have a new product on the menu, it is durum!
   Scroll down to STEP 1:
   */

/**
 * This is the Main method,
 * Uncomment the lines of code for each method you implement
 * to test your solution.
 *
 * Links
 * 11.3 Using the super Keyword
 * 11.3.1 Calling Superclass Constructors
 * 11.3.3 Calling Superclass Methods
 * The keyword super can also be used to reference a method other than the constructor in the
 * superclass. The syntax is super.method(arguments);
 * 11.4 Overriding Methods
 *
 */

public class PolymorphismPractice {
    public static void main(String[] args) {
        PolymorphismPractice op = new PolymorphismPractice();
        System.out.println("Task 1: ");
        op.getMenuItemInfo();
        System.out.println("Task 2: ");
        op.makePizzaAndDurum();
        System.out.println("Task 3: ");
        op.checkOrderManager();
        System.out.println("Task 4: ");
        op.checkDurumDiscount();
        System.out.println("Task 5: "); op.checkTotalPriceWithFamilyPizza();
    }

    /**
     * Task 1
     * <p>
     * In this task we will make a MenuItem class (see the UML diagram for reference)
     * The MenuItem class needs to have number(int), price(double) and type(String) attributes.
     * The possible types, that will be used for MenuItem objects are: pizza and durum.
     * All attributes must be private, and have getter methods.
     * The class also needs a constructor that uses String type and double price parameters.
     * Inside the constructor the number attribute, which represents the number of the food item
     * on the Menu card, has to be a random whole number from 1 to 100.
     * Finally, create a toString method to display your MenuItems nicely then they are printed out.
     * You can choose a format you like, or you can use this one:
     * return " number: " +getNumber()+ " type: " + getType() +" price: "+ getPrice();
     * Note! The toString() method must return a String, not just System.out.print it
     * Tip! Use Random class for the number variable
     * Points: 2
     * New skills: using Random class in constructor, toString()
     * Difficulty: 2
     */

    public void getMenuItemInfo() {
        MenuItem menuItem1 = new MenuItem(50.0);
        System.out.println("MenuItem: " + menuItem1);

    }

    /**
     * Task 2
     * Our pizzeria will be making two types of MenuItems,
     * one of them will be pizza, for this we need a Pizza class.
     * Therefore, we need to create a Pizza class that is a child class
     * the MenuItem parent class.
     * Use the UML diagram provided in the UML folder to create pizza name and ingredients attributes.
     * Remember to make all attributes private and create getters.
     * Create a constructor, so we can make Pizza objects in later steps.
     * Since, Pizza class has an inheritance relation to MenuItem class,
     * it will need to send the type and price parameters to the super class in the constructor.
     * All pizzas cost 87.0. Pizza class needs to send "pizza" type to the MenuItem superclass.
     * You also need to create a toStringMethod, which Overrides the toStringMethod of the super class.
     * You can find examples of overriding toString method here : 11.4 Overriding Methods
     * Tip! Super keyword MUST always be in the first line of the constructor!
     * Points: 2
     * New skills: overriding methods, super keyword
     * Difficulty: 2
     */


    public void makePizzaAndDurum() {
        Pizza hawaiiPizza = new Pizza("Hawaii", "regular");
        System.out.println("Pizza: " + hawaiiPizza);
        Durum classicDurum = new Durum("classic", "kebab");
        System.out.println("Durum: " + classicDurum);
    }

    /**
     * Task 3
     * The second type of MenuItems the pizzeria will produce is Durum.
     * Therefore, we need to create a Durum class that is a child class
     * the MenuItem parent class.
     * Use the UML diagram provided in the UML folder to create Durum name and meat attributes.
     * Remember to make all attributes private and create getters.
     * Create a constructor, so we can make Durum objects in later steps.
     * Since, Durum class has an inheritance relation to MenuItem class,
     * it will need to send the type and price parameters to the super class in the constructor.
     * All durum cost 65.0. Durum class needs to send "durum" type to the MenuItem superclass.
     * You also need to create a toStringMethod, which Overrides the toStringMethod of the super class.
     * You can find examples of overriding toString method here : 11.4 Overriding Methods
     * Points: 3
     * New skills: overriding methods, super keyword
     * Difficulty: 3
     */
    public void checkOrderManager() {
        // Task 3
        OrderManager orderManager = new OrderManager();
        orderManager.addMenuItem(new Pizza("Peperoni", "regular"));
        orderManager.addMenuItem(new Durum("Classic Durum", "chicken"));
        orderManager.printMenuItems();
    }


    /**
     * Task 4
     * Create an Order class, with one attribute, which is
     * an array of MenuItems in this order.
     * You also need to create an empty constructor for this class,
     * which creates a new MenuItem[] for each order and sets it to 10 places.
     * Your Order class needs to have two methods one for adding a new MenuItem to
     * the MenuItems array, and another for printing the menuItems from this array (in the format you like)
     * See the UML diagram provided in the UML folder to see attribute types.
     * Remember private visibility attributes.
     * Create a getter for the pizzas attribute.
     * Points: 3
     * New skills: storing children items in parent class array
     * Difficulty: 4
     */

    public void checkDurumDiscount() {
        // Task 3
        OrderManager orderManager = new OrderManager();
        orderManager.addMenuItem(new Pizza("Peperoni", "regular"));
        orderManager.addMenuItem(new Durum("Classic Durum", "chicken"));
        System.out.println("Price before discount: " + orderManager.calculateTotalPrice());
        System.out.println("Price with durum discount: " + orderManager.calculateTotalPrice(10.0));
    }


    /**
     * Task 5
     * Create a PizzeriaManager class, with no attributes and an empty constructor.
     * See the UML diagram provided in the UML folder to see attribute types.
     * This class needs to have two methods one for
     * calculating the total price of all pizzas in an order.
     * You can also make a method that prints out the receipt with all pizzas and total price just for fun (no test)
     * Points: 2
     * New skills: accessing class attributes through inheritance
     * Difficulty: 2
     */

    public void checkTotalPriceWithFamilyPizza() {
        Pizza pizza1 = new Pizza("Palermo", "regular");
        Pizza pizza2 = new Pizza("Greek", "family");
        OrderManager orderManager = new OrderManager();
        orderManager.addMenuItem(pizza1);
        orderManager.addMenuItem(pizza2);
        orderManager.printMenuItems();
        System.out.println("Total price: " +orderManager.calculateTotalPrice());
    }
}
/**
 * @author Maria Hansen
 */