package vp.chess.core;

public enum MoveConfigEnum {
    STRAIGHT, // Like Rook and Queen
    CROSS, // Like Bishop and Queen
    NEIGHNOURS, // Like King
    L_SHAPE, JUMP, // Like Knight
    ONE_STEP_AHEAD, ONE_STEP_CROSS // Like Pawn
}
