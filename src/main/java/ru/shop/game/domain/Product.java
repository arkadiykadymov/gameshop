package ru.shop.game.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private double price;
    private int storage_count;
    private String filename;

    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL)
    private Set<Purchase> purchaseSet;

    public Product(String title, String description, double price, int s_count) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.storage_count = s_count;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStorage_count() {
        return storage_count;
    }

    public void setStorage_count(int storage_count) {
        this.storage_count = storage_count;
    }

    public Set<Purchase> getPurchaseSet() {
        return purchaseSet;
    }

    public void setPurchaseSet(Set<Purchase> purchaseSet) {
        this.purchaseSet = purchaseSet;
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", storage_count=" + storage_count +
                '}';
    }
}
