import javax.swing.*;
import java.awt.*;

/**
 * Created by arget on 4/23/2016.
 */
public class ChessBoard extends JPanel {
    public int frame_width ;
    public int frame_height;
    public int rows ;
    public ChessBoard( int a, int b){
        this.frame_width = a;
        this.frame_height = b;
        JFrame frame = new JFrame();
        this.rows = Integer.parseInt(JOptionPane.showInputDialog("Write number of rows: "));
        frame.getContentPane().add(this);
        frame.setTitle("Chess Board");
        frame.setSize(this.frame_width, this.frame_height);
        frame.setVisible(true);
    }
    public void paintComponent(Graphics g){
        printBoard(g);
       // paintBoard1(20, 20, 50, 50, g);
    }
    private void printBoard(Graphics g){
        int x = this.frame_width / (this.rows + 2);
        int y = this.frame_height / (this.rows + 2);
       // int x_position = x;
       // int y_position = y;
        g.setColor(Color.pink);
       //g.drawRect(x, y, 100 ,200);
        int rectSquare = this.frame_width / (this.rows + 4);
        for (int i = 0;i <this.rows ; i = i +1){
           int  x_position = x + (i * rectSquare);
            for (int j =0; j< this.rows; j = j +1) {
               int  y_position = y + (j * rectSquare);
                if (((i + j) % 2) == 0){
                    g.setColor(Color.pink);
                }else { g.setColor(Color.gray); }
                g.fillRect(x_position, y_position, rectSquare, rectSquare);
            }
        }
    }
    
    public static void main(String[] args) {
        new ChessBoard(600, 600);
    }
}
