package vp.chess.common.utils;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.awt.Image;
import javax.imageio.ImageIO;

import vp.chess.core.Piece.PiecesEnum;
import vp.chess.core.PlayerEnum;

public class PieceImageLoader {
    public static final String urlFormat = "https://commons.m.wikimedia.org/wiki/Special:Redirect/file/Chess_%c%ct60.png";

    public static final Map<PiecesEnum, Character> pieceToCode;
    public static final Map<PlayerEnum, Character> playerToCode;

    static {
        pieceToCode = new HashMap<PiecesEnum, Character>();
        pieceToCode.put(PiecesEnum.King, 'k');
        pieceToCode.put(PiecesEnum.Queen, 'q');
        pieceToCode.put(PiecesEnum.Rook, 'r');
        pieceToCode.put(PiecesEnum.Bishop, 'b');
        pieceToCode.put(PiecesEnum.Knight, 'n');
        pieceToCode.put(PiecesEnum.Pawn, 'p');

        playerToCode = new HashMap<PlayerEnum, Character>();
        playerToCode.put(PlayerEnum.WHITE, 'l');
        playerToCode.put(PlayerEnum.BLACK, 'd');
    }

    public static URL getUrl(PiecesEnum piece, PlayerEnum player) {
        URL url = null;
        try {
            url = new URL(String.format(urlFormat, pieceToCode.get(piece), playerToCode.get(player)));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return url;
    }

    public static Image getImg(PiecesEnum piece, PlayerEnum player) {
        Image img = null;
        try {
            // ImageIO.read(PieceImageLoader.class.getResourceAsStream("Path/FileName"));
            img = ImageIO.read(getUrl(piece, player));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return img;
    }
}
