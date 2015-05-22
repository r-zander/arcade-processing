package de.xielong.arcade.enums;

public enum Direction {
    TOP {

        @Override
        public Direction invert() {
            return BOTTOM;
        }
    },
    BOTTOM {

        @Override
        public Direction invert() {
            return TOP;
        }
    },
    LEFT {

        @Override
        public Direction invert() {
            return LEFT;
        }
    },
    RIGHT {

        @Override
        public Direction invert() {
            return RIGHT;
        }
    };

    public abstract Direction invert();
}
