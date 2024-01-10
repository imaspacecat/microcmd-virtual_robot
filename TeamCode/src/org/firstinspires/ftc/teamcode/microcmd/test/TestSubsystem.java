package org.firstinspires.ftc.teamcode.microcmd.test;

import org.firstinspires.ftc.teamcode.microcmd.cmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.cmd.PrintCmd;
import org.firstinspires.ftc.teamcode.microcmd.subsystem.Subsystem;

import java.util.function.DoubleSupplier;

public class TestSubsystem extends Subsystem {
    private final DoubleSupplier supplier;

    public TestSubsystem(DoubleSupplier supplier) {
        this.supplier = supplier;

        setDefaultCmd(aDefaultcmd());
    }

    public Cmd doSomething() {
        return new PrintCmd("hi");
    }

    public Cmd aDefaultcmd() {
        return new PrintCmd("default!!");
    }

    public Cmd doSomething(DoubleSupplier leftStickX) {
        return new PrintCmd("something");
    }

}
