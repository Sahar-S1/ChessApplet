package vp.chess.core;

public enum MoveConfigEnum {
    STRAIGHT, // Like Rook and Queen
    CROSS, // Like Bishop and Queen
    NEIGHNOURS, // Like King
    L_SHAPE, JUMP, // Like Knight
    ONE_STEP_AHEAD_MOVE, ONE_STEP_AHEAD_NO_KILL, ONE_STEP_CROSS_KILL, TWO_STEP_AHAED_FIRST_MOVE // Like Pawn
}
