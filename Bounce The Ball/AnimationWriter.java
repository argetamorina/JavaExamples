/**
 * Created by arget on 5/1/2016.
 */
import java.awt.*;
import javax.swing.*;
/** AnimationWriter displays a box with two balls in it.  */
public class AnimationWriter extends JPanel
{ private BoxWriter box_writer;    // the output-view of the box
    private BallWriter ball1_writer;  // the output-view of the ball in the box
    private BallWriter ball2_writer;  // the output-view of the ball in the box
    public int frameSize;
    public int xPos;
    public int yPos;
    public int x2Pos;
    public int y2Pos;

    /** Constructor AnimationWriter construct the frame
     * @param b - the box's writer
     * @param l1 - the ball's writer
     * @param l2 - the ball's writer
     * @param size - the frame's size */
    public AnimationWriter(BoxWriter b, BallWriter l1, BallWriter l2, int size)
    { box_writer = b;
        ball1_writer = l1;
        ball2_writer = l2;
        this.frameSize = size;
        JFrame my_frame = new JFrame();
        my_frame.getContentPane().add(this);
        my_frame.setTitle("Bounce");
        this.setPreferredSize(new Dimension(this.frameSize, this.frameSize));
        my_frame.pack();
        my_frame.setVisible(true);
    }

    /** paintComponent paints the box and ball
     * @param g - the graphics pen */
    public void paintComponent(Graphics g)
    { box_writer.paint(g);
        ball1_writer.paint(g);
        ball2_writer.paint(g);
        this.xPos = this.frameSize / 3;
        this.yPos = this.frameSize / 8;
        this.x2Pos = this.xPos;
        this.y2Pos = this.frameSize / 2;
        g.setColor(Color.DARK_GRAY);
        g.drawLine(this.xPos, this.yPos,this.x2Pos , y2Pos );
    }
}
