/**
 * Write a description of class BulletFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletFactory  
{
    private BulletFactory() {}

    public static Bullet getBullet(String type, String team) {
        if ("machine_gun".equals(type)) {
            return new MachineGunBullet(team);
        } else if ("fire_gun".equals(type)) {
            return new FireBullet(team);
        } else if ("missile_gun".equals(type)) {
            return new GuidedMissile(team);
        }
        return null;
    }
}
