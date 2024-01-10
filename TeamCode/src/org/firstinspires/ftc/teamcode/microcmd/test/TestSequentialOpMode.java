package org.firstinspires.ftc.teamcode.microcmd.test;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorExImpl;
import org.firstinspires.ftc.teamcode.microcmd.cmd.PrintCmd;
import org.firstinspires.ftc.teamcode.microcmd.opmode.OpModeEx;


@TeleOp
public class TestSequentialOpMode extends OpModeEx {
    @Override
    public void initialize() {
        gamepadEx1.multiple(new PrintCmd("multiple!~!!"), gamepadEx1.a.held(), gamepadEx1.y.released());
//        gamepadEx1.a.held(new PrintCmd("a"));
//        gamepadEx1.y.released(new PrintCmd("y"));
        TestSubsystem subsystem = new TestSubsystem(gamepadEx1::getLeftStickX);
        schedule(subsystem.doSomething());
    }
}
