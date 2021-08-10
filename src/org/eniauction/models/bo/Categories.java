package org.eniauction.models.bo;

public class Categories {

    private int category;
    private String wording;

    public Categories(int category, String wording) {
        this.category = category;
        this.wording = wording;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }
}
