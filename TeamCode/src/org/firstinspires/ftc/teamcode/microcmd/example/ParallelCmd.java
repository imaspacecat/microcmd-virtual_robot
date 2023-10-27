package org.firstinspires.ftc.teamcode.microcmd.example;

import org.firstinspires.ftc.teamcode.microcmd.Cmd;

import java.util.Arrays;
import java.util.List;

public class ParallelCmd extends Cmd {
    private final List<Cmd> cmds;

    public ParallelCmd(Cmd... cmds) {
        this.cmds = Arrays.asList(cmds);
    }

    @Override
    public void init() {
        cmds.forEach(Cmd::init);
    }

    @Override
    public void run() {
        cmds.forEach(Cmd::run);
    }

    @Override
    public void terminate() {
        cmds.forEach(Cmd::terminate);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
