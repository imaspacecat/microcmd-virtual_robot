package org.firstinspires.ftc.teamcode.microcmd.example;

import org.firstinspires.ftc.teamcode.microcmd.cmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;
import org.firstinspires.ftc.teamcode.microcmd.cmd.FullCmd;

import java.util.function.BooleanSupplier;

public class BindCmd extends FullCmd {
    public BindCmd(Cmd cmd, BooleanSupplier event, BooleanSupplier isFinished) {
        super(() -> {}, () -> {
                    if (event.getAsBoolean()) Scheduler.getInstance().schedule(cmd);
                }, () -> {}, isFinished
        );
    }
}
