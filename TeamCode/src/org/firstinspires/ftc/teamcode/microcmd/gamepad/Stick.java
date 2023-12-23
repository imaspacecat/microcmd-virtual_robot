package org.firstinspires.ftc.teamcode.microcmd.gamepad;

import java.util.function.DoubleSupplier;

public class Stick {
    public final Axis x;
    public final Axis y;

    public Stick(DoubleSupplier x, DoubleSupplier y) {
        this.x = new Axis(x);
        this.y = new Axis(y);
    }

    public void setDeadzone(double radius) {
        x.setDeadzone(radius);
        y.setDeadzone(radius);
    }

    public void flip() {
        x.flip();
        y.flip();
    }

    public static class Axis {
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
}
