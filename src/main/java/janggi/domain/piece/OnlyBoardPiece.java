package janggi.domain.piece;

import janggi.domain.coordination.BoardCoordination;
import janggi.domain.piece.path.CandidatePath;
import janggi.domain.piece.path.generator.PathStrategy;
import janggi.domain.point.Point;
import janggi.domain.side.Side;
import java.util.List;

public abstract class OnlyBoardPiece extends Piece {
    protected OnlyBoardPiece(PieceType pieceType, Side side,
                             PathStrategy pathStrategy, Score score) {
        super(pieceType, side, pathStrategy, score);
    }

    @Override
    protected final List<CandidatePath> createCandidatePaths(Point from) {
        return super.createCandidatePaths(getMovements(), from, BoardCoordination::isInRange);
    }

}
