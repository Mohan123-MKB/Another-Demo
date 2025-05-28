package Demo1;
import java.util.*;
class Book{
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    Book(String title,String author,String isbn){
        this.title= title;
        this.author=author;
        this.isbn=isbn;
        this.isBorrowed=false;
    }
    public void borrow(){
        isBorrowed=true;
    }
    public void returnBook(){
        isBorrowed=false;
    }
    public String getTitle(){
        return title;
    }
    public boolean isBorrowed(){
        return isBorrowed;
    }
    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

}
class Member{
    private String name;
    private int memberId;
    private List<Book> listOfBorrowedBooks;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.listOfBorrowedBooks = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return listOfBorrowedBooks;
    }

    public void borrowBook(Book book){
        //book not borrow yet
        if(!book.isBorrowed()){
            //so book borrow
            book.borrow();
            listOfBorrowedBooks.add(book);
            System.out.println(name +" "+ " borrowed " +" "+ book.getTitle());
        }
        else{
            System.out.println("Book is already borrowed.");
        }
    }
    public void returnBook(Book book){
        if(listOfBorrowedBooks.contains(book)){
            book.returnBook();
            listOfBorrowedBooks.remove(book);
            System.out.println(name + "returned" + book.getTitle());
        }
        else{
            System.out.println("This book was not borrowed by " + name);
        }
    }
}
class Library{
    private String libName;
    private List<Book> books;
    private List<Member> mems;

    Library(String libName){
        this.libName=libName;
        this.books=new ArrayList<>();
        this.mems=new ArrayList<>();
    }
    public String getLibraryName(){
        return libName;
    }
    public List<Book> getBooks(){
        return books;
    }
    public List<Member> getMembers(){
        return mems;
    }
    //methods
    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }
    public void registerMember(Member mem){
        mems.add(mem);
        System.out.println("Member registered: " + mem.getName());
    }
    public Book findBookByTitle(String title){
        for(Book book:books){
            if(book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
    }
    public Member findMemberById(int id){
        for(Member mem:mems){
            if(mem.getMemberId()==id){
                return mem;
            }
        }
        return null;
    }
}
//test java
public class LibraryTest{
    public static void main(String ar[]){
        Library lib=new Library("Centeral Library");
        // craete and add books
        Book b1=new Book("Java","James Gosling","isbn001");
        Book b2=new Book("C++","Henry","isbn002");
        Book b3=new Book("Python","MatricKalsen","isbn003");
        Book b4=new Book("Science","Sanjaydut","isbn004");
        Book b5=new Book("Maths","Williams","isbn005");
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);
        lib.addBook(b4);
        lib.addBook(b5);
        System.out.println();
        System.out.println();
        //craete and register member
        Member m1=new Member("Alice",101);
        Member m2=new Member("Sanjay",102);
        Member m3=new Member("Dinesh",103);
        Member m4=new Member("kerthivasan",104);
        Member m5=new Member("Barath",105);
        lib.registerMember(m1);
        lib.registerMember(m2);
        lib.registerMember(m3);
        lib.registerMember(m4);
        lib.registerMember(m5);
        System.out.println();
        System.out.println();
        //members borrow return book
        Book foundBook1=lib.findBookByTitle("Java");
        Book foundBook2=lib.findBookByTitle("Python");
        if(foundBook1 !=null){
            m1.borrowBook(foundBook1);
            m2.returnBook(foundBook1);
        }
        System.out.println();
        if(foundBook2 !=null){
            m1.borrowBook(foundBook2);
            m2.returnBook(foundBook2);
        }
        System.out.println();
        System.out.println();
    }
}
