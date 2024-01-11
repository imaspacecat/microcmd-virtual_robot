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

    public void schedule(Cmd... cmds) {
        for (Cmd cmd : cmds) {
            for (Cmd scheduledCmd : this.cmds) {
                if (!scheduledCmd.getSubsystems().isEmpty() && !Collections.disjoint(scheduledCmd.getSubsystems(), cmd.getSubsystems())) {
                    scheduledCmd.terminate();
                    this.cmds.remove(scheduledCmd);
                }
            }

            cmd.init();
            this.cmds.add(cmd);
        }
    }

    public boolean isScheduled(Cmd... cmds) {
        for (Cmd cmd : cmds) {
            for (Cmd scheduledCmd : this.cmds) {
                if (scheduledCmd == cmd) return true;
            }
        }
        return false;
    }

    public void cancel(Cmd... cmds) {
        for (Cmd cmd : cmds) {
            for (Cmd scheduledCmd : this.cmds) {
                if (scheduledCmd == cmd) {
                    scheduledCmd.terminate();
                    this.cmds.remove(scheduledCmd);
                }
            }
        }
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
