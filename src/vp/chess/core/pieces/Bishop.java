package vp.chess.core.pieces;

import java.util.ArrayList;

import vp.chess.core.Piece;
import vp.chess.core.PlayerEnum;
import vp.chess.core.PositionEnum;
import vp.chess.core.Move;
import vp.chess.core.GameState;

public class Bishop extends Piece {

    public Bishop(PositionEnum pos, PlayerEnum player) {
        super(pos, player);
    }

    @Override
    public PiecesEnum getPiecesEnumValue() {
        return PiecesEnum.Bishop;
    }

    @Override
    public ArrayList<Move> getLegalMoves(GameState state) {
        // TODO Auto-generated method stub
        return null;
    }

}