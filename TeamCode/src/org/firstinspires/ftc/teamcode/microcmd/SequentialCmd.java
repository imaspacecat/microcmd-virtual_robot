package org.firstinspires.ftc.teamcode.microcmd;

import java.util.Arrays;
import java.util.List;

public class SequentialCmd extends Cmd {
    private int index = 0;
    private final List<Cmd> cmds;

    public SequentialCmd(Cmd... cmds) {
        this.cmds = Arrays.asList(cmds);
    }

    @Override
    public void init() {
        cmds.get(0).init();
    }

    @Override
    public void run() {
        if (cmds.get(index).isFinished()) {
            cmds.get(index).terminate();
            cmds.get(++index).init();
        } else {
            cmds.get(index).run();
        }
    }

    @Override
    public void terminate() {
        cmds.forEach(Cmd::terminate);
    }

    @Override
    public boolean isFinished() {
        // TODO verify that the second condition is necessary
        return cmds.get(cmds.size() - 1).isFinished() && index == cmds.size() - 1;
    }
}
