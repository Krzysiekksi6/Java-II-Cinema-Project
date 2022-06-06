package pl.cinema.model;

/**
 * Klasa opisująca użytkownika
 */
public class Customer {
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    /**
     * Konstruktor klasy użytkownik
     * @param  firstName firstName
     * @param lastName firstName
     * @param age age
     * @param email email
     */
    public Customer(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    /**
     * Konstruktor klasy użytkownik
     * @param firstName firstName
     * @param lastName lastName
     * @param email email
     */
    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Konstruktor bezparametrowy
     */
    public Customer(){}

    /**
     * Deklaracja getterów oraz setterów
     *
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return firstName +"/" + lastName + "/" + email;
    }
}
