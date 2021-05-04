package vp.chess.core;

import java.awt.Color;

public enum PlayerEnum {
    WHITE, BLACK;

    public Color getColor() {
        return this.name() == PlayerEnum.WHITE.name() ? Color.WHITE : Color.BLACK;
    }
}
