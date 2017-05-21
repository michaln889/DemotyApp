package com.mn;


public enum Color {
    AQUA("Aqua", "#59b3b3"),
    BLUE("Blue", "#5976b3"),
    PURPLE("Purple","#7e59b3"),
    FUCHSIA("Fuchsia", "#b35986"),
    ORANGE("Orange", "#b36859"),
    GOLD("Gold", "#b38f59");

    private String name;
    private String hexCode;

    Color(String name, String hexCode) {
        this.name = name;
        this.hexCode = hexCode;
    }

    public String getName() {
        return name;
    }

    public String getHexCode() {
        return hexCode;
    }
}
