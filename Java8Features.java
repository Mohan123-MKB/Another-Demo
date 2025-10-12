import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.Random;
//fnzvlsdi
class Employee {
    String name;
    int salary;

    Employee(String n, int s) {
        name = n;
        salary = s;
    }

    public String toString() {
        return name + " " + salary;
    }
}

public class Lamda_expr {

    // ✅ static method must be declared at class level 
    static void printSquare(int n) {
        System.out.println(n * n);
    }

    public static void main(String[] args) {
        // 1. Sort a list of strings using lambda
        List<String> names = Arrays.asList("mohan", "arjun", "ravi");
        names.sort((a, b) -> a.compareTo(b));
        System.out.println(names); // [arjun, mohan, ravi]

        // 2. Create a thread using lambda
        Runnable task = () -> System.out.println("Running in " + Thread.currentThread().getName());
        new Thread(task).start();

        // 3. Filter even numbers using lambda
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = nums.stream()
                                   .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toList());
        System.out.println(result); // [2, 4]

        // 4. Convert a list of names to uppercase using lambda
        List<String> n = new ArrayList<>(Arrays.asList("ram", "sita", "kumar"));
        n.replaceAll(name -> name.toUpperCase());
        System.out.println(n); // [RAM, SITA, KUMAR]

        // 5. Sorting employees by salary
        List<Employee> employees = Arrays.asList(
            new Employee("A", 5000),
            new Employee("B", 10000),
            new Employee("C", 7000)
        );
        employees.sort((e1, e2) -> Integer.compare(e1.salary, e2.salary));
        System.out.println(employees); // [A 5000, C 7000, B 10000]

        // ------------------------------------------------------------------------------------------------------------------------

        // Functional Interfaces:
        // Predicate => check even numbers
        Predicate<Integer> isEven = e -> e % 2 == 0;
        System.out.println(isEven.test(10)); // true

        // Function => square numbers
        Function<Integer, Integer> sq = x -> x * x;
        System.out.println(sq.apply(5)); // 25

        // Consumer => print names
        Consumer<String> printer = na -> System.out.println(na);
        Arrays.asList("koki", "kumar").forEach(printer);

        // Supplier => generate random number
        Supplier<Integer> randNum = () -> new Random().nextInt(100);
        System.out.println(randNum.get());

//         Built-in:
// Predicate<T> → returns boolean
// Function<T,R> → transforms value
// Consumer<T> → performs action, no return
// Supplier<T> → supplies value

        // ---------------------------------------------------------------------------------------------------------------

        // Method References:
        // object::instanceMethod
        List<String> li = Arrays.asList("a", "b", "c");
        li.forEach(System.out::println);

        // class::staticMethod
        List<Integer> numbs = Arrays.asList(1, 2, 3, 4, 5);
        numbs.forEach(Lamda_expr::printSquare);

        // class::instanceMethod
        List<String> nms = Arrays.asList("mallar", "nilla");
        nms.sort(String::compareToIgnoreCase);
        System.out.println(nms);
    }
}
//Exception handling
//Multi threading and concuurency
//File I/O and serialization
//java 8 stream apis 
