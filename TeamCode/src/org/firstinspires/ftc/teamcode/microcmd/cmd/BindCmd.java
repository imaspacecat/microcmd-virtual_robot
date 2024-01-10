package org.firstinspires.ftc.teamcode.microcmd.cmd;

import org.firstinspires.ftc.teamcode.microcmd.Scheduler;

import java.util.function.BooleanSupplier;

public class BindCmd extends Cmd {
    private final BooleanSupplier event, isFinished;
    private final Cmd cmd;

    public BindCmd(Cmd cmd, BooleanSupplier event, BooleanSupplier isFinished) {
        this.event = event;
        this.cmd = cmd;
        this.isFinished = isFinished;
    }

    @Override
    public void loop() {
        if (event.getAsBoolean()) {
            Scheduler.getInstance().schedule(cmd);
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished.getAsBoolean();
    }
}
