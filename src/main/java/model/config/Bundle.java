package model.config;

import lombok.Data;

@Data
public class Bundle {
    private int quantity;
    private double price;

    public Bundle(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
}
