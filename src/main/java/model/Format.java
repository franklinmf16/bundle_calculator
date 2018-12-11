package model;

import lombok.Data;

import java.util.List;

@Data
public class Format {
    private String name;
    private String code;
    private List<Bundle> bundles;

}
