import java.util.Scanner;

public class TicTacToe {
    public static void playComputer(Player p1, Computer p2, Grid mainGame, Scanner inputScanner) {
        while (mainGame.isWin(p2.getSymbol()) == 0) {

            // taking player 1 input
            while (!mainGame.markPosition(p1.nextMove(inputScanner), p1.getSymbol()));
            mainGame.displayMainGrid();

            // check player 1 won
            if (mainGame.isWin(p1.getSymbol()) == 1) {
                p1.declareWon();
                break;
            }

            // computers turn
            if (mainGame.isWin(p2.getSymbol()) == 0) {
                int posChoosen = p2.nextMove(inputScanner, mainGame, p1.getSymbol());
                System.out.println("Computer choosed : " + posChoosen);
                mainGame.displayMainGrid();
            }

            // check player 2 won
            if (mainGame.isWin(p2.getSymbol()) == 1) {
                p2.declareWon();
                break;
            }
        }
    }

    public static void playHuman(Player p1, Player p2, Grid mainGame, Scanner inputScanner) {
        while (mainGame.isWin(p2.getSymbol()) == 0) {

            // taking player 1 input

            while (!mainGame.markPosition(p1.nextMove(inputScanner), p1.getSymbol()));
            mainGame.displayMainGrid();

            // check player 1 won
            if (mainGame.isWin(p1.getSymbol()) == 1) {
                p1.declareWon();
                break;
            }

            // taking player 2 input
            if (mainGame.isWin(p2.getSymbol()) == 0) {

                while (!mainGame.markPosition(p2.nextMove(inputScanner), p2.getSymbol()));
                mainGame.displayMainGrid();
            }

            // check player 2 won
            if (mainGame.isWin(p2.getSymbol()) == 1) {
                p2.declareWon();
                break;
            }
        }
    }


}
