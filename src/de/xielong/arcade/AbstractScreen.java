package de.xielong.arcade;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Getter
@Accessors(fluent = true)
public abstract class AbstractScreen {

    private final Arcade app;

    public void setup() {};

    public abstract void draw();

}
