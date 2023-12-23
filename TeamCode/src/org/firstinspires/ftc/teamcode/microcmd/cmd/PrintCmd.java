package org.firstinspires.ftc.teamcode.microcmd.cmd;

public class PrintCmd extends InstantCmd {
    public PrintCmd(String s) {
        super(() -> System.out.println(s));
    }
}
