package org.firstinspires.ftc.teamcode.microcmd.gamepad;

import org.firstinspires.ftc.teamcode.microcmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.Periodic;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;
import org.firstinspires.ftc.teamcode.microcmd.example.BindCmd;

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

    public void scheduleIf(Cmd cmd, BooleanSupplier event) {
        Scheduler.schedule(new BindCmd(cmd, event, () -> false));
    }

    public BooleanSupplier held() {
        return () -> currentState == HELD;
    }

    public void held(Cmd cmd) {
        scheduleIf(cmd, held());
    }

    public BooleanSupplier pressed() {
        return () -> currentState == PRESSED;
    }

    public void pressed(Cmd cmd) {
        scheduleIf(cmd, pressed());
    }

    public BooleanSupplier released() {
        return () -> currentState == RELEASED;
    }

    public void released(Cmd cmd) {
        scheduleIf(cmd, released());
    }

    protected void setEvent(BooleanSupplier event) {
        this.event = event;
    }

    // TODO implement debouncer
}