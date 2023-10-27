package org.firstinspires.ftc.teamcode.microcmd.gamepad;

import java.util.function.DoubleSupplier;

public class Axis {
    private DoubleSupplier value;

    public Axis(DoubleSupplier value) {
        this.value = value;
    }

    public void flip() {
        value = () -> -value.getAsDouble();
    }

    public void setDeadzone(double radius) {
        value = () -> Math.abs(value.getAsDouble()) < radius ? 0 : value.getAsDouble();
    }

    public double get() {
        return value.getAsDouble();
    }
}