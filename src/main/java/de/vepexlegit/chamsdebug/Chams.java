package de.vepexlegit.chamsdebug;

public enum Chams {
    INSTANCE;

    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
