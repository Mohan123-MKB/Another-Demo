import java.util.*;
//Employee Payment System
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

//Shape calculate area and perimeter
interface Shape{
    double getArea();
    double getPerimeter();
}
class Circle implements Shape{
    private double radius;
    Circle(double r){
        radius=r;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
     public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
}
class Rectangle implements Shape{
    private double l,w;
    Rectangle(double le,double wi){
        l=le;
        w=wi;
    }
    public double getArea(){
        return l*w;
    }
     public double getPerimeter(){
        return 2*(l+w);
    }  
}
class Triangle implements Shape{
    private double a,ba,c;
    Triangle(double l,double b,double h){
        a=l;
        ba=b;
        c=h;
    }
    public double getPerimeter(){
        return a+ba+c;
    }
    public double getArea(){
        double s=getPerimeter()/2;
        return Math.sqrt(s*(s-a)*(s-ba)*(s-c));

    }
}

//Notification System
interface Notification{
    void notifyUser(String message);
}
class EmailNotify implements Notification{
    public void notifyUser(String message){
        System.out.println("Email message: "+ message);
    }
}
class SMSNotify implements Notification{
    public void notifyUser(String message){
        System.out.println("SMS message: "+ message);
    }
}
class PushNotify implements Notification{
    public void notifyUser(String message){
        System.out.println("Push message: "+ message);
    }
}
class NotificationSystem{
    private Notification notification;
    NotificationSystem( Notification notification){
        this.notification= notification;
    }
    public void send(String message) {
        notification.notifyUser(message);
    }
}

//vehicle interface
interface Vehicle {
    void start();
    void accelerate();
    void stop();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car started");
    }
    public void accelerate() {
        System.out.println("Car accelerating");
    }
    public void stop() {
        System.out.println("Car stopped");
    }
}

class Motorcycle implements Vehicle {
    public void start() {
        System.out.println("Motorcycle started");
    }
    public void accelerate() {
        System.out.println("Motorcycle accelerating");
    }
    public void stop() {
        System.out.println("Motorcycle stopped");
    }
}

class Truck implements Vehicle {
    private int loadCapacity;
    
    public Truck(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    
    public void start() {
        System.out.println("Truck started");
    }
    public void accelerate() {
        System.out.println("Truck accelerating with load capacity " + loadCapacity + " tons");
    }
    public void stop() {
        System.out.println("Truck stopped");
    }
}

public class TestInterface {
    public static void main(String[] args) {
        Payable fullTime = new FullTimeEmployee(5000);
        Payable partTime = new PartTimeEmployee(20, 120);
        
        System.out.println("Full-time salary: $" + fullTime.calSalary());
        System.out.println("Part-time salary: $" + partTime.calSalary());

        System.out.println();
        System.out.println();

        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 7);
        Shape triangle = new Triangle(3, 4, 5);
        
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Circle perimeter: " + circle.getPerimeter());
        
        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());
        
        System.out.println("Triangle area: " + triangle.getArea());
        System.out.println("Triangle perimeter: " + triangle.getPerimeter());

        System.out.println();
        System.out.println();
        NotificationSystem emailService=new NotificationSystem(new EmailNotify());
        emailService.send("Yours order has been shipped!");
        NotificationSystem smsService=new NotificationSystem(new SMSNotify());
        smsService.send("Yours OTP is 12345!");
        NotificationSystem pushService=new NotificationSystem(new PushNotify());
        pushService.send("You have a new friend request!");

        System.out.println();
        System.out.println(); 
        
         Vehicle car = new Car();
        Vehicle bike = new Motorcycle();
        Vehicle truck = new Truck(10);
        
        car.start();
        car.accelerate();
        car.stop();
        
        bike.start();
        bike.accelerate();
        bike.stop();
        
        truck.start();
        truck.accelerate();
        truck.stop();
    }
}