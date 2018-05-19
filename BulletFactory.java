/**
 * Write a description of class BulletFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletFactory  
{
    private BulletFactory() {}

    public static Bullet getBullet(String type) {
        if (type.equals("machine_gun")) {
            return new MachineGunBullet();
        }
        return null;
    }
}
