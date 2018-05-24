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
        } else if ("shell_gun".equals(type)) {
            return new ShellBullet(team);
        }
        return null;
    }
    
    public static Bullet getBullet(String type, String team, int damage) {
        if ("machine_gun".equals(type)) {
            return new MachineGunBullet(team, damage);
        } else if ("fire_gun".equals(type)) {
            return new FireBullet(team, damage);
        } else if ("missile_gun".equals(type)) {
            return new GuidedMissile(team, damage);
        } else if ("shell_gun".equals(type)) {
            return new ShellBullet(team, damage);
        }
        return null;
    }
}
