package model;

import lombok.Data;

@Data
public class Input {
    private int total;
    private String item;

    public Input(int total, String item) {
        this.total = total;
        this.item = item;
    }
}
