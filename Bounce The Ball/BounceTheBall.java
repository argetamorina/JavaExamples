/**
 * Created by arget on 5/1/2016.
 */
import java.awt.*;
/** BounceTheBall constructs and starts the objects in the animation.  */
public class BounceTheBall
{ public static void main(String[] args)
{ // construct the model objects:
    int box_size = 300;
    int balls_radius = 6;
    Box box = new Box(box_size);
    MovingBall ball1 = new MovingBall((int)(box_size / 2.0),
            (int)(box_size / 5.0),
            balls_radius, box);
    MovingBall ball2 = new MovingBall((int)(box_size / 5.0),
            (int)(box_size / 2.0),
            balls_radius, box);
    // construct the output-view objects:
    BallWriter ball1_writer = new BallWriter(ball1, Color.red);
    BoxWriter box_writer  = new BoxWriter(box);
    BallWriter ball2_writer = new BallWriter(ball2, Color.blue);
    AnimationWriter writer
            = new AnimationWriter(box_writer, ball1_writer, ball2_writer, box_size);
    // construct the controller and start it:
    new BounceController(ball1, ball2, writer).runAnimation();
}
}
