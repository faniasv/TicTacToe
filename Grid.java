import java.util.Arrays;

public class Grid {
    private int totalTurns = 0;
    private char[][] mainGrid = new char[3][3];

    // Constructor
    public Grid() {
        intializeGrid();
    }

    // intialize the grid
    private void intializeGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mainGrid[i][j] = ' ';

            }
        }
    }

    // displays the grid with cell numbers
    public void previewGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mainGrid[i][j] = (char) ((i * 3) + (j + 1) + '0');

            }
        }
        this.displayMainGrid();
        this.intializeGrid();
    }

    // sets the main grid and increments total turns
    public boolean markPosition(int pos, char symbol) {
        if (pos < 1 || pos > 9) {
            System.out.println("Enter position between 1 and 9");
            return false;
        }
        pos--;
        int i = pos / 3, j = pos % 3;
        if (this.mainGrid[i][j] != ' ') {
            System.out.println("Position is alredy filled");
            return false;
        }
        this.mainGrid[i][j] = symbol;
        totalTurns++;
        return true;
    }

    // row : checks how many cells are equal to a symbol
    public int checkRow(int row, char symbol, int countNumber) {
        int count = 0, pos = -1;
        for (int i = 0; i < 3; i++) {
            if (mainGrid[row][i] == (symbol))
                count++;
            else if (mainGrid[row][i] == ' ')
                pos = i;
        }
        if (pos != -1 && count == countNumber) {
            count = 10 + (row * 3) + pos;
        }
        return count;

    }

    // colomun : checks how many cells are equal to a symbol
    public int checkColumn(int coloumn, char symbol, int countNumber) {
        int count = 0, pos = -1;
        for (int i = 0; i < 3; i++) {
            if (mainGrid[i][coloumn] == (symbol))
                count++;
            else if (mainGrid[i][coloumn] == ' ')
                pos = i;
        }
        if (pos != -1 && count == countNumber) {
            count = 10 + coloumn + (pos * 3);
        }
        return count;

    }

    // diagonal : checks how many cells are equal to a symbol
    public int checkDiagonal(int start, char symbol, int countNumber) {
        int count = 0, pos = -1;
        if (start == 0) {
            for (int i = 0; i < 3; i++) {
                if (mainGrid[i][i] == (symbol))
                    count++;
                else if (mainGrid[i][i] == ' ')
                    pos = i;
            }
            if (pos != -1 && count == countNumber) {
                count = 10 + pos;
            }

        } else if (start == 1) {
            for (int i = 0; i < 3; i++) {
                if (mainGrid[2 - i][i] == (symbol))
                    count++;
                else if (mainGrid[2 - i][i] == ' ')
                    pos = 2 - i;
            }
            if (pos != -1 && count == countNumber) {
                count = 20 + pos;
            }

        }
        return count;

    }

    // returns win,tie, or ongoing game
    public int isWin(char symbol) {
        // checking row
        for (int i = 0; i < 3; i++) {
            if (this.checkRow(i, symbol, 2) == 3)
                return 1;

        }
        // checking column
        for (int j = 0; j < 3; j++) {
            if (this.checkColumn(j, symbol, 2) == 3)
                return 1;

        }
        // checking diagonal
        if (this.checkDiagonal(0, symbol, 2) == 3)
            return 1;
        if (this.checkDiagonal(1, symbol, 2) == 3)
            return 1;

        // returning for a tie
        if (totalTurns == 9)
            return 2;
        // game not over yet
        return 0;
    }

    // displays the grid
    public void displayMainGrid() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j < 2)
                    System.out.printf(" %c |", mainGrid[i][j]);
                else
                    System.out.printf(" %c\n", mainGrid[i][j]);

            }
            if (i < 2)
                System.out.println("---|---|---");
        }
    }

    public String toString() {
        return "Grid [mainGrid=" + Arrays.toString(mainGrid) + ", totalTurns=" + totalTurns + "]";
    }
}
