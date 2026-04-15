package janggi.domain.piece;

import janggi.domain.board.BoardInfo;
import janggi.domain.coordination.BoardCoordination;
import janggi.domain.coordination.PalaceCoordination;
import janggi.domain.coordination.PalaceMovements;
import janggi.domain.piece.path.CandidatePath;
import janggi.domain.piece.path.Direction;
import janggi.domain.piece.path.Movement;
import janggi.domain.piece.path.generator.PathStrategy;
import janggi.domain.point.Point;
import janggi.domain.side.Side;
import java.util.ArrayList;
import java.util.List;

public abstract class PalaceApplicablePiece extends Piece {
    private static final List<Movement> MOVEMENTS = createMovements();

    protected PalaceApplicablePiece(PieceType name, Side side,
                                    PathStrategy pathStrategy, Score score) {
        super(name, side, pathStrategy, score);
    }

    private static List<Movement> createMovements() {
        return List.of(
                new Movement(Direction.NORTH),
                new Movement(Direction.SOUTH),
                new Movement(Direction.WEST),
                new Movement(Direction.EAST));
    }

    @Override
    protected final List<CandidatePath> createCandidatePaths(Point from) {
        List<CandidatePath> candidatePaths = new ArrayList<>(
                createCandidatePaths(getMovements(), from, BoardCoordination::isInRange));

        if (PalaceCoordination.isInRange(from)) {
            candidatePaths.addAll(
                    createCandidatePaths(PalaceMovements.getMovements(from), from, PalaceCoordination::isInRange));
        }

        return candidatePaths;
    }

    @Override
    protected boolean isValidPath(CandidatePath candidatePath, BoardInfo boardInfo) {
        return !candidatePath.isEmpty();
    }

    @Override
    protected List<Movement> getMovements() {
        return MOVEMENTS;
    }

}
