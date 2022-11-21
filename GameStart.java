import java.util.Scanner;
public class GameStart {
    public GameStart(){}

    public void Start() {
        // scanner and grid
        Grid mainGame = new Grid();
        Scanner inputScanner = new Scanner(System.in);

        // human or computer
        System.out.println("Welcome to TicTacToe.");
        System.out.println("Player 1 is represented by 'X' and Player 2 by 'O'");
        System.out.println("The cells in the grid are numbered from 1-9 as follows ");
        mainGame.previewGrid();
        System.out.println("Player can enter cell number to fill it.");
        System.out.println("The first one to make 3 cells in row,column or diagonal is a winner, otherwise game ends in a tie.");
        System.out.print("Do you want to play with computer(1) or human(2): ");
        int againtComputer = inputScanner.nextInt();

        Player p1 = new Player('X');
        System.out.print("Enter name of Player 1 : ");

        inputScanner.nextLine();
        p1.setName(inputScanner.nextLine());

        if (againtComputer == 1) {
            Computer p2 = new Computer('O');
            mainGame.displayMainGrid();
            TicTacToe.playComputer(p1, p2, mainGame, inputScanner);
        } else if (againtComputer == 2) {
            Player p2 = new Player('O');
            System.out.print("Enter name Of Player 2 : ");
            p2.setName(inputScanner.nextLine());
            mainGame.displayMainGrid();
            TicTacToe.playHuman(p1, p2, mainGame, inputScanner);
        } else {
        System.out.println("'" + againtComputer + "' is a invalid choice");
        }

        inputScanner.close();
        if (mainGame.isWin(p1.getSymbol()) == 2) {
            System.out.println("This game is a draw");
        }
    }
}
