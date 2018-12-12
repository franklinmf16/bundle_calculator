package model.output;

import lombok.Data;
import model.config.Bundle;

@Data
public class Combination {
    private int number;
    private int bundle;
    private double unitPrice;

    public Combination(int number, int bundle, double unitPrice) {
        this.number = number;
        this.bundle = bundle;
        this.unitPrice = unitPrice;
    }
}
