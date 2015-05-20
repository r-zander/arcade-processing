package de.xielong.arcade;

import static de.xielong.arcade.ArcadeConstants.START_SPEED;
import static processing.core.PApplet.floor;
import static processing.core.PApplet.round;
import static processing.core.PConstants.BOTTOM;
import static processing.core.PConstants.CENTER;
import static processing.core.PConstants.LEFT;
import static processing.core.PConstants.RIGHT;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import processing.core.PApplet;
import de.xielong.arcade.ArcadeConstants.Colors;

@Data
@RequiredArgsConstructor(suppressConstructorProperties = true)
@Accessors(fluent = true)
public class Figures {

    private final PApplet app;

    private float         distanceTraveled;

    private float         speed = START_SPEED;

    public void tick() {
        distanceTraveled += speed;
        speed += 0.01;
    }

    public int getFormattedSpeedMajor() {
        return floor(speed / START_SPEED);
    }

    public int getFormattedSpeedMinor() {
        return round((speed / 5) % 1 * 10);
    }

    public int getFormattedDistanceTraveled() {
        return floor(distanceTraveled);
    }

    public void draw() {
        app.fill(Colors.FONT);
        app.textSize(12);
        app.textAlign(CENTER, BOTTOM);
        app.text(app.frameRate, 50, 50);

        app.textAlign(RIGHT, BOTTOM);
        app.text(getFormattedSpeedMajor(), app.width - 200, 50);
        app.textAlign(LEFT, BOTTOM);
        app.textSize(8);
        app.text(getFormattedSpeedMinor(), app.width - 200, 50);

        app.textSize(12);
        app.textAlign(RIGHT, BOTTOM);
        app.text(getFormattedDistanceTraveled(), app.width - 50, 50);
    }

    public void reset() {
        distanceTraveled = 0;
        speed = floor(speed / START_SPEED) * START_SPEED;
    }

}
