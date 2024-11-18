package ru.otus.java.basic.homeworks.hw13;

public enum TerrainType {
    DENSE_FORST("густой лес"),
    FLATLAND("равнина"),
    SWAMP("болото");

    private String name;

    TerrainType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
