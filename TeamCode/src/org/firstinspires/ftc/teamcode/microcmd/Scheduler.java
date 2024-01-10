package org.firstinspires.ftc.teamcode.microcmd;

import org.firstinspires.ftc.teamcode.microcmd.cmd.Cmd;

import java.util.Collections;
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
        for (Cmd scheduledCmd : cmds) {
            if (!cmd.getSubsystems().isEmpty() && !Collections.disjoint(cmd.getSubsystems(), scheduledCmd.getSubsystems())) {
                scheduledCmd.terminate();
                cmds.remove(scheduledCmd);
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

        cmds.forEach(Cmd::loop);
    }

    public void clear() {
        cmds.clear();
    }

    public Queue<Cmd> getCmds() {
        return cmds;
    }
}
