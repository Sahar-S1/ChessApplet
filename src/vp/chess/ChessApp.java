package vp.chess;

import java.applet.Applet;

import vp.chess.components.Board;

/*
<applet code="vp.chess.ChessApp" width=800 height=800></applet>
*/
public class ChessApp extends Applet {
    @Override
    public void init() {
        Board board = new Board(this.getAppletContext());
        this.add(board);
    }
}
