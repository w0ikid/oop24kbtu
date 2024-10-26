package lab2.part2;

import java.util.Objects;

public class chess {
    public static void main(String[] args) {
        Piece pawn = new Pawn(new Position(1, 1));
        Piece rook = new Rook(new Position(0, 0));
        Piece knight = new Knight(new Position(1, 0));
        Piece bishop = new Bishop(new Position(2, 0));
        Piece queen = new Queen(new Position(3, 0));
        Piece king = new King(new Position(4, 0));

        System.out.println("Pawn move: " + pawn.isLegalMove(new Position(8, 8)));
        System.out.println("Rook move: " + rook.isLegalMove(new Position(0, 5)));
        System.out.println("Knight move: " + knight.isLegalMove(new Position(2, 2)));
        System.out.println("Bishop move: " + bishop.isLegalMove(new Position(5, 3)));
        System.out.println("Queen move: " + queen.isLegalMove(new Position(3, 5)));
        System.out.println("King move: " + king.isLegalMove(new Position(4, 1)));
    }
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return x == position.x && y == position.y;
    }

    @Override 
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

abstract class Piece {
    protected Position position;

    public Piece(Position position) {
        this.position = position;
    }

    public abstract boolean isLegalMove(Position b);

    public Position getPosition() {
        return position;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }
}

class Pawn extends Piece {
    public Pawn(Position position) {
        super(position);
    }

    @Override
    public boolean isLegalMove(Position b) {
        int direction = position.getY() < 4 ? 1 : -1;

        if ((position.getX() == b.getX()) && (b.getY() - position.getY() == direction)) {
            return true;
        }

        if ((position.getX() == b.getX()) && (b.getY() - position.getY() == 2 * direction) && (position.getY() == 1 || position.getY() == 7)) {
            return true;
        }

        return false;
    }
}

class Rook extends Piece {
    public Rook(Position position) {
        super(position);
    }

    @Override
    public boolean isLegalMove(Position b) {
        return position.getX() == b.getX() || position.getY() == b.getY();
    }
}

class Knight extends Piece {
    public Knight(Position position) {
        super(position);
    }

    @Override
    public boolean isLegalMove(Position b) {
        // 2 1 -> 3 3 
        int dx = Math.abs(position.getX() - b.getX());
        int dy = Math.abs(position.getY() - b.getY());
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}

class Bishop extends Piece {

    // 3 1 -> 7 5
    // Разница иксов равна разнице игриков

    public Bishop(Position position) {
        super(position);
    }

    @Override
    public boolean isLegalMove(Position b) {
        return Math.abs(position.getX() - b.getX()) == Math.abs(position.getY() - b.getY());
    }
}

class Queen extends Piece {
    public Queen(Position position) {
        super(position);
    }

    @Override
    public boolean isLegalMove(Position b) {
        int dx = Math.abs(position.getX() - b.getX());
        int dy = Math.abs(position.getY() - b.getY());
        return dx == dy || position.getX() == b.getX() || position.getY() == b.getY();
    }
}

class King extends Piece {
    public King(Position position) {
        super(position);
    }

    @Override
    public boolean isLegalMove(Position b) {
        int dx = Math.abs(position.getX() - b.getX());
        int dy = Math.abs(position.getY() - b.getY());
        return dx <= 1 && dy <= 1;
    }
}
