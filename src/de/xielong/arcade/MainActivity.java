package de.xielong.arcade;

import static de.xielong.arcade.ArcadeConstants.ASPECT_RATIO;
import hermes.World;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.PackagePrivate;
import processing.core.PApplet;
import de.xielong.arcade.enums.Direction;

@Getter
@Accessors(fluent = true)
public class MainActivity extends PApplet {

    /**
     * Currently running instance
     */
    public static MainActivity $;

    private Figures            figures;

    private Direction          screenOrientation;

    private final List<Block>  blocks = new LinkedList<Block>();

    private Unit               unit;

    private Screens            screens;

    private World              currentWorld;

    @Override
    public void setup() {
        $ = this;

        size(displayWidth, round(displayWidth / ASPECT_RATIO));

        screenOrientation = Direction.BOTTOM;

        unit = new Unit();
        figures = new Figures(this);

        screens = new Screens();

        setCurrentWorld(screens.START);

        ellipseMode(CORNER);
    }

    private void setCurrentWorld(World newScreen) {
        if (currentWorld != newScreen) {
            if (currentWorld != null) {
                currentWorld.deactivate();
            }
            currentWorld = newScreen;
            currentWorld.start();
        }
    }

    @Override
    public void draw() {
        currentWorld.draw();
    }

    @PackagePrivate
    public void drawGame() {
        background(ArcadeConstants.Colors.BACKGROUND);

        for (Iterator<Block> iterator = blocks.iterator(); iterator.hasNext();) {
            Block block = iterator.next();

            switch (block.move(figures.speed(), Direction.LEFT)) {
                case OUTSIDE:
                    // If it's a ground block, only remove it when its successor already spawned
                    if (block instanceof GroundBlock) {
                        if (((GroundBlock) block).hasNextSpawned() == false) {
                            break;
                        }
                    }
                    iterator.remove();
                    break;
                default:
                    break;
            }

            if (block instanceof GroundBlock) {
                GroundBlock groundBlock = (GroundBlock) block;
                if (groundBlock.hasNextSpawned() == false) {
                    float gap = width - block.right();
                    if (gap >= groundBlock.gapSize()) {
                        blocks.add(new GroundBlock(this, figures.speed()));
                        groundBlock.hasNextSpawned(true);
                        break;
                    }
                }
            }
        }

        if (mousePressed) {
            unit.jump();
        }

        if (keyPressed) {
            switch (key) {
                case ' ':
                    unit.jump();
                    break;
            }
        }

        switch (unit.update(getGravityDirection(), blocks)) {
            case DEAD:
                setCurrentWorld(screens.DEATH);
                break;
            default:
                break;
        }

        figures.draw();
        figures.tick();
    }

    @Override
    public void keyPressed() {
        switch (key) {
            case ' ':
                if (currentWorld == screens.DEATH || currentWorld == screens.START) {
                    setCurrentWorld(screens.GAME);
                }
                break;
            case ESC:
                if (currentWorld != screens.DEATH) {
                    setCurrentWorld(screens.DEATH);
                    // Don't pass ESC through
                    key = 0;
                }
                break;
            case CODED:
                switch (keyCode) {
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void mousePressed() {
        if (currentWorld == screens.DEATH || currentWorld == screens.START) {
            setCurrentWorld(screens.GAME);
        }
    }

    private Direction getGravityDirection() {
        return screenOrientation;
    }

    public float percentageWidth(float percentage) {
        return percentage / 100 * width;
    }

    public float percentageHeight(float percentage) {
        return percentage / 100 * height;
    }

    public static void main(String args[]) {
//        PApplet.main(new String[] { "--present", Arcarde.class.getName() });
//        PApplet.main(new String[] { "--location=-1920,700", Arcarde.class.getName() });
//        PApplet.main(new String[] { "--location=1920,0", Arcarde.class.getName() });
        PApplet.main(new String[] { MainActivity.class.getName() });
    }
}