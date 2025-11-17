
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends SimulationActor
{
    /**
     * Act - do whatever the Target wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        detectCollisionWithCannonBalls();
    }   
    public void detectCollisionWithCannonBalls(){
        List<CannonBall> balls = getWorld().getObjects(CannonBall.class);
        double targetRadius = this.getImage().getHeight() / 2;
        for (int i=0; i < balls.size(); i++)
        {
            CannonBall ball = balls.get(i);
            
            Vector2D targetToBall = new Vector2D(ball.getX() - getX(), ball.getY() - getY());
            double distance = targetToBall.magnitude();
            
            double ballRadius = ball.getImage().getHeight() / 2;
           
            
            if (distance < ballRadius + targetRadius)
            {
                setImage("targetDestroyed.png");
                Greenfoot.playSound("explosion.wav");
            }
        }
    }
}




