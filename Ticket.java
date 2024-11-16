import org.w3c.dom.ls.LSOutput;

import java.io.FileWriter;
import java.io.IOException;

public class Ticket {

    private String row;
    private int seat;
    private double price;
    private Person person;

    // Constructor
    public Ticket(String row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // Getters and setters
    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // Method to print information
    public void printInfo() {
        System.out.println("Row: " + this.row);
        System.out.println("Seat: " + this.seat);
        System.out.println("Price: " + this.price);
        System.out.println("Ticket Holder Information:");
        this.person.printInfo();
    }

    public void save() {
        try {
            FileWriter myfile=new FileWriter(this.row+ this.seat);
            myfile.write("Name:"+person.getName());
            myfile.write("\nSurname: "+person.getSurname());
            myfile.write("\nEmail: "+person.getEmail());
            myfile.write("\nRow: "+getRow());
            myfile.write("\nSeat: "+getSeat());
            myfile.write("\nPrice: "+getPrice());
            myfile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

