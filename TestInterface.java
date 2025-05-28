import java.util.*;
interface Payable{
    double calSalary();
}
class FullTimeEmployee implements Payable{
    private double monthlySalary;
    FullTimeEmployee(double monthlySalary){
        this.monthlySalary=monthlySalary;
    }
    public double calSalary() {
        return monthlySalary;
    }
}
class PartTimeEmployee implements Payable{
    private double hourlyWage;
    private int hoursWorked;
    PartTimeEmployee(double hourlyWage,int hoursWorked){
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }
     public double calSalary() {
        return hourlyWage * hoursWorked;
    }
}
public class TestInterface {
    public static void main(String[] args) {
        Payable fullTime = new FullTimeEmployee(5000);
        Payable partTime = new PartTimeEmployee(20, 120);
        
        System.out.println("Full-time salary: $" + fullTime.calSalary());
        System.out.println("Part-time salary: $" + partTime.calSalary());
    }
}