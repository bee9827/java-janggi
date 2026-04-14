package janggi.domain.piece.linear;

import janggi.domain.piece.PalacePiece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Score;
import janggi.domain.piece.path.generator.LinearPathStrategy;
import janggi.domain.piece.path.generator.PathStrategy;
import janggi.domain.side.Side;

public abstract class LinearPiece extends PalacePiece {
    private static final PathStrategy LINEAR_STRATEGY = new LinearPathStrategy();

    protected LinearPiece(PieceType name, Side side, Score score) {
        super(name, side, LINEAR_STRATEGY, score);
    }
}
