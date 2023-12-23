package org.firstinspires.ftc.teamcode.microcmd.opmode.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;
import org.firstinspires.ftc.teamcode.microcmd.cmd.InstantCmd;
import org.firstinspires.ftc.teamcode.microcmd.gamepad.GamepadEx;


@TeleOp
public class TestSequentialOpMode extends OpMode {
    private GamepadEx gamepad;


    @Override
    public void init() {
        gamepad = new GamepadEx(gamepad1);
        gamepad.leftTrigger.held(new InstantCmd(() -> System.out.println("asd")));
        gamepad.leftStick.flip();
    }

    @Override
    public void loop() {
        gamepad.update();
        Scheduler.getInstance().update();
//        if (gamepad.y.pressed().getAsBoolean()) {
//            System.out.println(Scheduler.getCmds());
//        }
    }
}
