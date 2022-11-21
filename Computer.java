import java.util.Scanner;

public class Computer extends Player {

    public Computer(char symbol) {
        super(symbol);
        this.setName("Computer");
    }

    public int nextMove(Scanner nameScanner, Grid gameGrid, char opponentSymbol) {

        int posChoosen = moveToWin(gameGrid, this.getSymbol(), 2);
        // moivng when self is about to win
        if (posChoosen != -1)
            return posChoosen;

        posChoosen = moveToWin(gameGrid, opponentSymbol, 2);
        // moivng when opponent is about to win
        if (posChoosen != -1)
            return posChoosen;

        posChoosen = moveToWin(gameGrid, this.getSymbol(), 1);
        if (posChoosen != -1)
            return posChoosen;

        posChoosen = moveToWin(gameGrid, opponentSymbol, 1);
        if (posChoosen != -1)
            return posChoosen;

        gameGrid.markPosition(5, this.getSymbol());
        return 5;

    }

    private int moveToWin(Grid gameGrid, char opponentSymbol, int scoreCount) {
        // cheking for moves in a row
        for (int row = 0; row < 3; row++) {
            int pos = gameGrid.checkRow(row, opponentSymbol, scoreCount);
            if (pos >= 10) {
                gameGrid.markPosition(pos + 1 - 10, this.getSymbol());
                return (pos + 1 - 10);
            }
        }
        // cheking for moves in a column
        for (int column = 0; column < 3; column++) {
            int pos = gameGrid.checkColumn(column, opponentSymbol, scoreCount);
            if (pos >= 10) {
                gameGrid.markPosition(pos + 1 - 10, this.getSymbol());
                return (pos + 1 - 10);
            }
        }
        // cheking for moves in a diagnonal
        int pos = gameGrid.checkDiagonal(0, opponentSymbol, scoreCount);
        if (pos >= 10) {
            pos = pos - 10;
            if (pos == 0) {
                gameGrid.markPosition(1, this.getSymbol());
                return 1;
            }
            if (pos == 1) {
                gameGrid.markPosition(5, this.getSymbol());
                return 5;
            }
            if (pos == 2) {
                gameGrid.markPosition(9, this.getSymbol());
                return 9;
            }
        }
        pos = gameGrid.checkDiagonal(1, opponentSymbol, scoreCount);
        if (pos >= 20) {
            pos = pos - 20;
            if (pos == 0) {
                gameGrid.markPosition(3, this.getSymbol());
                return 3;
            }
            if (pos == 1) {
                gameGrid.markPosition(5, this.getSymbol());
                return 5;
            }
            if (pos == 2) {
                gameGrid.markPosition(7, this.getSymbol());
                return 7;
            }
        }
        return -1;
    }

}
