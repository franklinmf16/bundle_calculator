package model.output;


import lombok.Data;

import java.util.List;

@Data
public class Output {
    private int number;
    private String itemName;
    private Double totalPrice;
    private List<Combination> bundlesCombination;
}
