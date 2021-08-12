package org.eniauction.models.bo;

public class Users {

    private int user_nb;
    private String pseudo;
    private String name;
    private String surname;
    private String email;
    private String phone_nb;
    private String street;
    private String postal_code;
    private String city;
    private String password;
    private int credit;
    private boolean administrator;
    
    public Users() {}

    public Users(int user_nb, String pseudo, String name, String surname, String email, String phone_nb, String street, String postal_code, String city, String password, int credit, boolean administrator) {
        this.user_nb = user_nb;
        this.pseudo = pseudo;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone_nb = phone_nb;
        this.street = street;
        this.postal_code = postal_code;
        this.city = city;
        this.password = password;
        this.credit = credit;
        this.administrator = administrator;
    }

    public int getUser_nb() {
        return user_nb;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_nb() {
        return phone_nb;
    }

    public String getStreet() {
        return street;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCity() {
        return city;
    }

    public String getPassword() {
        return password;
    }

    public int getCredit() {
        return credit;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setUser_nb(int user_nb) {
        this.user_nb = user_nb;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_nb(String phone_nb) {
        this.phone_nb = phone_nb;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}
