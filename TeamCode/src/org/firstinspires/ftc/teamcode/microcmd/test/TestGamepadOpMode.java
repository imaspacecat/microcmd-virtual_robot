package org.firstinspires.ftc.teamcode.microcmd.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;
import org.firstinspires.ftc.teamcode.microcmd.cmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.cmd.InstantCmd;
import org.firstinspires.ftc.teamcode.microcmd.cmd.SequentialCmd;
import org.firstinspires.ftc.teamcode.microcmd.gamepad.GamepadEx;


@TeleOp
public class TestGamepadOpMode extends OpMode {
    private GamepadEx gamepad;

    @Override
    public void init() {
        gamepad = new GamepadEx(gamepad1);
        gamepad.a.pressed(new InstantCmd(() -> System.out.println("hi")));
        Scheduler.getInstance().schedule(new InstantCmd(() -> System.out.println("test")));
        gamepad.b.pressed(new InstantCmd(() -> System.out.println("pressed")));
        gamepad.b.released(new InstantCmd(() -> System.out.println("released")));

        Cmd forX = new InstantCmd(() -> System.out.println("first"))
                .then(new InstantCmd(() -> System.out.println("second")))
                .then(new InstantCmd(() -> System.out.println("third")));
        System.out.println(forX);
        gamepad.x.pressed(forX);

        gamepad.y.pressed(new SequentialCmd(new InstantCmd(() -> System.out.println("a")), new InstantCmd(() -> System.out.println("b")),
                new InstantCmd(() -> System.out.println("c"))));

        Scheduler.getInstance().schedule(new SequentialCmd(new InstantCmd(() -> System.out.println("a")), new InstantCmd(() -> System.out.println("b")),
                new InstantCmd(() -> System.out.println("c"))));

    }

    boolean prev = false;
    boolean curr = false;

    @Override
    public void loop() {
//        prev = curr;
//        curr = gamepad1.x;
//        if (curr && !prev) {
//            System.out.println("asdasdasd");
//        }
//        ElapsedTime time = new ElapsedTime();
        gamepad.update();
//        System.out.println(time.time());
        Scheduler.getInstance().update();
        if (gamepad.y.pressed().getAsBoolean()) {
            System.out.println(Scheduler.getInstance().getCmds());
        }
    }
}
