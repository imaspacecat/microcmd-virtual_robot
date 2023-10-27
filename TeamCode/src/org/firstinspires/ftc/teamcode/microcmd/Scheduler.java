package org.firstinspires.ftc.teamcode.microcmd;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Scheduler {
    private static final Queue<Cmd> cmds = new ConcurrentLinkedQueue<>();

    public static void schedule(Cmd cmd) {
        for (Cmd lCmd : cmds) {
            if (cmd.getGroup() != null && cmd.getGroup().equals(lCmd.getGroup())) {
                lCmd.terminate();
                cmds.remove(lCmd);
            }
        }

        cmd.init();
        cmds.add(cmd);
    }

    public static void run() {
        for (Cmd cmd : cmds) {
            if (cmd.isFinished()) {
                cmd.terminate();
                cmds.remove(cmd);
            }
        }

        cmds.forEach(Cmd::run);
    }

    public static Queue<Cmd> getCmds() {
        return cmds;
    }
}
