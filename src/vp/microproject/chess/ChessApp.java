package vp.microproject.chess;

import java.applet.Applet;
import java.awt.Graphics;

/*
<applet code="vp.microproject.chess.ChessApp" width=800 height=800></applet>
*/
public class ChessApp extends Applet {
    @Override
    public void paint(Graphics g) {
        g.drawString("Hello World", 400, 400);
    }
}
