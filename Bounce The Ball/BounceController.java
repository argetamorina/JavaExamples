/**
 * Created by arget on 5/1/2016.
 */

import javax.swing.*;

/**
 * BounceController controls two moving balls.
 */
public class BounceController {
    private MovingBall ball1;  // model object
    private MovingBall ball2;  // model object
    private AnimationWriter writer; // output-view object

    /**
     * Constructor BounceController initializes the controller
     *
     * @param b1 - a ball
     * @param b2 - another ball
     * @param w  - the output-view object
     */
    public BounceController(MovingBall b1, MovingBall b2, AnimationWriter w) {
        ball1 = b1;
        ball2 = b2;
        writer = w;
    }

    /**
     *
     * Changes balls directions when they press the barrier
     */
    public void barrierCollision() {
        int x = writer.xPos;
        int y = writer.yPos;
        int x2 = writer.x2Pos;
        int y2 = writer.y2Pos;

        MovingBall[] balls = {ball1, ball2};

        for (int i = 0; i < balls.length; i++) {
            boolean hasEnteredX = false,
                    hasEnteredY = false;
            if (balls[i].xPosition() - ball1.radiusOf() < x && balls[i].xPosition() + balls[i].radiusOf() / 2 >= x) {
                hasEnteredX = true;
            }

            if (balls[i].yPosition() + balls[i].radiusOf() >= y && balls[i].yPosition() < y2) {
                hasEnteredY = true;
            }

            if (hasEnteredX && hasEnteredY) {
                balls[i].x_velocity = -balls[i].x_velocity;
            }
        }
    }
    /**
     * Changes balls directions when they press each other
     *
     */
    public void ballsCollision() {
        boolean hasEnteredX = false,
                hasEnteredY = false;

        if ((ball1.xPosition() + ball1.radiusOf() >= ball2.xPosition() && ball1.xPosition() + ball1.radiusOf() <= ball2.xPosition() + ball2.radiusOf()) || (ball2.xPosition() + ball2.radiusOf() >= ball1.xPosition() && ball2.xPosition() + ball2.radiusOf() <= ball1.xPosition() + ball2.radiusOf())) {
            hasEnteredX = true;
        }
        if ((ball1.yPosition() + ball1.radiusOf() >= ball2.yPosition() && ball1.yPosition() + ball1.radiusOf() <= ball2.yPosition() + ball2.radiusOf()) || (ball2.yPosition() + ball2.radiusOf() >= ball1.yPosition() && ball2.yPosition() + ball2.radiusOf() <= ball1.yPosition() + ball2.radiusOf())) {
            hasEnteredY = true;
        }
        if (hasEnteredX && hasEnteredY) {
            ball1.x_velocity = -ball1.x_velocity;
            ball2.x_velocity = -ball2.x_velocity;
        }
    }


    /**
     * runAnimation  runs the animation by means of an internal clock
     */
    public void runAnimation() {
        int time_unit = 1;
        while (true) {
            delay(20);   // delay 20 milliseconds --- one clock ``tick''
            ball1.move(time_unit);
            ball2.move(time_unit);
            barrierCollision();
            ballsCollision();
            writer.repaint();  // redisplay box and ball
        }
    }

    /**
     * delay pauses execution for  how_long  milliseconds
     */
    private void delay(int how_long) {
        try {
            Thread.sleep(how_long);
        } catch (InterruptedException e) {
        }
    }
}