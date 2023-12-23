package org.firstinspires.ftc.teamcode.microcmd.opmode.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;
import org.firstinspires.ftc.teamcode.microcmd.cmd.InstantCmd;
import org.firstinspires.ftc.teamcode.microcmd.cmd.PrintCmd;
import org.firstinspires.ftc.teamcode.microcmd.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.microcmd.opmode.OpModeEx;


@TeleOp
public class TestSequentialOpMode extends OpModeEx {
    @Override
    public void initialize() {
        gamepadEx1.leftTrigger.held(new InstantCmd(() -> System.out.println("asd")));
        gamepadEx1.leftStick.flip();
        gamepadEx1.a.pressed(new PrintCmd("asdasd"));
    }
}
