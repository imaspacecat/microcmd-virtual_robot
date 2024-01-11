package org.firstinspires.ftc.teamcode.tests;

import org.firstinspires.ftc.teamcode.microcmd.cmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.cmd.InstantCmd;
import org.firstinspires.ftc.teamcode.microcmd.subsystem.Subsystem;

public class LogSubsystem extends Subsystem {

    public Cmd log(String message, String name) {
        return new InstantCmd(() -> {
            System.out.println(name + ": " + message);
        });
    }
}
