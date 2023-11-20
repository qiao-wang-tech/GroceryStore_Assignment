package edu.sdccd.cisc191.template;
import java.util.ArrayList;
import java.util.Objects;
public class GroceryItem {
    public String name;
    public double price;


    public GroceryItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public ArrayList<String> groceryList() {
        ArrayList<String> currentItems = new ArrayList<String>();
        currentItems.add("Ice Cream, $4.99, Not Organic");
        currentItems.add("Cilantro, $0.99, Organic");
        currentItems.add("Cookies, $1.99, Not Organic");
        currentItems.add("Green Grapes, $2.49,  Organic");

        return currentItems;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GroceryItem otherItem = (GroceryItem) obj;
        return Double.compare(otherItem.price, price) == 0 && Objects.equals(name, otherItem.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public int compareTo(GroceryItem otherItem) {
        // Compare items based on their names
        return this.name.compareTo(otherItem.name);
    }
}