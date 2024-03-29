package org.firstinspires.ftc.teamcode.microcmd.cmd;

public class SequentialCmd extends GroupCmd {
    private int index = 0;

    public SequentialCmd(Cmd... cmds) {
        super(cmds);
    }

    @Override
    public void init() {
        index = 0;
        cmds.get(0).init();
    }

    @Override
    public void loop() {
        if (cmds.get(index).isFinished()) {
            cmds.get(index).terminate();
            cmds.get(++index).init();
        } else {
            cmds.get(index).loop();
        }
    }

    @Override
    public void terminate() {
        cmds.forEach(Cmd::terminate);
    }

    @Override
    public boolean isFinished() {
        return cmds.get(cmds.size() - 1).isFinished() && index == cmds.size() - 1;
    }
}
