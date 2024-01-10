package org.firstinspires.ftc.teamcode.microcmd.subsystem;

import org.firstinspires.ftc.teamcode.microcmd.Periodic;
import org.firstinspires.ftc.teamcode.microcmd.cmd.Cmd;

public abstract class Subsystem implements Periodic {
    private Cmd defaultCmd;

    public void setDefaultCmd(Cmd cmd) {
        defaultCmd = cmd;
    }

    public Cmd getDefaultCmd() {
        return defaultCmd;
    }

    @Override
    public void update() {}
}
