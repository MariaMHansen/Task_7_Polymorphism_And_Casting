import java.util.Arrays;

    /*
       Welcome to assignment six,
       Where you will practice with using inheritance and Overriding
       (Not to be confused with Overloading which was explored in task 5)
       In this task you will learn to make a superclass and child classes,
       and learn about changing the functionality of a method from another class.

       ------------------------------------------------------------
       Inheritance
       -------------------------------------------------------------
       Inheritance is one of the big words that comes along with learning Object-Oriented Programming
       It is a mechanism in which a child object acquires the properties and behaviors of  parent object.
       This is very useful in programming, for example if you have different types of users in
       your system: an Admin, a Guest and a RegisteredUser. They are all different classes,
       but they have common characteristics like username and password,
       these attributes could be stored in a super class called User.

       In this exercise, you will practice creating parent and child classes.
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

public class InheritancePractice {
    public static void main(String[] args) {
        InheritancePractice op = new InheritancePractice();
        System.out.println("Task 1: " ); op.getMenuItemInfo();
        System.out.println("Task 2: " ); op.makePizza();
        System.out.println("Task 3: " ); op.makeDurum();
        System.out.println("Task 4: " ); op.createOrder();
        System.out.println("Task 5: " ); op.createPizzeriaManager();
    }
    /**
     * Task 1
     *
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

    public void getMenuItemInfo(){
        MenuItem menuItem1 = new MenuItem("default menu item", 50.0);
        System.out.println(menuItem1);

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


    public void makePizza(){
        Pizza hawaiiPizza = new Pizza("Hawaii");
        System.out.println(hawaiiPizza);
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

    public void makeDurum(){
        Durum classicDurum = new Durum("classic", "kebab");
        System.out.println(classicDurum);

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

    public void createOrder(){
        Order order = new Order();
        Pizza standardPizza = new Pizza("Margherita");
        order.addMenuItem(standardPizza);
        Durum classicDurum = new Durum("classic", "kebab");
        order.addMenuItem(classicDurum);
        System.out.println("Order details: ");
        order.printMenuItems();
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

    public void createPizzeriaManager(){
        PizzeriaManager pizzeriaManager = new PizzeriaManager();
        Order order = new Order();
        Pizza standardPizza = new Pizza("Margherita");
        order.addMenuItem(standardPizza);
        Durum classicDurum = new Durum("classic", "kebab");
        order.addMenuItem(classicDurum);
        pizzeriaManager.calculateTotalPrice(order);
        pizzeriaManager.printReceipt(order);

    }
}
/**
 * @author Maria Hansen
 */