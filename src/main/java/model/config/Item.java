package model;

import lombok.Data;

import java.util.List;

@Data
public class Item {
    private String name;
    private String code;
    private List<Bundle> bundles;
}
