package org.firstinspires.ftc.teamcode.microcmd;

import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Cmds {
    public static Cmd instant(Runnable runnable) {
        return new FullCmd(runnable, () -> {}, () -> {}, () -> true);
    }

    public static Cmd bind(Cmd cmd, BooleanSupplier event, BooleanSupplier isFinished) {
        return new FullCmd(() -> {}, () -> {
                    if (event.getAsBoolean()) {
                        Scheduler.schedule(cmd);
                    }
                }, () -> {}, isFinished
        );
    }

    public static Cmd parallel(Cmd... cmds) {
        List<Cmd> lCmd = Arrays.asList(cmds);
        return new FullCmd(
                () -> lCmd.forEach(Cmd::init),
                () -> lCmd.forEach(Cmd::run),
                () -> lCmd.forEach(Cmd::terminate),
                () -> lCmd.stream().allMatch(Cmd::isFinished)
        );
    }

    public static Cmd sequential(Cmd... cmds) {
        return new SequentialCmd(cmds);
    }


}
