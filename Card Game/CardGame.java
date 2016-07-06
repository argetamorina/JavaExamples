import javax.swing.*;

/**
 * Created by argeta on 5/8/2016.
 */
public class CardGame {

    public static void main(String[] args) {
        int input = Integer.parseInt(JOptionPane.showInputDialog("Enter your number of the player : "));
        int[][] players = new int[input][5];
        int[] cards = new int[52];

        if (input * 5 > cards.length) {
            JOptionPane.showMessageDialog(null, "Too many players!");

            System.exit(0);
        }

        for (int i = 0; i < cards.length / 4; i++) {
            int index = i * 4;
            int j_limit = index + 4;

            for (int j = index; j < j_limit; j++) {
                cards[j] = i + 1;
            }
        }

        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < 5; j++) {
                boolean answer = true;
                while (answer) {
                    int random = (int) (Math.random() * cards.length);

                    if (cards[random] > -1) {
                        players[i][j] = cards[random];
                        cards[random] = -1;
                        answer = false;

                    }
                }
            }
        }

        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players[i].length; j++) {
                System.out.print(players[i][j] + " ");
            }

            System.out.println();
        }
    }
}

