package org.example.model;


public class User {
    private final int id ;
    private final String name;
    private final String email;
    private final String password;
    private final String creditCardNumber ;

    public User(int id, String name, String email, String password, String creditCardNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.creditCardNumber = creditCardNumber;

    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                '}';
    }
}
