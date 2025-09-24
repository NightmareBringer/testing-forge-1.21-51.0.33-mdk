package net.nbc.thetestermod.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum ArmoredAlienVariant {
    BLUE(0),
    GREEN(1);

    private static final ArmoredAlienVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator
            .comparingInt(ArmoredAlienVariant::getId)).toArray(ArmoredAlienVariant[]::new);

    private final int id;

    ArmoredAlienVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ArmoredAlienVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
