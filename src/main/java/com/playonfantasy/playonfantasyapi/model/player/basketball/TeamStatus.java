package com.playonfantasy.playonfantasyapi.model.player.basketball;

public enum TeamStatus {
    IN("COMPETING"),
    OUT("ELIMINATED");

    public final String label;

    private TeamStatus(String label) {
        this.label = label;
    }
}
