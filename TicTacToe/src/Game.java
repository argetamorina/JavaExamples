import javax.swing.*;

/**
 * Handles the game logic, including
 * player moves, deciding the winner etc.
 *
 * Created by Amar, Argeta, Mrika, Blend
 */
public class Game
{
    GameWriter writer = new GameWriter();
    int gameMode;

    public Game(int gameMode)
    {
        this.gameMode = gameMode;
    }

    /**
     * Exits the game.
     */
    public static void exit()
    {
        JOptionPane.showMessageDialog(null, "Thanks for playing.");

        System.exit(0);
    }

    /**
     * Delays the game for a certain
     * amount of time.
     *
     * @param time Time in milliseconds
     */
    public static void delay(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts the game depending on the
     * game mode.
     */
    public void start()
    {
        writer.stats[0]++;

        switch (this.gameMode) {
            case 1:
                this.playerVsPlayer();
                break;
            case 2:
                this.playerVsBot();
                break;
            case 3:
                this.botVsBot();
                break;
        }

        int tryAgain = JOptionPane.showConfirmDialog(null, "This is a draw. Try again?", "Game Draw", JOptionPane.YES_NO_OPTION);

        if (tryAgain == JOptionPane.YES_OPTION) {
            writer.reset();

            this.start();
        } else {
            exit();
        }
    }

    /**
     * Checks for winner based on last move.
     *
     * @param type The last move from a player
     */
    public void check(int type)
    {
        boolean hasWinner;
        int[] s = writer.squares;

        hasWinner =
                (s[0] != 0 && s[0] == s[1] && s[1] == s[2]) || // first row
                (s[3] != 0 && s[3] == s[4] && s[4] == s[5]) || // second row
                (s[6] != 0 && s[6] == s[7] && s[7] == s[8]) || // third row

                (s[0] != 0 && s[0] == s[3] && s[3] == s[6]) || // first column
                (s[1] != 0 && s[1] == s[4] && s[4] == s[7]) || // second column
                (s[2] != 0 && s[2] == s[5] && s[5] == s[8]) || // third column

                (s[0] != 0 && s[0] == s[4] && s[4] == s[8]) || // diagonal
                (s[2] != 0 && s[2] == s[4] && s[4] == s[6]); // second diagonal

        if (hasWinner) {
            writer.stats[type]++;

            int tryAgain = JOptionPane.showConfirmDialog(null, "Player " + type + " is the winner! Do you want to play again?", "Game Won", JOptionPane.YES_NO_OPTION);

            if (tryAgain == JOptionPane.YES_OPTION) {
                writer.reset();

                this.start();
            } else {
                exit();
            }
        }
    }

    /**
     * Asks player for a move.
     *
     * @param type The player which has the turn
     * @return int Validated move from user
     */
    public int playerInput(int type)
    {
        int square;
        while (true) {
            String squareInput = JOptionPane.showInputDialog(null, "Player " + type + ": Enter square you want to play (1 - 9):", "Play Turn", JOptionPane.INFORMATION_MESSAGE);

            try {
                square = Integer.parseInt(squareInput);

                if (square < 1 || square > 9 || writer.squares[square - 1] != 0)
                    throw new Exception();

                return square;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "This square is invalid or already written!", "Invalid Square", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Generates random move for bot.
     *
     * @return int Random move
     */
    public int botInput()
    {
        int rand;
        do {
            rand = (int) (Math.random() * 9);
        } while (writer.squares[rand] != 0);

        return rand;
    }

    /**
     * Starts the 'player vs. player' game
     * mode. This game mode asks for input
     * on every turn.
     */
    public void playerVsPlayer()
    {
        int type = 1;
        for (int i = 0; i < 9; i++) {
            writer.squares[playerInput(type) - 1] = type;
            writer.repaint();
            this.check(type);

            type = type == 1 ? 2 : 1;
        }
    }

    /**
     * Starts the 'player vs. bot' game
     * mode. This game mode asks the first
     * player for input, and generates a
     * random one for the second.
     */
    public void playerVsBot()
    {
        int type = 1;
        for (int i = 0; i < 9; i++) {
            int playerInput = type == 1 ? playerInput(type) - 1 : botInput();
            writer.squares[playerInput] = type;
            writer.repaint();
            this.check(type);

            delay(1000);

            type = type == 1 ? 2 : 1;
        }
    }

    /**
     * Starts the 'bot vs. bot' game
     * mode. This game mode generates
     * random moves for both players.
     */
    public void botVsBot()
    {
        int type = 1;

        delay(1000);

        for (int i = 0; i < 9; i++) {
            writer.squares[botInput()] = type;
            writer.repaint();
            this.check(type);

            delay(1500);

            type = type == 1 ? 2 : 1;
        }
    }
}
