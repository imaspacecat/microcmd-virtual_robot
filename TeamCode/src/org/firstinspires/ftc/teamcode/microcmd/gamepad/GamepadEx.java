package org.firstinspires.ftc.teamcode.microcmd.gamepad;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.microcmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.Periodic;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;
import org.firstinspires.ftc.teamcode.microcmd.example.BindCmd;

import java.util.function.BooleanSupplier;
import java.util.stream.Stream;


public class GamepadEx implements Periodic {
    public Button a, b, x, y, dpadUp, dpadDown, dpadLeft, dpadRight, leftBumper, rightBumper,
            leftStickButton, rightStickButton, leftTrigger, rightTrigger;
    public Stick leftStick, rightStick;
    private final Button[] buttons;

    public GamepadEx(Gamepad gamepad) {
        a = new Button(() -> gamepad.a);
        b = new Button(() -> gamepad.b);
        x = new Button(() -> gamepad.x);
        y = new Button(() -> gamepad.y);

        dpadUp = new Button(() -> gamepad.dpad_up);
        dpadDown = new Button(() -> gamepad.dpad_down);
        dpadLeft = new Button(() -> gamepad.dpad_left);
        dpadRight = new Button(() -> gamepad.dpad_right);

        leftBumper = new Button(() -> gamepad.left_bumper);
        rightBumper = new Button(() -> gamepad.right_bumper);

        leftStickButton = new Button(() -> gamepad.left_stick_button);
        rightStickButton = new Button(() -> gamepad.right_stick_button);

//        leftTrigger = new Button(() -> gamepad.left_trigger >= 0.5);

        leftTrigger = new Trigger(() -> gamepad.left_trigger);
        rightTrigger = new Trigger(() -> gamepad.left_trigger);

        leftStick = new Stick(() -> gamepad.left_stick_x, () -> gamepad.left_stick_y);
        rightStick = new Stick(() -> gamepad.right_stick_x, () -> gamepad.right_stick_y);

        buttons = new Button[]{a, b, x, y, dpadUp, dpadDown, dpadLeft, dpadRight, leftBumper, rightBumper,
                leftStickButton, rightStickButton, leftTrigger};

    }

    // TODO test multiple
    public void multiple(Cmd cmd, BooleanSupplier... events) {
        BooleanSupplier allEvents = () -> Stream.of(events).allMatch(BooleanSupplier::getAsBoolean);
        Scheduler.schedule(new BindCmd(cmd, allEvents, () -> false));
    }

    @Override
    public void update() {
        for (Button b : buttons) {
            b.update();
        }
    }
}
