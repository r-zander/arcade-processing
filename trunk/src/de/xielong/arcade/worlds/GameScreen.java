package de.xielong.arcade.worlds;

import static de.xielong.arcade.MainActivity.$;
import hermes.World;
import de.xielong.arcade.GroundBlock;
import de.xielong.arcade.enums.Corner;

public class GameScreen extends World {

    @Override
    public void setup() {
        $.figures().reset();
        $.unit().resetPosition();
        $.blocks().clear();
        $.blocks().add(
                new GroundBlock($, $.figures().speed()).width($.width - 100).height(50)
                        .positionInside(Corner.BOTTOM_LEFT));
    }

    @Override
    public void draw() {
        $.drawGame();
    }

}
