package net.nbc.thetestermod.entity;

public class MobManager {

    private static boolean testerMobSpawned = false;

    // Checks if the mob has already spawned
    public static boolean hasTesterMobSpawned() {
        return testerMobSpawned;
    }

    // Sets the status of whether the mob is spawned
    public static void setTesterMobSpawned(boolean hasSpawned) {
        testerMobSpawned = hasSpawned;
    }
}
