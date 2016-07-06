import javax.swing.*;
import java.awt.*;

/**
 * Paints the game borders, player moves
 * and statistics to the frame.
 *
 * Created by Amar, Argeta, Mrika, Blend
 */
public class GameWriter extends JPanel
{
    Graphics2D g;
    int squares[] = new int[9],
        stats[] = new int[3];

    /**
     * Sets up the frame.
     */
    public GameWriter()
    {
        JFrame frame = new JFrame("TicTacToe");
        frame.setSize(400, 520);
        frame.getContentPane().add(this);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Resets the player moves.
     */
    public void reset()
    {
        for (int i = 0; i < this.squares.length; i++) {
            this.squares[i] = 0;
        }

        this.repaint();
    }

    /**
     * Paints all the elements.
     *
     * @param g2
     */
    public void paintComponent(Graphics g2)
    {
        this.g = (Graphics2D) g2;
        this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Horizontal lines
        this.g.fillRect(140, 50, 10, 320);
        this.g.fillRect(250, 50, 10, 320);

        // Vertical lines
        this.g.fillRect(40, 150, 320, 10);
        this.g.fillRect(40, 260, 320, 10);

        // Player moves
        for (int i = 0; i < squares.length; i++) {
            int square = i + 1;

            int offsetX = 40, offsetY = 50;

            int squareX = square, squareY = square;

            if (square == 4 || square == 7) {
                squareX = 1;
            } else if (square == 5 || square == 8) {
                squareX = 2;
            } else if (square == 6 || square == 9) {
                squareX = 3;
            }

            if (square == 2 || square == 3) {
                squareY = 1;
            } else if (square == 4 || square == 5 || square == 6) {
                squareY = 2;
            } else if (square == 7 || square == 8 || square == 9) {
                squareY = 3;
            }

            int moveX = (squareX - 1) * 110;
            int moveY = (squareY - 1) * 110;

            if (squares[i] == 1) {
                this.g.setColor(Color.blue);
                this.g.drawLine(offsetX + 20 + moveX, offsetY + 20 + moveY, offsetX + 80 + moveX, offsetY + 80 + moveY);
                this.g.drawLine(offsetX + 80 + moveX, offsetY + 20 + moveY, offsetX + 20 + moveX, offsetY + 80 + moveY);
            } else if (squares[i] == 2) {
                this.g.setColor(Color.red);
                this.g.drawOval(offsetX + 20 + moveX, offsetY + 20 + moveY, 60, 60);
            }
        }

        // Statistics
        this.g.setColor(Color.black);
        this.g.drawString("Games played: " + (this.stats[0] - 1), 145, 420);

        this.g.setColor(Color.blue);
        this.g.drawString("Player 1 wins: " + (this.stats[1]), 145, 440);

        this.g.setColor(Color.red);
        this.g.drawString("Player 2 wins: " + (this.stats[2]), 145, 460);
    }
}