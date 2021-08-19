package functionalinterface;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
public class Sample1 {


    @FunctionalInterface
    interface CalculateAdd{
        public int run(int a,int b);
    }

    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);
        File dir = new File(".");
        Arrays.stream(dir.listFiles())
                .filter(f -> f.isFile())
                .filter(f -> !f.getName().startsWith("."))
                .map(f -> f.getName() + " " + f.length())
                .sorted()
                .forEach(s -> System.out.println(s));

        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
    }
    /*
        CalculateAdd fun = (a,b) -> a+b;
        System.out.println(fun.run(1, 2));
     */

    /*

    Predicates
    In mathematical logic, a predicate is a function that receives a value and returns a boolean value.

    The Predicate functional interface is a specialization of a Function that receives a
    generified value and returns a boolean. A typical use case of the Predicate lambda is to filter a collection of values:

    List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");

    List<String> namesWithA = names.stream()
   .filter(name -> name.startsWith("A"))
   .collect(Collectors.toList());
    In the code above, we filter a list using the Stream API and keep only the names that start with the letter “A”. The Predicate implementation encapsulates the filtering logic.

    As in all of the previous examples, there are IntPredicate, DoublePredicate and LongPredicate versions of this function that receive primitive values.
     */

    /*
    As opposed to the Supplier, the Consumer accepts a generified argument and returns nothing. It is a function that is representing side effects.

For instance, let’s greet everybody in a list of names by printing the greeting in the console. The lambda passed to the List.forEach method implements the Consumer functional interface:

List<String> names = Arrays.asList("John", "Freddy", "Samuel");
names.forEach(name -> System.out.println("Hello, " + name));
     */

/*
Operators


Operator interfaces are special cases of a function that receive and return the same value type. The UnaryOperator interface receives a single argument. One of its use cases in the Collections API is to replace all values in a list with some computed values of the same type:

List<String> names = Arrays.asList("bob", "josh", "megan");

names.replaceAll(name -> name.toUpperCase());
 */

}
