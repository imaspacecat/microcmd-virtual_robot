package org.firstinspires.ftc.teamcode.microcmd.example;

import org.firstinspires.ftc.teamcode.microcmd.Cmd;
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
    public void init() {}

    @Override
    public void run() {
        if (event.getAsBoolean()) {
            Scheduler.schedule(cmd);
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished.getAsBoolean();
    }
}
