package com.playonfantasy.playonfantasyapi.model.player.basketball;

public enum InjuryStatus {
    HEALTHY("Healthy"),
    D2D("Day-to-day"),
    INJURED("Injured");

    public final String label;

    private InjuryStatus(String label) {
        this.label = label;
    }
}
