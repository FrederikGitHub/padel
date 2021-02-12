package com.realdolmen.padel.exception;

public enum Severity {
    trace,
    info,
    warning,
    error;

    private Severity() {
    }

    public static Severity safeValueOf(String severity) {
        Severity[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Severity s = var1[var3];
            if (s.name().equalsIgnoreCase(severity)) {
                return s;
            }
        }

        return null;
    }
}
