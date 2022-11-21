import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;

    // constructer
    public Player(char symbol) {
        setSymbol(symbol);
    }

    // getter
    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    // setter
    private void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ask next move
    public int nextMove(Scanner nameScanner) {
        System.out.print(this.getName() + ": ");
        int pos = nameScanner.nextInt();
        return pos;
    }

    // declareWon
    public void declareWon() {
        System.out.println(this.getName() + " won the game");
    }
}
