package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.microcmd.cmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.cmd.DefaultCmd;
import org.firstinspires.ftc.teamcode.microcmd.subsystem.Subsystem;

import java.util.function.DoubleSupplier;

public class DriveSubsystem extends Subsystem {
    public DcMotorEx frontLeft, frontRight, backLeft, backRight;
    public DriveSubsystem(DcMotorEx frontLeft, DcMotorEx frontRight, DcMotorEx backLeft, DcMotorEx backRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;

        frontLeft.setDirection(DcMotorEx.Direction.REVERSE);
        backLeft.setDirection(DcMotorEx.Direction.REVERSE);

    }

    public Cmd drive(DoubleSupplier x, DoubleSupplier y, DoubleSupplier turn) {
        return new DefaultCmd(() -> {
            frontLeft.setPower(-y.getAsDouble() + x.getAsDouble() + turn.getAsDouble());
            frontRight.setPower(-y.getAsDouble() - x.getAsDouble() - turn.getAsDouble());
            backLeft.setPower(-y.getAsDouble() - x.getAsDouble() + turn.getAsDouble());
            backRight.setPower(-y.getAsDouble() + x.getAsDouble() - turn.getAsDouble());
            System.out.println(x.getAsDouble());
            System.out.println(y.getAsDouble());
            System.out.println(turn.getAsDouble());
        }, () -> false);
    }
}
