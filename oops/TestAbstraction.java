package Demo1;
//shape area calculation
abstract class Shape{
    abstract double area();
}
//Employee salary
abstract class Employee{
    String name;
    Employee(String name){
        this.name=name;
    }
    abstract double calculateSalary();
}
//vehicle start
abstract class Vehicle{
    abstract void start();
}
//Notification system
abstract class Notification{
    abstract void notifyUser();
}
//Bank account
abstract class BankAccount{
    abstract void withdraw(double amt);
    abstract void deposit(double amt);
}

//1.shape area calculation
class Circle extends Shape{
    double radius;
    Circle(double r){
        radius=r;
    }
    double area(){
        return Math.PI * radius * radius;
    }
}
class Rectangle extends Shape{
    double width,height;
    Rectangle(double w,double h){
        width=w;
        height=h;
    }
    double area(){
        return width * height;
    }
}
//2.Employee salary
class FullTimeEmployee extends Employee{
    double monthlySalary;
    FullTimeEmployee(String name,double salary){
        super(name);
        monthlySalary=salary;
    }
    double calculateSalary(){
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee{
    double hourlyRate;
    int hoursWorked;
    PartTimeEmployee(String name,double rate,int hours){
        super(name);
        hourlyRate=rate;
        hoursWorked=hours;
    }
    double calculateSalary(){
        return hourlyRate * hoursWorked;
    }
}
//3.vehicle start
class Car extends Vehicle{
    void start(){
        System.out.println("Car started with key");
    }
    public void move(){
        System.out.println("Car is movining");
    }
}
class Bike extends Vehicle{
    void start(){
        System.out.println("Bike started with key");
    }
    public void move(){
        System.out.println("Bike is movining");
    }
}
//4.Notification system
class EmailNotify extends Notification{
    void notifyUser(){
        System.out.println("Sending Email notification");
    }
}
class SMSNotify extends Notification{
    void notifyUser(){
        System.out.println("Sending SMS notification");
    }
}
//5.Bank account
class SavingsAccount extends BankAccount{
    double balance=0;
    void deposit(double amt){
        balance +=amt;
        System.out.println("Deposited " + amt);
    }
    void withdraw(double amt){
        if(balance >=amt){
            balance -=amt;
            System.out.println("withdraw " + amt);
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
}
//test abstraction
public class TestAbstraction {
    public static void main(String ar[]){
        Shape s=new Circle(5);
        Shape s1=new Rectangle(5,9);
        System.out.println("Area of Circle: "+s.area());
        System.out.println("Area of Circle: "+s1.area());
        System.out.println("Shape is completed" + "\n");
        Employee e1=new FullTimeEmployee("Joshkumar",70000);
        Employee e2=new PartTimeEmployee("Velukumar",5.00,8);
        System.out.println("FullTimeEmployee" + e1.calculateSalary());
        System.out.println("PartTimeEmployee" + e2.calculateSalary());
        System.out.println("Employee is completed" + "\n");
        Vehicle v1=new Car();
        Vehicle v2=new Bike();
        v1.start();
        v2.start();
        System.out.println("Vehicle is completed" + "\n");
        Notification n1=new EmailNotify();
        Notification n2=new SMSNotify();
        n1.notifyUser();
        n2.notifyUser();
        System.out.println("Notification is completed" + "\n");
        BankAccount b1=new SavingsAccount();
        b1.deposit(20000);
        b1.withdraw(1000);
        System.out.println("BankAccount is completed" + "\n");
        //so this is output
    }
}
