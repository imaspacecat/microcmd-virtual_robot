package org.firstinspires.ftc.teamcode.microcmd.gamepad;

import java.util.function.DoubleSupplier;

public class Trigger extends Button {
    private final DoubleSupplier value;

    public Trigger(DoubleSupplier value, double threshold) {
        super(() -> value.getAsDouble() > threshold);
        this.value = value;
    }

    public Trigger(DoubleSupplier value) {
        this(value, 0.5);
    }

    public void setThreshold(double threshold) {
        setEvent(() -> value.getAsDouble() > threshold);
    }

    public DoubleSupplier getValue() {
        return value;
    }
}
