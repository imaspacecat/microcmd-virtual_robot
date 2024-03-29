package org.firstinspires.ftc.teamcode.microcmd.cmd;

public class ParallelCmd extends GroupCmd {
    public ParallelCmd(Cmd... cmds) {
        super(cmds);
    }

    @Override
    public void init() {
        cmds.forEach(Cmd::init);
    }

    @Override
    public void loop() {
        cmds.forEach(Cmd::loop);
    }

    @Override
    public void terminate() {
        cmds.forEach(Cmd::terminate);
    }

    @Override
    public boolean isFinished() {
        return cmds.stream().allMatch(Cmd::isFinished);
    }
}
