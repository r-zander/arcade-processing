package de.xielong.arcade.worlds;

import static de.xielong.arcade.Arcade.$;
import hermes.World;
import de.xielong.arcade.ArcadeConstants;

public class StartScreen extends World {

    @Override
    public void draw() {
        $.background(0);

        $.noFill();
        $.stroke(ArcadeConstants.Colors.BLUE);
        $.strokeWeight(3);

        $.rect(
                $.percentageWidth(100 / 9f),
                $.percentageHeight(20),
                $.percentageWidth(100 / 3f),
                $.percentageHeight(20),
                0,
                20,
                20,
                20);

        $.rect(
                $.percentageWidth(100 / 9f),
                $.percentageHeight(20 * 3),
                $.percentageWidth(100 / 3f),
                $.percentageHeight(20),
                0,
                20,
                20,
                20);

    }

}
