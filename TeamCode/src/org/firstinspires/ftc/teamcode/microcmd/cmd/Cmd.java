package org.firstinspires.ftc.teamcode.microcmd.cmd;

import java.util.function.BooleanSupplier;

public abstract class Cmd {
    private final String group;

    public Cmd(String group) {
        this.group = group;
    }

    public Cmd() {
        this(null);
    }

    public abstract void init();

    public void run() {
    }

    public void terminate() {
    }

    public abstract boolean isFinished();

    public String getGroup() {
        return group;
    }

    public Cmd with(Cmd... cmds) {
        ParallelCmd parallelCmd = new ParallelCmd(this);
        parallelCmd.addCmds(cmds);
        return parallelCmd;
    }

    public Cmd then(Cmd... cmds) {
        SequentialCmd sequentialCmd = new SequentialCmd(this);
        sequentialCmd.addCmds(cmds);
        return sequentialCmd;
    }

    public Cmd bind(BooleanSupplier event, BooleanSupplier isFinished) {
        return new BindCmd(this, event, isFinished);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "group='" + group + '\'' +
                '}';
    }
}
