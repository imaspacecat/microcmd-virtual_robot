package org.firstinspires.ftc.teamcode.microcmd.opmode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.microcmd.Periodic;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;
import org.firstinspires.ftc.teamcode.microcmd.cmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.microcmd.subsystem.Subsystem;

public abstract class OpModeEx extends OpMode implements Periodic {
    protected GamepadEx gamepadEx1;
    protected GamepadEx gamepadEx2;

    @Override
    public void init() {
        gamepadEx1 = new GamepadEx(gamepad1);
        gamepadEx2 = new GamepadEx(gamepad2);
        initialize();
    }

    @Override
    public void loop() {
        gamepadEx1.update();
        gamepadEx2.update();
        Scheduler.getInstance().update();
        update();
    }

    @Override
    public void update() {}

    public abstract void initialize();

    public void schedule(Cmd cmd) {
        Scheduler.getInstance().schedule(cmd);
    }

    public void register(Subsystem... subsystems) {
        for (Subsystem subsystem : subsystems) {
            schedule(subsystem.getDefaultCmd());
        }
    }
}
