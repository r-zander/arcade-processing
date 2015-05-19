package de.xielong.arcade;

import de.xielong.arcade.worlds.DeathScreen;
import de.xielong.arcade.worlds.GameScreen;
import de.xielong.arcade.worlds.StartScreen;

public class Screens {

    public final StartScreen START;

    public final GameScreen  GAME;

    public final DeathScreen DEATH;

    public Screens() {
        START = new StartScreen();
        GAME = new GameScreen();
        DEATH = new DeathScreen();
    }

}
