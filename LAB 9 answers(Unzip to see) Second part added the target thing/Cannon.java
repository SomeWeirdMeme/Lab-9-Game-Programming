import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Cannon extends Actor
{
    private final static double CANNON_BALL_VELOCITY = 1500.0;
    public void act()
    {
        // Add your action code here.
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(mouse != null)
        {
            Vector2D cannonToMouse = new Vector2D(mouse.getX() - getX() , mouse.getY() - getY()); 

            alignWithVector(cannonToMouse);

            if (Greenfoot.mouseClicked(null))
            {
                cannonToMouse.normalize();
                cannonToMouse = Vector2D.multiply(cannonToMouse, CANNON_BALL_VELOCITY);

                CannonBall ball = new CannonBall();
                ball.setVelocity(cannonToMouse);
                getWorld().addObject(ball, getX(), getY());
                Greenfoot.playSound("cannonSound.wav");
            }

        }
    }

    public void alignWithVector(Vector2D v){           
        double adjacent = v.getX();
        double opposite = v.getY();

        double angleRadians = Math.atan2(opposite, adjacent);
        double angleDegrees = Math.toDegrees(angleRadians);

        setRotation((int) angleDegrees);  
    }
}
