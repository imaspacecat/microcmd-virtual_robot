package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.microcmd.cmd.BindCmd;
import org.firstinspires.ftc.teamcode.microcmd.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.microcmd.opmode.OpModeEx;
@TeleOp
public class MainOpMode extends OpModeEx {
    private DriveSubsystem driveSubsystem;
    private LogSubsystem logSubsystem;
    @Override
    public void initialize() {
        DcMotorEx fl = hardwareMap.get(DcMotorEx.class, "front_left_motor");
        DcMotorEx fr = hardwareMap.get(DcMotorEx.class, "front_right_motor");
        DcMotorEx bl = hardwareMap.get(DcMotorEx.class, "back_left_motor");
        DcMotorEx br = hardwareMap.get(DcMotorEx.class, "back_right_motor");
        driveSubsystem = new DriveSubsystem(fl, fr, bl, br);
        logSubsystem = new LogSubsystem();
        driveSubsystem.setDefaultCmd(driveSubsystem.drive(gamepadEx1::getLeftStickX, gamepadEx1::getLeftStickY, gamepadEx1::getRightStickX));
        register(driveSubsystem);
    }

    @Override
    public void update() {
        super.update();

//        schedule(new BindCmd(logSubsystem.log("hi","bind command"), gamepadEx1.a.pressed(), gamepadEx1.a.released()));
    }

}
