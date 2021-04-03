import java.util.Scanner;
public class TicTacToeRunner {
    public static void main (String[]args)
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        boolean toClear = true;
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the number of the square you want to play at.");
        Board game = new Board();
        int counter = 0;
        int alternator = 1;
        while(game.checkForWin()==0 && counter<9){
            game.printState();
            if(alternator==1)   System.out.print("Player 1: ");
            else   System.out.print("Player 2: ");
            int move = kb.nextInt();
            if(alternator==1){
                game.recordMove("X", move);
                if(game.error){
                    alternator*=-1;
                    counter--;
                    toClear=false;
                }
                game.error=false;
            }
            else{
                game.recordMove("O", move);
                if(game.error){
                    alternator*=-1;
                    counter--;
                    toClear=false;
                }
                game.error=false;
            }
            alternator*=-1;
            counter++;
            if(toClear){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
            }
            toClear=true;
        }
        game.printState();
        if(game.checkForWin()==0)   System.out.println("It's a draw");
        else System.out.println("Player " + game.checkForWin() + " wins");

        kb.close();
    }
}