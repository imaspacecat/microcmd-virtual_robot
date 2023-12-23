package org.firstinspires.ftc.teamcode.microcmd.cmd;

public class InstantCmd extends Cmd {
    private final Runnable runnable;

    public InstantCmd(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void init() {
        runnable.run();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
