package janggi.domain.piece.single;

import janggi.domain.piece.PalacePiece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Score;
import janggi.domain.piece.path.generator.PathStrategy;
import janggi.domain.piece.path.generator.SinglePathStrategy;
import janggi.domain.side.Side;

public abstract class SinglePiece extends PalacePiece {
    private static final PathStrategy SINGLE_PATH = new SinglePathStrategy();

    protected SinglePiece(PieceType name, Side side, Score score) {
        super(name, side, SINGLE_PATH, score);
    }

}
