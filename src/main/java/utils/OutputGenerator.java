package utils;

import model.Input;
import model.config.Bundle;
import model.config.Config;
import model.config.Item;
import model.output.Combination;
import model.output.Output;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputGenerator {

    public Output generateOutput(Item item, Input input){
        Algorithm algorithm = new Algorithm();
        Output output = new Output();

        String itemName = input.getItem();
        int total = input.getTotal();
        HashMap<Integer, Integer> combination = algorithm.getCombination(item.toQuantityArray(), total);

        output.setNumber(total);
        output.setItemName(itemName);
        ArrayList<Combination> combinations = calculateUnitPrice(item, combination);
        output.setTotalPrice(getTotalPrice(combinations));
        output.setBundlesCombination(combinations);

        return output;
    }


    /* (item, unit price)*/
    private ArrayList<Combination> calculateUnitPrice(Item item, HashMap<Integer, Integer> combination){
        HashMap<Integer, Double> priceMapper = item.priceMapper();
        ArrayList<Combination> combinations = new ArrayList<Combination>();
        for (Integer i : combination.keySet()) {
            Double unitPrice = priceMapper.get(i);
            Double totalPrice = unitPrice * combination.get(i);
            Combination unit = new Combination(combination.get(i), i, totalPrice);
            combinations.add(unit);
        }
        return combinations;
    }

    private double getTotalPrice(ArrayList<Combination> unitPriceSum){
        double sum = 0;
        for (Combination combination : unitPriceSum) {
            sum += combination.getUnitPrice();
        }
        return sum;
    }





}
