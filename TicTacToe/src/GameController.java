import javax.swing.*;

/**
 * Asks the user to select game mode
 * and starts the game.
 *
 * Created by Amar, Argeta, Mrika, Blend
 */
public class GameController
{
    public static void main(String[] args)
    {
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Select game mode:\n\n1: Player vs. Player\n2: Player vs. Bot\n3: Bot vs. Bot", "Select Game Mode", JOptionPane.INFORMATION_MESSAGE);
            int inputInt = 1;

            try {
                inputInt = Integer.parseInt(input);

                if (inputInt < 1 || inputInt > 3) {
                    throw new Exception();
                }
            } catch (Exception e) {
                int tryAgain = JOptionPane.showConfirmDialog(null, "Game mode doesn't exist! Do you want to try again?", "Invalid Game Mode", JOptionPane.YES_NO_OPTION);

                if (tryAgain == JOptionPane.YES_OPTION) {
                    continue;
                } else {
                    Game.exit();
                }
            }

            Game game = new Game(inputInt);
            game.start();
        }
    }
}