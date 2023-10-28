package org.firstinspires.ftc.teamcode.microcmd.opmode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;
import org.firstinspires.ftc.teamcode.microcmd.gamepad.GamepadEx;

import static org.firstinspires.ftc.teamcode.microcmd.Cmds.instant;

@TeleOp
public class TestGamepadOpMode extends OpMode {
    private GamepadEx gamepad;
    @Override
    public void init() {
        gamepad = new GamepadEx(gamepad1);
        gamepad.a.pressed(instant(() -> System.out.println("hi")));
        Scheduler.schedule(instant(() -> System.out.println("test")));
        gamepad.b.pressed(instant(() -> System.out.println("pressed")));
        gamepad.b.released(instant(() -> System.out.println("released")));
    }

    @Override
    public void loop() {
        gamepad.update();
        Scheduler.run();
    }
}
