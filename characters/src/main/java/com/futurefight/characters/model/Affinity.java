package com.futurefight.characters.model;

import java.util.Arrays;

public enum Affinity {
    blast("Blast"), speed("Speed"), combat("Combat"), universal("Universal");

    private String value;

    Affinity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

//    public static Affinity fromValue(String value) {
//        for (Affinity affinity : values()) {
//            if (affinity.value.equalsIgnoreCase(value)) {
//                return affinity;
//            }
//        }
//        throw new IllegalArgumentException(
//                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
//    }

}
