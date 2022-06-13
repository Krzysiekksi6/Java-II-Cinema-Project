package pl.cinema.model;

/**
 * Klasa reprezentujaca bilet
 */
public class Ticket {

    private String id;
    private Customer customer;
    private double price;

    /**
     * Konstruktor reprezetujacy bilet
     * @param id id
     * @param customer customer
     * @param price price
     */
    public Ticket(String id, Customer customer, double price) {
        this.id = id;
        this.customer = customer;
        this.price = price;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
