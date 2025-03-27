package net.nbc.thetestermod.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum TesterVariant {
    WHITE(0),
    RARE(1);

    private static final TesterVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator
            .comparingInt(TesterVariant::getId)).toArray(TesterVariant[]::new);

    private final int id;

    TesterVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static TesterVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
