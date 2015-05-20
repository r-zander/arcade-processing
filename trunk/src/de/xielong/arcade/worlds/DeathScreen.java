package de.xielong.arcade.worlds;

import static de.xielong.arcade.MainActivity.$;
import hermes.World;
import processing.core.PConstants;
import de.xielong.arcade.ArcadeConstants.FontSize;

public class DeathScreen extends World {

    @Override
    public void draw() {
        $.background(0);
        $.textSize(FontSize.H1);
        $.textAlign(PConstants.CENTER, PConstants.BOTTOM);
        $.fill(255);
        $.text("Dead", $.width / 2, $.height / 2);

        $.textSize(FontSize.H2);
        $.textAlign(PConstants.CENTER, PConstants.TOP);
        $.text(
                $.figures().getFormattedSpeedMajor() + " x " + $.figures().getFormattedDistanceTraveled(),
                $.width / 2,
                $.height / 2);
    }

}
