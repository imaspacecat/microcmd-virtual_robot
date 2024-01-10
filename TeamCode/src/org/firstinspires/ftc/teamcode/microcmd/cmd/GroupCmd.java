package org.firstinspires.ftc.teamcode.microcmd.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class GroupCmd extends Cmd {
    protected final List<Cmd> cmds = new ArrayList<>();

    protected GroupCmd(Cmd... cmds) {
        addCmds(cmds);
    }

    public void addCmds(Cmd... cmds) {
        if (!Collections.disjoint(this.cmds, Arrays.asList(cmds))) {
            throw new IllegalArgumentException("The same command cannot be added multiple times");
        }
        this.cmds.addAll(Arrays.asList(cmds));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "cmds=" + cmds +
                '}';
    }
}
