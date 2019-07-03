package com.staff.staffapp.pns.model;

public class Product {
    int id;
    String title;
    String description;
    String category;
    String link;

    public Product() {
    }

    public Product(int id, String title, String description, String category, String link) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getLink() {
        return link;
    }
}
