package org.firstinspires.ftc.teamcode.microcmd;

public abstract class Cmd {
    private final String group;

    public Cmd(String group) {
        this.group = group;
    }

    public Cmd() {
        this(null);
    }

    public abstract void init();

    public void run() {}

    public void terminate() {}

    public abstract boolean isFinished();

    public String getGroup() {
        return group;
    }
}
