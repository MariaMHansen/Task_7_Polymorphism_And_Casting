import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;

class PolymorphismPracticeTest {
    PolymorphismPracticeTest() {
    }

    // Step 1 Test
    @DisplayName("Checks MenuItem attributes and constructor")
    @Test
    void menuItemClassTest() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Checking if MenuItem class exists
        if (!classExists("MenuItem")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 1:\n" +
                    " You need to create the MenuItem class to pass Test 1 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }

        // Checking if MenuItem price attribute exists
        if (!fieldExists("MenuItem", "price")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 1:\n" +
                    " You need to create the MenuItem price attribute to pass Test 1 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // Checking if MenuItem price attribute is private
        if (!menuItemFieldIsPrivate("price")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 1:\n" +
                    " You need make the MenuItem price attribute private to pass Test 1 \n" +
                    "          If you are having problems after the attribute is set to private \n" +
                    "          create a getter method see getter (or accessor in Chapter 9)\n" +
                    "          To see an example of creating private attributes, try \n" +
                    "          \"Introduction to Java Programming and Data Structures book\"\n" +
                    "          9.9 Data Field Encapsulation \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        else {
            // Creating a new MenuItem object and checking if it has a double attribute price
            Object testMenuItemObject = createMenuItemTestObject();
            Field priceField = getFieldFromClass("MenuItem", testMenuItemObject, "price");
            Object priceValue = priceField.get(testMenuItemObject);
            if (!(priceValue instanceof Double)) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "AUTO-FEEDBACK:\n" +
                        "Step 1:\n" +
                        " The price attribute in MenuItem class must be a double \n" +
                        "          To see an example of creating classes and attributes, try \n" +
                        "          \"Introduction to Java Programming and Data Structures book\"\n" +
                        "          9.3 Example: Defining Classes and Creating Objects \n" +
                        "-------------------------------------------------------------------------\n"
                );
            }
            // Creating a new Pizza object and checking if it has a String attribute name
            Object testPizzaObject = createPizzaTestObject();
            Field nameField = getFieldFromClass("Pizza", testPizzaObject, "name");
            Object nameValue = nameField.get(testPizzaObject);
            // Feedback if Pizza attribute name is not string
            if (!(nameValue instanceof String)) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "AUTO-FEEDBACK:\n" +
                        "Step 1:\n" +
                        " The name attribute in Pizza class must be a String \n" +
                        "          It looks like your Pizza name data type is not String \n" +
                        "          To see an example of creating classes and attributes, try \n" +
                        "          \"Introduction to Java Programming and Data Structures book\"\n" +
                        "          9.3 Example: Defining Classes and Creating Objects \n" +
                        "-------------------------------------------------------------------------\n"
                );
            }

            if (!(menuItemConstructorExists())) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "AUTO-FEEDBACK:\n" +
                        "Step 1:\n" +
                        " You need to create a constructor with 2 attributes in ItemMenu class  \n" +
                        " The attributes are String type and souble price, see the UML diagram  \n" +
                        "          To see an example of creating classes and attributes, try \n" +
                        "          \"Introduction to Java Programming and Data Structures book\"\n" +
                        "          9.3 Example: Defining Classes and Creating Objects \n" +
                        "-------------------------------------------------------------------------\n"
                );
            }

            // fields are correct types
            Assertions.assertEquals(true, priceValue instanceof Double);
            // constructor
            Assertions.assertEquals(true, menuItemConstructorExists());
            // fields are private
            Assertions.assertEquals(true, menuItemFieldIsPrivate("price"));
        }
    }

    // Test 2
    @DisplayName("Checks Pizza and Durum attributes and constructor")
    @Test
    void pizzaClassTest() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Checking if Pizza class exists
        if (!classExists("Pizza")||!classExists("MenuItem")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 2:\n" +
                    " You need to create the Pizza and MenuItem class to pass Test 2 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // Checking if Pizza class extends MenuItem
        Class<?> pClass = Class.forName("Pizza");
        Class<?> mClass = Class.forName("MenuItem");
        if (!mClass.isAssignableFrom(pClass)) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "Step 2:\n" +
                    " Pizza has to be a child class to MenuItem to pass Test 2 \n" +
                    "          Try using extends keyword in the child class \n" +
                    "          If you are having problems with the constructor \n" +
                    "          Try super keyword, it MUST be in the first line of constructor! \n" +
                    "          You can find examples of inheritance here: \n" +
                    "          \"Introduction to Java Programming and Data Structures book\"\n" +
                    "          11.2 Superclasses and Subclasses \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }

        // Checking if Pizza name attribute exists
        if (!fieldExists("Pizza", "name")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 2:\n" +
                    " You need to create the Pizza name attribute to pass Test 2 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // Checking if Pizza name attribute is private
        if (!pizzaFieldIsPrivate("name")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 2:\n" +
                    " You need make the Pizza name attribute private to pass Test 2 \n" +
                    "          If you are having problems after the attribute is set to private \n" +
                    "          create a getter method see getter (or accessor in Chapter 9)\n" +
                    "          To see an example of creating private attributes, try \n" +
                    "          \"Introduction to Java Programming and Data Structures book\"\n" +
                    "          9.9 Data Field Encapsulation \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // Checking if Pizza size attribute exists
        if (!fieldExists("Pizza", "size")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 2:\n" +
                    " You need to create the Pizza size attribute to pass Test 2 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // Checking if Pizza size attribute is private
        if (!pizzaFieldIsPrivate("size")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 2:\n" +
                    " You need make the Pizza size attribute private to pass Test 2 \n" +
                    "          If you are having problems after the attribute is set to private \n" +
                    "          create a getter method see getter (or accessor in Chapter 9)\n" +
                    "          To see an example of creating private attributes, try \n" +
                    "          \"Introduction to Java Programming and Data Structures book\"\n" +
                    "          9.9 Data Field Encapsulation \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }


        // Checking if Pizza ingredients attribute exists
        if (!fieldExists("Pizza", "ingredients")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 2:\n" +
                    " You need to create the Pizza ingredients attribute to pass Test 2 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // Checking if Pizza ingredients attribute is private
        if (!pizzaFieldIsPrivate("ingredients")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 2:\n" +
                    " You need make the Pizza ingredients attribute private to pass Test 2\n" +
                    "          If you are having problems after the attribute is set to private \n" +
                    "          create a getter method see getter (or accessor in Chapter 9)\n" +
                    "          To see an example of creating private attributes, try \n" +
                    "          \"Introduction to Java Programming and Data Structures book\"\n" +
                    "          9.9 Data Field Encapsulation \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }

        else {
            // Creating a new Pizza object and checking if it has a String attribute name
            Object testPizzaObject = createPizzaTestObject();
            Field pizzaNameField = getFieldFromClass("Pizza", testPizzaObject, "name");
            Object pizzaNameValue = pizzaNameField.get(testPizzaObject);
            // Feedback if Pizza attribute name is not string
            if (!(pizzaNameValue instanceof String)) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "AUTO-FEEDBACK:\n" +
                        "Step 2:\n" +
                        " The name attribute in Pizza class must be a String \n" +
                        "          It looks like your Pizza name data type is not String \n" +
                        "          To see an example of creating classes and attributes, try \n" +
                        "          \"Introduction to Java Programming and Data Structures book\"\n" +
                        "          9.3 Example: Defining Classes and Creating Objects \n" +
                        "-------------------------------------------------------------------------\n"
                );
            }

            // Checking if Pizza Class attribute ingredients array is a String[]
            Field ingredientsField = getFieldFromClass("Pizza", testPizzaObject, "ingredients");
            Object ingredientsValue = ingredientsField.get(testPizzaObject);
            // Checking if the first element in the ingredients array is a String
            String[] ingredients = (String[]) ingredientsValue;

            if (!(ingredients[0] instanceof String)) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "AUTO-FEEDBACK:\n" +
                        "Step 2:\n" +
                        "          It looks like your Pizza ingredients array type is not String [] \n" +
                        "          You can find an example of creating a String array in\n" +
                        "          \"Introduction to Java Programming and Data Structures book\"\n" +
                        "          7.2.6 Processing Arrays \n" +
                        "          There is a months array example at the end of the chapter\n" +
                        "-------------------------------------------------------------------------\n"
                );
            }
            if (!(pizzaConstructorExists())) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "AUTO-FEEDBACK:\n" +
                        "Step 2:\n" +
                        " You need to create a constructor with 1 attribute in Pizza class  \n" +
                        " The attribute is String type name, see the UML diagram  \n" +
                        "          To see an example of creating classes and attributes, try \n" +
                        "          \"Introduction to Java Programming and Data Structures book\"\n" +
                        "          9.3 Example: Defining Classes and Creating Objects \n" +
                        "-------------------------------------------------------------------------\n"
                );
            }
            // Checking if Pizza class exists
            if (!classExists("Durum")||!classExists("MenuItem")) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "AUTO-FEEDBACK:\n" +
                        "Step 2:\n" +
                        " You need to create the Durum and MenuItem classes to pass Test 2 \n" +
                        "-------------------------------------------------------------------------\n"
                );
            }
            // Checking if Durum class extends MenuItem
            Class<?> dClass = Class.forName("Durum");
            Class<?> menuClass = Class.forName("MenuItem");
            if (!menuClass.isAssignableFrom(dClass)) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "Step 2:\n" +
                        " Durum has to be a child class to MenuItem to pass Test 2 \n" +
                        "          Try using extends keyword in the child class \n" +
                        "          If you are having problems with the constructor \n" +
                        "          Try super keyword, it MUST be in the first line of constructor! \n" +
                        "          You can find examples of inheritance here: \n" +
                        "          \"Introduction to Java Programming and Data Structures book\"\n" +
                        "          11.2 Superclasses and Subclasses \n" +
                        "-------------------------------------------------------------------------\n"
                );
            }

            // Checking if Durum name attribute exists
            if (!fieldExists("Durum", "name")) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "AUTO-FEEDBACK:\n" +
                        "Step 2:\n" +
                        " You need to create the Durum name attribute to pass Test 2 \n" +
                        "-------------------------------------------------------------------------\n"
                );
            }
            // Checking if Durum name attribute is private
            if (!durumFieldIsPrivate("name")) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "AUTO-FEEDBACK:\n" +
                        "Step 2:\n" +
                        " You need make the Durum name attribute private to pass Test 2 \n" +
                        "          If you are having problems after the attribute is set to private \n" +
                        "          create a getter method see getter (or accessor in Chapter 9)\n" +
                        "          To see an example of creating private attributes, try \n" +
                        "          \"Introduction to Java Programming and Data Structures book\"\n" +
                        "          9.9 Data Field Encapsulation \n" +
                        "-------------------------------------------------------------------------\n"
                );
            }

            // Checking if Durum meat attribute exists
            if (!fieldExists("Durum", "meat")) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "AUTO-FEEDBACK:\n" +
                        "Step 2:\n" +
                        " You need to create the Durum meat attribute to pass Test 2 \n" +
                        "-------------------------------------------------------------------------\n"
                );
            }
            // Checking if Durum meat attribute is private
            if (!durumFieldIsPrivate("meat")) {
                fail("\n" +
                        "-------------------------------------------------------------------------\n" +
                        "AUTO-FEEDBACK:\n" +
                        "Step 2:\n" +
                        " You need make the Durum meat attribute private to pass Test 2\n" +
                        "          If you are having problems after the attribute is set to private \n" +
                        "          create a getter method see getter (or accessor in Chapter 9)\n" +
                        "          To see an example of creating private attributes, try \n" +
                        "          \"Introduction to Java Programming and Data Structures book\"\n" +
                        "          9.9 Data Field Encapsulation \n" +
                        "-------------------------------------------------------------------------\n"
                );
            }else {
                // Creating a new Durum object and checking if it has a String attribute name
                Object testDurumObject = createDurumTestObject();
                Field durumNameField = getFieldFromClass("Durum", testDurumObject, "name");
                Object durumNameValue = durumNameField.get(testDurumObject);
                // Feedback if Durum attribute name is not string
                if (!(durumNameValue instanceof String)) {
                    fail("\n" +
                            "-------------------------------------------------------------------------\n" +
                            "AUTO-FEEDBACK:\n" +
                            "Step 2:\n" +
                            " The name attribute in Durum class must be a String \n" +
                            "          It looks like your Pizza name data type is not String \n" +
                            "          To see an example of creating classes and attributes, try \n" +
                            "          \"Introduction to Java Programming and Data Structures book\"\n" +
                            "          9.3 Example: Defining Classes and Creating Objects \n" +
                            "-------------------------------------------------------------------------\n"
                    );
                }

                // Checking if Durum Class attribute meat is a String
                Field meatField = getFieldFromClass("Durum", testDurumObject, "meat");
                Object meatValue = meatField.get(testDurumObject);

                if (!(meatValue instanceof String)) {
                    fail("\n" +
                            "-------------------------------------------------------------------------\n" +
                            "AUTO-FEEDBACK:\n" +
                            "Step 2:\n" +
                            "          It looks like your Durum meat attribute type is not String \n" +
                            "-------------------------------------------------------------------------\n"
                    );
                }
                if (!(durumConstructorExists())) {
                    fail("\n" +
                            "-------------------------------------------------------------------------\n" +
                            "AUTO-FEEDBACK:\n" +
                            "Step 2:\n" +
                            " You need to create a constructor with 2 attributes in Durum class  \n" +
                            " The attributes are name and meat, both of type String see the UML diagram  \n" +
                            "          To see an example of creating classes and attributes, try \n" +
                            "          \"Introduction to Java Programming and Data Structures book\"\n" +
                            "          9.3 Example: Defining Classes and Creating Objects \n" +
                            "-------------------------------------------------------------------------\n"
                    );
                }

                // Durum tests
                Assertions.assertEquals(true, durumNameValue instanceof String);
                Assertions.assertEquals(true, meatValue instanceof String);
                // constructor
                Assertions.assertEquals(true, durumConstructorExists());
                // checking if fields are private
                Assertions.assertEquals(true,   durumFieldIsPrivate("name"));
                Assertions.assertEquals(true,   durumFieldIsPrivate("meat"));
            }

            // Pizza tests
            Assertions.assertEquals(true, pizzaNameValue instanceof String);
            // constructor
            Assertions.assertEquals(true, pizzaConstructorExists());
            // checking if fields are private
            Assertions.assertEquals(true,   pizzaFieldIsPrivate("name"));
            Assertions.assertEquals(true,   pizzaFieldIsPrivate("ingredients"));
        }
    }


    // Task 3 Test
    @DisplayName("Checks OrderManager class functionality")
    @Test
    void orderTest() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Checking if OrderManager class exists
        if (!classExists("OrderManager")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 3:\n" +
                    " You need to create the OrderManager class to pass Test 3 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }

        // Checking if OrderManager menuItems fiels exists
        if (!fieldExists("OrderManager", "menuItems")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 3:\n" +
                    " You need to create a menuItems attribute in OrderManager class to pass Test 3 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // Checking if OrderManager menuItems attribute is an ArrayList<MenuItem>
        Object testOrderManagerObject = createOrderManagerTestObject();
        Field menuItemsField = getFieldFromClass("OrderManager", testOrderManagerObject, "menuItems");
        Object menuItemsValue = menuItemsField.get(testOrderManagerObject);

        if (!(menuItemsValue instanceof ArrayList)) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 3:\n" +
                    "          It looks like your OrderManager menuItems attribute type is not ArrayList \n" +
                    "          To find an example of an ArrayList you can use:  \n" +
                    "          \"Introduction to Java Programming and Data Structures book\"\n" +
                    "          Inheritance and Polymorphism, Listing 11.8 TestArrayList.java\n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // Checking if OrderManager addMenuItem method exists
        if (!addMenuItemMethodExists()) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 3:\n" +
                    " You need to create an addMenuItem method in OrderManager class\n" +
                    " To create this method you can use ArrayList.add \n" +
                    " you can find an example in the book" +
                    " \"Introduction to Java Programming and Data Structures book\"\n" +
                    "  Inheritance and Polymorphism, Listing 11.8 TestArrayList.java\n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // Checking if Order addMenuItem method exists
        if (!getMenuItemsMethodExists()) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 3:\n" +
                    " You need to create a getter method fo menuItem MenuItem [] in OrderManager class\n" +
                    "          To see an example of creating classes and attributes, try \n" +
                    "         \"Introduction to Java Programming and Data Structures book\"\n" +
                    "          9.9 Data Field Encapsulation, getter (or mutator) \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        if (!callMenuItemAddMethodWithPizza()) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 4:\n" +
                    " It looks like Pizza objects can not be added to your menuItems MenuItem [] in OrderManager class\n" +
                    "          Did you remember to extend the MenuItem class in Durum class? \n" +
                    "          You can find an example of inheritance here: \n" +
                    "         \"Introduction to Java Programming and Data Structures book\"\n" +
                    "          11.2 Superclasses and Subclasses, Example 11.2.2 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        if (!callMenuItemAddMethodWithDurum()) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 4:\n" +
                    " It looks like Durum objects can not be added to your menuItems MenuItem [] in OrderManager class\n" +
                    "          Did you remember to extend the MenuItem class in Durum class? \n" +
                    "          You can find an example of inheritance here: \n" +
                    "         \"Introduction to Java Programming and Data Structures book\"\n" +
                    "          11.2 Superclasses and Subclasses, Example 11.2.2 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // methods
        Assertions.assertEquals(true, addMenuItemMethodExists());
        // getters
        Assertions.assertEquals(true, getMenuItemsMethodExists());
        // checking if new menuItems can be added to Order menuItem String []
        Assertions.assertEquals(true,callMenuItemAddMethodWithPizza());
        Assertions.assertEquals(true,callMenuItemAddMethodWithDurum());

    }

    // Task 4 Test
    @DisplayName("Checks Durum Discount functionality")
    @Test
    void orderManagerDurumDiscountTest() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Checking if Pizza class exists
        if (!classExists("MenuItem") || !classExists("OrderManager")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 4:\n" +
                    " You need to create the MenuItem, and OrderManager classes to pass Test 4 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        if (callCalculateTotalPriceWithDurumDiscountMethod()==0.0) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 4:\n" +
                    " Looks like your calculateTotalPrice method does not add prices up \n" +
                    " it returns a zero. There are several things you can check.\n" +
                    " Make a for each loop to iterate through the ArrayList in OrderManager class\n" +
                    " The ++ operator adding prices up must be inside the loop\n" +
                    " Use menuItem.getPrice to access the price for each item\n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        if (callCalculateTotalPriceWithDurumDiscountMethod()==152.0) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 4:\n" +
                    " Looks like your calculateTotalPrice method does not \n" +
                    " subtract the discount. It adds up prices correctly, but\n" +
                    " id does not calculate totalPrice - durumDiscount\n" +
                    " Did you include this statement in your code?\n" +
                    " Another possible problem is not checking if\n" +
                    " menuItem is an instanceof Durum, to see if\n" +
                    " the order contains a Durum.\n" +
                    " You can find an example of using instance of in the book\n" +
                    "         \"Introduction to Java Programming and Data Structures book\"\n" +
                    "          11.9 Casting Objects and the instanceof Operator\n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        if (callCalculateTotalPriceWithDurumDiscountMethod()==132.0) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 4:\n" +
                    " Looks like your calculateTotalPrice method gives \n" +
                    " a discount for all items, on the menuItem list\n" +
                    " It should only give the discount for Durum items\n" +
                    " To check if a MenuItem is a Durum try to use\n" +
                    " instanceof operator, you can find examples here: \n" +
                    "         \"Introduction to Java Programming and Data Structures book\"\n" +
                    "          11.9 Casting Objects and the instanceof Operator\n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        if (callCalculateTotalPriceWithDurumDiscountMethod()==87.0) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 4:\n" +
                    " Looks like your calculateTotalPrice method only sums up pizza prices \n" +
                    " and does not add durum prices to totalPrice\n" +
                    " make sure you use menuItem.getPrice() in your calculations\n" +
                    " remember to iterate it using ++ operator\n" +
                    " use a loop to sum all prices in the order\n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        if (callCalculateTotalPriceWithDurumDiscountMethod()==65.0) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 4:\n" +
                    " Looks like your calculateTotalPrice method only sums up durum prices \n" +
                    " and does not add pizza prices to totalPrice\n" +
                    " make sure you use menuItem.getPrice() in your calculations\n" +
                    " remember to iterate it using ++ operator\n" +
                    " use a loop to sum all prices in the order\n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // checking is sum is correct
        Assertions.assertEquals(142.0, callCalculateTotalPriceWithDurumDiscountMethod());
    }

    // Task 5 Test
    @DisplayName("Checks Family Price functionality")
    @Test
    void orderManagerFamilyPizzaTest() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Checking if Pizza class exists
        if (!classExists("MenuItem") || !classExists("OrderManager")) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 5:\n" +
                    " You need to create the MenuItem, OrderManager and PizzaManager classes to pass Test 5 \n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        if (callCalculateTotalPriceMethod()==0.0) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 5:\n" +
                    " Looks like your calculateTotalPrice method does not add prices up \n" +
                    " it returns a zero. There are several things you can check.\n" +
                    " The ++ operator adding prices up must be inside the loop\n" +
                    " Use menuItem.getPrice to access the price for each item\n" +
                    " Make a loop to iterate through the menuItems ArrayList in Order class\n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        if (callCalculateTotalPriceMethod()==87.0) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 5:\n" +
                    " Looks like your calculateTotalPrice method only sums up pizza prices \n" +
                    " and does not add durum prices to totalPrice\n" +
                    " make sure you use menuItem.getPrice() in your calculations\n" +
                    " remember to iterate it using ++ operator\n" +
                    " use a loop to sum all prices in the order\n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        if (callCalculateTotalPriceMethod()==65.0) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 5:\n" +
                    " Looks like your calculateTotalPrice method only sums up durum prices \n" +
                    " and does not add pizza prices to totalPrice\n" +
                    " make sure you use menuItem.getPrice() in your calculations\n" +
                    " remember to iterate it using ++ operator\n" +
                    " use a loop to sum all prices in the order\n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        if (callCalculateTotalPriceFamilyPizzaMethod()==152.0) {
            fail("\n" +
                    "-------------------------------------------------------------------------\n" +
                    "AUTO-FEEDBACK:\n" +
                    "Step 5:\n" +
                    " Looks like your calculateTotalPrice method did not\n" +
                    " add extra 100 to totalPrice for the family pizza." +
                    " To successfully implement this method, try to\n" +
                    " check if menuItem ArrayList has items, that are\n" +
                    " instanceof Pizza, like in step 4\n" +
                    " If that condition is true, cast the menuItem\n" +
                    " To pizza to access the type parameter, using a getter\n" +
                    " You can find an example of casting here\n" +
                    " \"Introduction to Java Programming and Data Structures book\"\n" +
                    " 11.9 Casting Objects\n" +
                    "-------------------------------------------------------------------------\n"
            );
        }
        // checking if total sum including extra 100 for family pizza is correct
        Assertions.assertEquals(252, callCalculateTotalPriceFamilyPizzaMethod());

    }


    public boolean classExists(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException exception) {
            return false;
        }
    }

    public boolean fieldExists(String className, String fieldName) {
        try {
            Class<?> TempClass = Class.forName(className);
            Field field = TempClass.getDeclaredField(fieldName);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    public boolean pizzaFieldIsPrivate(String fieldName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            Class<?> TempClass = Class.forName("Pizza");
            Field field = TempClass.getDeclaredField(fieldName);
            Object pizzaTestObject = createPizzaTestObject();
            // checking if field is accessible
            field.get(pizzaTestObject);
            // this exception occurs then trying to access a private field
            return false;
        } catch (IllegalAccessException e ) {
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    public boolean menuItemFieldIsPrivate(String fieldName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            Class<?> TempClass = Class.forName("MenuItem");
            Field field = TempClass.getDeclaredField(fieldName);
            Object menuItemTestObject = createMenuItemTestObject();
            // checking if field is accessible
            field.get(menuItemTestObject);
            // this exception occurs then trying to access a private field
            return false;
        } catch (IllegalAccessException e ) {
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    public boolean durumFieldIsPrivate(String fieldName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            Class<?> TempClass = Class.forName("Durum");
            Field field = TempClass.getDeclaredField(fieldName);
            Object durumTestObject = createDurumTestObject();
            // checking if field is accessible
            field.get(durumTestObject);
            // this exception occurs then trying to access a private field
            return false;
        } catch (IllegalAccessException e ) {
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }


    public boolean addMenuItemMethodExists() {
        try {
            Class<?> OrderManagerClass = Class.forName("OrderManager");
            Class<?> MenuItemClass = Class.forName("MenuItem");
            Method addMenuItemMethod = OrderManagerClass.getMethod("addMenuItem", MenuItemClass);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public boolean getMenuItemsMethodExists() {
        try {
            Class<?> OrderManagerClass = Class.forName("OrderManager");
            Method getMenuItemsMethod = OrderManagerClass.getMethod("getMenuItems");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }


    private Object createPizzaTestObject() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // If Pizza class exists check if the name attribute is a String
        Class<?> TempClass = Class.forName("Pizza");
        // getting Pizza class constructor
        Constructor<?> constructor = TempClass.getConstructor(String.class, String.class);
        // Object array for the constructor attributes
        Object[] arguments = new Object[2];
        arguments[0] = "PizzaTestName";
        arguments[1] = "PizzaTestSize";
        // Instantiating Pizza object
        Object instance = constructor.newInstance(arguments);
        return instance;
    }

    private Object createMenuItemTestObject() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> TempClass = Class.forName("MenuItem");
        // getting MenuItem class constructor
        Constructor<?> constructor = TempClass.getConstructor(double.class);
        // Object array for the constructor attributes
        Object[] arguments = new Object[1];
        arguments[0] = 50.0;
        // Instantiating PMenuItem object
        Object instance = constructor.newInstance(arguments);
        return instance;
    }

    private Object createDurumTestObject() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> TempClass = Class.forName("Durum");
        // getting Pizza class constructor
        Constructor<?> constructor = TempClass.getConstructor(String.class, String.class);
        // Object array for the constructor attributes
        Object[] arguments = new Object[2];
        arguments[0] = "classic durum";
        arguments[1] ="kebab";
        Object instance = constructor.newInstance(arguments);
        return instance;
    }

    private Object createOrderManagerTestObject() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> TempClass = Class.forName("OrderManager");
        // getting OrderManager class constructor
        Constructor<?> constructor = TempClass.getConstructor();
        Object instance = constructor.newInstance();
        return instance;
    }

    private Field getFieldFromClass(String className, Object testObject, String attributeName) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> TempClass = Class.forName(className);
        Field field = TempClass.getDeclaredField(attributeName);
        field.setAccessible(true);
        return field;
    }


    private boolean callMenuItemAddMethodWithPizza() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        boolean menuItemAdded = false;
        try {
            // Making a new order object
            Class<?> OrderManagerClass = Class.forName("OrderManager");
            Constructor<?> constructor = OrderManagerClass.getConstructor();
            Object orderObject = constructor.newInstance();

            // Making a new MenuItem object
            Class<?> MenuItemClass = Class.forName("MenuItem");
            Method addMenuItemMethod = OrderManagerClass.getMethod("addMenuItem", MenuItemClass);

            // Making a pizza instance to invoke method with
            Class<?> PizzaClass = Class.forName("Pizza");
            Constructor<?> pizzaConstructor = PizzaClass.getConstructor(String.class, String.class);
            // Object array for the constructor attributes
            Object[] arguments = new Object[2];
            arguments[0] = "TestName";
            arguments[1] = "TestSize";
            // Instantiating Pizza object
            Object pizzaObject = pizzaConstructor.newInstance(arguments);

            // Make order menuItems field accessible
            Field orderMenuItemsField = OrderManagerClass.getDeclaredField("menuItems");
            orderMenuItemsField.setAccessible(true);

            // Invoke the method
            Object result = addMenuItemMethod.invoke(orderObject, pizzaObject);
            Object chArray = orderMenuItemsField.get(orderObject);
            menuItemAdded = (!chArray.toString().isEmpty());


        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        return menuItemAdded;
    }
    private boolean callMenuItemAddMethodWithDurum() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        boolean menuItemAdded = false;
        try {
            // Making a new order object
            Class<?> OrderManagerClass = Class.forName("OrderManager");
            Constructor<?> constructor = OrderManagerClass.getConstructor();
            Object orderObject = constructor.newInstance();

            // Making a new MenuItem object
            Class<?> MenuItemClass = Class.forName("MenuItem");
            Method addMenuItemMethod = OrderManagerClass.getMethod("addMenuItem", MenuItemClass);

            // Making a pizza instance to invoke method with
            Class<?> DurumClass = Class.forName("Durum");
            Constructor<?> durumConstructor = DurumClass.getConstructor(String.class, String.class);
            // Object array for the constructor attributes
            Object[] arguments = new Object[2];
            arguments[0] = "TestName";
            arguments[1] = "TestMeat";
            // Instantiating Durum object
            Object durumObject = durumConstructor.newInstance(arguments);

            // Make order menuItems field accessible
            Field orderMenuItemsField = OrderManagerClass.getDeclaredField("menuItems");
            orderMenuItemsField.setAccessible(true);

            // Invoke the method
            Object result = addMenuItemMethod.invoke(orderObject, durumObject);
            Object chArray = orderMenuItemsField.get(orderObject);
            menuItemAdded = (!chArray.toString().isEmpty());


        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        return menuItemAdded;
    }

    private double callCalculateTotalPriceMethod() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        double totalPrice = 0.0;
        try {
            // Making a new OrderManager object
            Class<?> OrderManagerClass = Class.forName("OrderManager");
            Constructor<?> constructor = OrderManagerClass.getConstructor();
            Object orderManagerObject = constructor.newInstance();

            // Accessing the calculate total price method
            Method calculateTotalPriceMethod = OrderManagerClass.getMethod("calculateTotalPrice");

            // Make order pizzas field accessible
            Field orderMenuItemsField = OrderManagerClass.getDeclaredField("menuItems");
            orderMenuItemsField.setAccessible(true);

            // Add a pizza to the order
            Class<?> MenuItemClass = Class.forName("MenuItem");
            Method addMenuItemMethod = OrderManagerClass.getMethod("addMenuItem", MenuItemClass);

            // Making a pizza instance
            Class<?> PizzaClass = Class.forName("Pizza");
            Constructor<?> pizzaConstructor = PizzaClass.getConstructor(String.class,String.class);
            // Object array for the constructor attributes
            Object[] arguments = new Object[2];
            arguments[0] = "TestName";
            arguments[1] = "TestSize";
            // Instantiating Pizza object
            Object pizzaObject = pizzaConstructor.newInstance(arguments);

            // Add a durum to the order
            Class<?> DurumClass = Class.forName("Durum");
            // Making a durum instance
            Constructor<?> durumConstructor = DurumClass.getConstructor(String.class, String.class);
            // Object array for the constructor attributes
            Object[] arguments2 = new Object[2];
            arguments2[0] = "TestName";
            arguments2[1] = "TestMeat";
            // Instantiating Durum object
            Object durumObject = durumConstructor.newInstance(arguments2);

            // Invoke the addPizza method to add it to the order
            addMenuItemMethod.invoke(orderManagerObject, pizzaObject);
            addMenuItemMethod.invoke(orderManagerObject, durumObject);

            // Invoke the calculateTotalPrice method
            Object result = calculateTotalPriceMethod.invoke(orderManagerObject);
            totalPrice = (double) result;

        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        return totalPrice;
    }
    private double callCalculateTotalPriceWithDurumDiscountMethod() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        double totalPrice = 0.0;
        try {
            // Making a new OrderManager object
            Class<?> OrderManagerClass = Class.forName("OrderManager");
            Constructor<?> constructor = OrderManagerClass.getConstructor();
            Object orderManagerObject = constructor.newInstance();

            // Accessing the calculate total price method
            Method calculateTotalPriceMethod = OrderManagerClass.getMethod("calculateTotalPrice", double.class);

            // Make order pizzas field accessible
            Field orderMenuItemsField = OrderManagerClass.getDeclaredField("menuItems");
            orderMenuItemsField.setAccessible(true);

            // Add a pizza to the order
            Class<?> MenuItemClass = Class.forName("MenuItem");
            Method addMenuItemMethod = OrderManagerClass.getMethod("addMenuItem", MenuItemClass);

            // Making a pizza instance
            Class<?> PizzaClass = Class.forName("Pizza");
            Constructor<?> pizzaConstructor = PizzaClass.getConstructor(String.class,String.class);
            // Object array for the constructor attributes
            Object[] arguments = new Object[2];
            arguments[0] = "TestName";
            arguments[1] = "TestSize";
            // Instantiating Pizza object
            Object pizzaObject = pizzaConstructor.newInstance(arguments);

            // Add a durum to the order
            Class<?> DurumClass = Class.forName("Durum");
            // Making a durum instance
            Constructor<?> durumConstructor = DurumClass.getConstructor(String.class, String.class);
            // Object array for the constructor attributes
            Object[] arguments2 = new Object[2];
            arguments2[0] = "TestName";
            arguments2[1] = "TestMeat";
            // Instantiating Durum object
            Object durumObject = durumConstructor.newInstance(arguments2);

            // Invoke the addPizza method to add it to the order
            addMenuItemMethod.invoke(orderManagerObject, pizzaObject);
            addMenuItemMethod.invoke(orderManagerObject, durumObject);

            // Invoke the calculateTotalPrice method
            Object result = calculateTotalPriceMethod.invoke(orderManagerObject, 10.0);
            totalPrice = (double) result;

        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        return totalPrice;
    }
    private double callCalculateTotalPriceFamilyPizzaMethod() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        double totalPrice = 0.0;
        try {
            // Making a new OrderManager object
            Class<?> OrderManagerClass = Class.forName("OrderManager");
            Constructor<?> constructor = OrderManagerClass.getConstructor();
            Object orderManagerObject = constructor.newInstance();

            // Accessing the calculate total price method
            Method calculateTotalPriceMethod = OrderManagerClass.getMethod("calculateTotalPrice");

            // Make order pizzas field accessible
            Field orderMenuItemsField = OrderManagerClass.getDeclaredField("menuItems");
            orderMenuItemsField.setAccessible(true);

            // Add a pizza to the order
            Class<?> MenuItemClass = Class.forName("MenuItem");
            Method addMenuItemMethod = OrderManagerClass.getMethod("addMenuItem", MenuItemClass);

            // Making a pizza instance
            Class<?> PizzaClass = Class.forName("Pizza");
            Constructor<?> pizzaConstructor = PizzaClass.getConstructor(String.class,String.class);
            // Object array for the constructor attributes
            Object[] arguments = new Object[2];
            arguments[0] = "TestName";
            arguments[1] = "family";
            // Instantiating Pizza object
            Object pizzaObject = pizzaConstructor.newInstance(arguments);

            // Add a durum to the order
            Class<?> DurumClass = Class.forName("Durum");
            // Making a durum instance
            Constructor<?> durumConstructor = DurumClass.getConstructor(String.class, String.class);
            // Object array for the constructor attributes
            Object[] arguments2 = new Object[2];
            arguments2[0] = "TestName";
            arguments2[1] = "TestMeat";
            // Instantiating Durum object
            Object durumObject = durumConstructor.newInstance(arguments2);

            // Invoke the addPizza method to add it to the order
            addMenuItemMethod.invoke(orderManagerObject, pizzaObject);
            addMenuItemMethod.invoke(orderManagerObject, durumObject);

            // Invoke the calculateTotalPrice method
            Object result = calculateTotalPriceMethod.invoke(orderManagerObject);
            totalPrice = (double) result;

        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        return totalPrice;
    }
    public boolean menuItemConstructorExists() {
        try {
            Class<?> MenuItemClass = Class.forName("MenuItem");
            Constructor<?> constructor = MenuItemClass.getConstructor(double.class);
            return true;

        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public boolean pizzaConstructorExists() {
        try {
            Class<?> PizzaClass = Class.forName("Pizza");
            Constructor<?> constructor = PizzaClass.getConstructor(String.class, String.class);
            return true;

        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public boolean durumConstructorExists() {
        try {
            Class<?> DurumClass = Class.forName("Durum");
            Constructor<?> constructor = DurumClass.getConstructor(String.class, String.class);
            return true;

        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
 }

/**
 * @author Maria Hansen
 */