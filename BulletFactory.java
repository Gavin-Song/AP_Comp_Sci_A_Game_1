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
        if ("machine_gun".equals(type)) {
            return new MachineGunBullet();
        } else if ("fire_gun".equals(type)) {
            return new FireBullet();
        }
        return null;
    }
}
