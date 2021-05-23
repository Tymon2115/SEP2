package shared.Reservation;


import java.io.Serializable;

public class Address implements Serializable {
    private String city;
    private String street;
    private String zip;
    private String country;

    public Address(String street, String city, String zip, String country) {
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

