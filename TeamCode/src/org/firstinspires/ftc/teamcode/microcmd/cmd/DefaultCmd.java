package org.firstinspires.ftc.teamcode.microcmd.cmd;

import java.util.function.BooleanSupplier;

public class DefaultCmd extends Cmd{
    private final Runnable runnable;

    private final BooleanSupplier isFinished;

    public DefaultCmd(Runnable runnable, BooleanSupplier isFinished) {
        this.runnable = runnable;
        this.isFinished = isFinished;
    }

    @Override
    public void loop() {
        runnable.run();
    }

    @Override
    public boolean isFinished() {
        return isFinished.getAsBoolean();
    }
}
