package org.eniauction.models.bo;

public class Withdrawals {
    private int article_nb;
    private String street;
    private String postal_code;
    private String city;

    public Withdrawals(int article_nb, String street, String postal_code, String city) {
        this.article_nb = article_nb;
        this.street = street;
        this.postal_code = postal_code;
        this.city = city;
    }

    public int getArticle_nb() {
        return article_nb;
    }

    public void setArticle_nb(int article_nb) {
        this.article_nb = article_nb;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
