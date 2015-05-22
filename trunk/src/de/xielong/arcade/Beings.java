package de.xielong.arcade;

import hermes.Being;

/**
 * Utility class for {@link Being}s
 * 
 * @author rza
 */
public class Beings {

    private Beings() {}

    public static <B extends Being> B setBottom(B being, float bottom) {
        being.setY(bottom - being.getBoundingBox().getHeight());
        return being;
    }

    public static <B extends Being> B setRight(B being, float right) {
        being.setX(right - being.getBoundingBox().getWidth());
        return being;
    }

    public static float getBottom(Being being) {
        return being.getY() + being.getBoundingBox().getHeight();
    }

    public static float getRight(Being being) {
        return being.getX() + being.getBoundingBox().getWidth();
    }

}
