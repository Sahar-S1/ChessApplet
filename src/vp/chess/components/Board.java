package vp.chess.components;

import java.awt.Panel;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.applet.AppletContext;

import static vp.chess.common.Config.*;

import vp.chess.common.utils.MoveUtils;
import vp.chess.core.GameEngine;
import vp.chess.core.GameState;
import vp.chess.core.Piece;
import vp.chess.core.PositionEnum;

public class Board extends Panel implements MouseListener, MouseMotionListener {
    private final AppletContext ctx;
    private final Cell[][] cells;
    private Cell selectedCell = null;

    public Board(AppletContext ctx) {
        this.ctx = ctx;

        this.setLayout(new GridLayout(8, 8, 0, 0));
        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

        this.cells = new Cell[8][8];
        for (PositionEnum pos : PositionEnum.values()) {
            int row = pos.getRow();
            int col = pos.getColumn();
            Cell.StyleEnum style = (row % 2 == 0) == (col % 2 == 0) ? Cell.StyleEnum.Light : Cell.StyleEnum.Dark;
            Cell cell = this.cells[row][col] = new Cell(this.ctx, pos, style);
            this.add(cell);
        }

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.setCellsPiecesFromState(GameEngine.getInstance().getCurrentState());
    }

    public AppletContext getContext() {
        return this.ctx;
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Cell clickedCell = (Cell) this.getComponentAt(new Point(e.getX(), e.getY()));

        System.out.println(String.format(CLICK_MESSAGE_FORMAT, clickedCell.getPos(), clickedCell.getPiece()));

        if (this.selectedCell != null) {
            Piece piece = this.selectedCell.getPiece();
            this.selectedCell.setPiece(null);
            this.selectedCell.setHighlightColor(null);
            clickedCell.setPiece(piece);

            this.selectedCell.repaint();
            clickedCell.repaint();

            this.selectedCell = null;
        } else if (clickedCell.getPiece() != null) {
            this.selectedCell = clickedCell;
            this.selectedCell.setHighlightColor(SELECTED_COLOR);
            this.selectedCell.repaint();

            for (PositionEnum pos : MoveUtils.getL(selectedCell.getPos().getRow(), selectedCell.getPos().getColumn())) {
                this.cells[pos.getRow()][pos.getColumn()].setHighlightColor(POSSIBLE_MOVE_COLOR);
                this.cells[pos.getRow()][pos.getColumn()].repaint();
            }
        }
    }

    private void setCellsPiecesFromState(GameState state) {
        for (Piece piece : state.getPieces()) {
            PositionEnum pos = piece.getPos();
            this.cells[pos.getRow()][pos.getColumn()].setPiece(piece);
        }
    }

    // Do Nothing in other mouse methods
    @Override
    public void mouseDragged(MouseEvent e) {
        // Do Nothing
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Do Nothing
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Do Nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Do Nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Do Nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Do Nothing
    }

}
