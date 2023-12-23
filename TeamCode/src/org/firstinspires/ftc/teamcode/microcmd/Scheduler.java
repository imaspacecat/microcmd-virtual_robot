package org.firstinspires.ftc.teamcode.microcmd;

import org.firstinspires.ftc.teamcode.microcmd.cmd.Cmd;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Scheduler implements Periodic {
    private final Queue<Cmd> cmds = new ConcurrentLinkedQueue<>();
    private static final Scheduler instance = new Scheduler();

    private Scheduler() {}

    public static Scheduler getInstance() {
        return instance;
    }

    public void schedule(Cmd cmd) {
        for (Cmd lCmd : cmds) {
            if (cmd.getGroup() != null && cmd.getGroup().equals(lCmd.getGroup())) {
                lCmd.terminate();
                cmds.remove(lCmd);
            }
        }

        cmd.init();
        cmds.add(cmd);
    }

    @Override
    public void update() {
        for (Cmd cmd : cmds) {
            if (cmd.isFinished()) {
                cmd.terminate();
                cmds.remove(cmd);
            }
        }

        cmds.forEach(Cmd::run);
    }

    public Queue<Cmd> getCmds() {
        return cmds;
    }
}
