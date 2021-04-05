package Game;

import java.util.Scanner;
import CardDeck.Player;
import Help.*;
import Exceptions.InvalidColorException;
import Exceptions.InvalidNumberException;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String command;
        boolean start = false, exit = false;

        System.out.println("Welcome to HIJI");
        Game game = null;

        while (!exit)
        {
            System.out.println("List of Commands:");
            System.out.println("- Start");
            System.out.println("- CardList");
            System.out.println("- Discard");
            System.out.println("- Draw");
            System.out.println("- HIJI");
            System.out.println("- PlayerList");
            System.out.println("- PlayerTurn");
            System.out.println("- Help");
            System.out.print("Insert command: ");
            command = input.next();

            if (command.equals("Start"))
            {
                if (!start) {
                    start = true;
                    game = new Game();
                }
                else {
                    System.out.println("You have started the game.");
                }
            }

            else if (command.equals("PlayerList"))
            {
                if (start == false)
                {
                    System.out.println("You have not started the game. Please type 'Start'");

                }
                else
                {
                    game.PlayerList();
                }
            }

            else if (command.equals("CardList"))
            {
                if (start == false)
                {
                    System.out.println("You have not started the game. Please type 'Start'");

                }
                else
                {
                    Player playergiliran = game.players.get(game.giliran);
                    playergiliran.ListCards();
                }
            }

            else if (command.equals("Help"))
            {
                Help.HelpMenu();
            }

            else if (command.equals("PlayerTurn"))
            {
                if (start == false)
                {
                    System.out.println("You have not started the game. Please type 'Start'");

                }
                else
                {
                    game.ViewPlayerTurn();
                }
            }

            else if (command.equals("Draw"))
            {
                if (start == false)
                {
                    System.out.println("You have not started the game. Please type 'Start'");

                }
                else
                {
                    game.PlayerDraw();
                }
            }

            else if (command.equals("Discard"))
            {
                if (start == false)
                {
                    System.out.println("You have not started the game. Please type 'Start'");

                }
                else
                {
                    try{                        
                        game.discard();
                    } catch (InvalidColorException e) {
                        System.out.println(e.getErrorMessage());
                    } catch (InvalidNumberException e) {
                        System.out.println(e.getErrorMessage());
                    }
                }
            }

            else
            {
                System.out.println("Command not found. Please type 'Help'");
            }
        }
        input.close();
    }
}
