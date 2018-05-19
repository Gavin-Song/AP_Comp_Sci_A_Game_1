/**
 * Class only holds config information
 * for the game. Cannot be created. All variables
 * must be public static final
 */
public class Config  
{
    public static final double GRAVITY = 1.3;
    public static final double UP_ACCEL = 2.3;
    public static final double FRICTION = 0.002;
    public static final double MIN_VEL = 1;
    public static final int GROUND_Y = 650;

    /* Thruster forces on the Helicopter (Controls)
     *      THRUSTER_FORCE_X is force applied in x direction
     *      THRUSTER_FORCE_Y is force applied in y direction */
    public static final double THRUSTER_FORCE_X = 12;
    public static final double THRUSTER_FORCE_Y = 34;
    
    /* Masses of different objects */
    public static final double HELICOPTER_MASS = 10;
    public static final double BULLET_MASS = 0;
    
    /* Bullet config */
    public static final double BASIC_BULLET_SPEED = 20;
    
    private Config(){}
}
