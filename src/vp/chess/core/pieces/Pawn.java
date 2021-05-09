package vp.chess.core.pieces;

import java.util.ArrayList;
import static java.util.Arrays.asList;

import vp.chess.core.Piece;
import vp.chess.core.PlayerEnum;
import vp.chess.core.PositionEnum;
import vp.chess.core.MoveConfigEnum;

public class Pawn extends Piece {

    public Pawn(PositionEnum pos, PlayerEnum player) {
        super(pos, player);
    }

    @Override
    public PiecesEnum getPiecesEnumValue() {
        return PiecesEnum.Pawn;
    }

    @Override
    public ArrayList<MoveConfigEnum> getMoveConfig() {
        return new ArrayList<MoveConfigEnum>(asList( // List Start
                MoveConfigEnum.ONE_STEP_AHEAD_MOVE, // Move: One Step Forward
                MoveConfigEnum.ONE_STEP_CROSS_KILL, // Kill: One Step Cross
                MoveConfigEnum.TWO_STEP_AHAED_FIRST_MOVE// FirstMove: Two Step allowed also
        )); // List End
    }

}