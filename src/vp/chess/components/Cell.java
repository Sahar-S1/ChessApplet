package vp.chess.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Component;
import java.applet.AppletContext;

import static vp.chess.common.Config.*;
import vp.chess.core.Piece;
import vp.chess.core.PositionEnum;

public class Cell extends Component {
    public enum StyleEnum {
        Light, Dark;

        public Color getColor() {
            return this.name() == StyleEnum.Light.name() ? LIGHT_CELL_COLOR : DARK_CELL_COLOR;
        }
    }

    private final AppletContext ctx;
    private final PositionEnum pos;
    private final StyleEnum style;
    private Piece piece = null;
    private Color highlightColor = null;

    public Cell(AppletContext ctx, PositionEnum pos, StyleEnum style, Piece piece, Color highlightColor) {
        this.ctx = ctx;
        this.pos = pos;
        this.piece = piece;
        this.style = style;
        this.highlightColor = highlightColor;
    }

    public Cell(AppletContext ctx, PositionEnum pos, StyleEnum style, Piece piece) {
        this(ctx, pos, style, piece, null);
    }

    public Cell(AppletContext ctx, PositionEnum pos, StyleEnum style, Color highlightColor) {
        this(ctx, pos, style, null, highlightColor);
    }

    public Cell(AppletContext ctx, PositionEnum pos, StyleEnum style) {
        this(ctx, pos, style, null, null);
    }

    public AppletContext getContext() {
        return ctx;
    }

    public PositionEnum getPos() {
        return this.pos;
    }

    public StyleEnum getStyle() {
        return style;
    }

    public Color getHighlightColor() {
        return highlightColor;
    }

    public Cell setHighlightColor(Color highlightColor) {
        this.highlightColor = highlightColor;
        return this;
    }

    public AppletContext getCtx() {
        return this.ctx;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public Cell setPiece(Piece piece) {
        this.piece = piece;
        return this;
    }

    @Override
    public void paint(Graphics g) {
        int size = CELL_SIZE;
        g.setColor(this.style.getColor());
        g.fillRect(0, 0, size, size);
        if (this.highlightColor != null) {
            g.setColor(this.highlightColor);
            g.fillRect(0, 0, size, size);
        }
        if (this.piece != null) {
            g.drawImage(this.piece.getImage(), IMAGE_OFFSET, IMAGE_OFFSET, this);
        }
    }
}
