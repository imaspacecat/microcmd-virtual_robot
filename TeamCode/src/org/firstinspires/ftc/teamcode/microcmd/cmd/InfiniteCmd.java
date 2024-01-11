package org.firstinspires.ftc.teamcode.microcmd.cmd;

public class InfiniteCmd extends Cmd{
    private final Runnable runnable;

    public InfiniteCmd(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void loop() {
        runnable.run();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
