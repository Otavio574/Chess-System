package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: you need at least 1 row and 1 column");
        }

        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }


    public int getColumns() {
        return columns;
    }


    public void placePiece(Piece piece, Position position) {
        if (IsThereAPiece(position)) {
            throw new BoardException("There is already a piece on this position " );
        }

        pieces [position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece (Position position) {
        if (!PositionExists(position)) {
            throw new BoardException("Position not on the board");
        }

        if (piece(position) == null) {
            return null;
        }

        Piece aux = piece (position);
        aux.position = null;
        pieces [position.getRow()][position.getColumn()] = null;
        return aux;
    }

    public Piece piece (int row, int column) {
        if (!PositionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }

        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!PositionExists(position)) {
            throw new BoardException("Position not on the board");
        }

        return pieces[position.getRow()][position.getColumn()];
    }

    public boolean PositionExists (int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    public  boolean PositionExists(Position position) {
        return PositionExists(position.getRow(), position.getColumn());
    }

    public boolean IsThereAPiece (Position position) {
        if (!PositionExists(position)) {
            throw new BoardException("Position not on the board.");
        }

        return piece(position) != null;
    }
}
