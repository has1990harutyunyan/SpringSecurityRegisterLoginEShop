package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @Column(name = "sleeve_type")
    private String sleeveType;

    private String colour;

    @Column(name = "clothing_type")
    private String clothingType;

    private String currency;
    private double cost;
    private long quantity;
    private String availability;

    @Column(name = "state")
    private String condition;

    @Column(name = "main_pic")
    private String mainPic;

    public Product(Category category, Brand brand, String sleeveType, String colour, String clothingType, String currency,
                   double cost, long quantity, String availability, String condition, String mainPic) {
        this.category = category;
        this.brand = brand;
        this.sleeveType = sleeveType;
        this.colour = colour;
        this.clothingType = clothingType;
        this.currency = currency;
        this.cost = cost;
        this.quantity = quantity;
        this.availability = availability;
        this.condition = condition;
        this.mainPic = mainPic;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(String sleeveType) {
        this.sleeveType = sleeveType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getClothingType() {
        return clothingType;
    }

    public void setClothingType(String clothingType) {
        this.clothingType = clothingType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (Double.compare(product.cost, cost) != 0) return false;
        if (quantity != product.quantity) return false;
        if (category != null ? !category.equals(product.category) : product.category != null) return false;
        if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
        if (sleeveType != null ? !sleeveType.equals(product.sleeveType) : product.sleeveType != null) return false;
        if (colour != null ? !colour.equals(product.colour) : product.colour != null) return false;
        if (clothingType != null ? !clothingType.equals(product.clothingType) : product.clothingType != null)
            return false;
        if (currency != null ? !currency.equals(product.currency) : product.currency != null) return false;
        if (availability != null ? !availability.equals(product.availability) : product.availability != null)
            return false;
        if (condition != null ? !condition.equals(product.condition) : product.condition != null) return false;
        if (mainPic != null ? !mainPic.equals(product.mainPic) : product.mainPic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (sleeveType != null ? sleeveType.hashCode() : 0);
        result = 31 * result + (colour != null ? colour.hashCode() : 0);
        result = 31 * result + (clothingType != null ? clothingType.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (quantity ^ (quantity >>> 32));
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (mainPic != null ? mainPic.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", brand=" + brand +
                ", sleeveType='" + sleeveType + '\'' +
                ", colour='" + colour + '\'' +
                ", clothingType='" + clothingType + '\'' +
                ", currency='" + currency + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                ", availability='" + availability + '\'' +
                ", condition='" + condition + '\'' +
                ", mainPic='" + mainPic + '\'' +
                '}';
    }
}
