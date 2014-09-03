package com.module.wview.MSGView;

/**
 * A class provide the current time (like {@link System#currentTimeMillis()}).
 * It's intended to be mocked out for unit tests.
 */
public class Clock {
    public static final Clock INSTANCE = new Clock();

    protected Clock() {
    }

    public long getTime() {
        return System.currentTimeMillis();
    }
}