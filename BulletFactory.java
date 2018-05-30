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
        } else if ("potato_gun".equals(type)) {
            return new PotatoBullet(team);
        } else if ("emp_gun".equals(type)) {
            return new EMPBullet(team);
        } else if ("explosive_gun".equals(type)) {
            return new ExplosiveBullet(team);
        } else if ("quantum_gun".equals(type)) {
            return new QuantumBullet(team);
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
        } else if ("potato_gun".equals(type)) {
            return new PotatoBullet(team, damage);
        } else if ("emp_gun".equals(type)) {
            return new EMPBullet(team, damage);
        } else if ("explosive_gun".equals(type)) {
            return new ExplosiveBullet(team, damage);
        } else if ("quantum_gun".equals(type)) {
            return new QuantumBullet(team, damage);
        }
        return null;
    }
}
