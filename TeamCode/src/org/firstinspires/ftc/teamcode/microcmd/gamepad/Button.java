package org.firstinspires.ftc.teamcode.microcmd.gamepad;

import org.firstinspires.ftc.teamcode.microcmd.cmd.BindCmd;
import org.firstinspires.ftc.teamcode.microcmd.cmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.Periodic;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;

import java.util.function.BooleanSupplier;

import static org.firstinspires.ftc.teamcode.microcmd.gamepad.Button.ButtonState.*;

// TODO test all the different button conditions
public class Button implements Periodic {
    private BooleanSupplier event;
    protected boolean isDown = false;
    protected boolean wasDown = false;
    protected ButtonState currentState = NONE;

    public Button(BooleanSupplier event) {
        this.event = event;
    }

    public enum ButtonState {
        NONE, HELD, PRESSED, RELEASED
    }

    @Override
    public void update() {
        wasDown = isDown;
        isDown = event.getAsBoolean();

        if (isDown && wasDown) {
            currentState = HELD;
        } else if (isDown) {
            currentState = PRESSED;
        } else if (wasDown) {
            currentState = RELEASED;
        } else {
            currentState = NONE;
        }
    }

    public BooleanSupplier held() {
        return () -> currentState == HELD;
    }

    public void held(Cmd cmd) {
        Scheduler.getInstance().schedule(new BindCmd(cmd, held(), () -> false));
    }

    public BooleanSupplier pressed() {
        return () -> currentState == PRESSED;
    }

    public void pressed(Cmd cmd) {
        Scheduler.getInstance().schedule(new BindCmd(cmd, pressed(), () -> false));
    }

    public BooleanSupplier released() {
        return () -> currentState == RELEASED;
    }

    public void released(Cmd cmd) {
        Scheduler.getInstance().schedule(new BindCmd(cmd, released(), () -> false));
    }

    protected void setEvent(BooleanSupplier event) {
        this.event = event;
    }

    // TODO implement debouncer
}