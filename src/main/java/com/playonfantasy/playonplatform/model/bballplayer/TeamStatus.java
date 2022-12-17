package com.playonfantasy.playonplatform.model.bballplayer;

public enum TeamStatus {
    IN("COMPETING"),
    OUT("ELIMINATED");

    public final String label;

    private TeamStatus(String label) {
        this.label = label;
    }
}
