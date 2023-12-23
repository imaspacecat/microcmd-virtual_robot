package org.firstinspires.ftc.teamcode.microcmd.opmode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;
import org.firstinspires.ftc.teamcode.microcmd.cmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.gamepad.GamepadEx;

public class OpModeEx extends OpMode {
    protected GamepadEx gamepadEx1;
    protected GamepadEx gamepadEx2;
    @Override
    public void init() {
        gamepadEx1 = new GamepadEx(gamepad1);
        gamepadEx2 = new GamepadEx(gamepad2);
    }

    @Override
    public void loop() {
        gamepadEx1.update();
        gamepadEx2.update();
        Scheduler.getInstance().update();
    }

    public void schedule(Cmd cmd) {
        Scheduler.getInstance().schedule(cmd);
    }
}
