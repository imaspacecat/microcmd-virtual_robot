package org.firstinspires.ftc.teamcode.microcmd.cmd;

import org.firstinspires.ftc.teamcode.microcmd.subsystem.Subsystem;

import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;

public abstract class Cmd {
    private final List<Subsystem> subsystems;

    public Cmd(Subsystem... subsystems) {
        this.subsystems = Arrays.asList(subsystems);
    }

    public void init() {}

    public void loop() {}

    public void terminate() {}

    public abstract boolean isFinished();

    public List<Subsystem> getSubsystems() {
        return subsystems;
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
        return getClass().getSimpleName()+"{" +
                "subsystems=" + subsystems +
                '}';
    }
}
