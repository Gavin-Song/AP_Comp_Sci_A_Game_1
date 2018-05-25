import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LaserTurret extends Turret
{
    public static int LASER_LENGTH = 2000;
    
    public LaserTurret(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, "laser_gun", team);
        this.setRandomness(0, 0);
        this.setFireRate(10);
    }   
    
    public Bullet obtainBullet(double vx, double vy) {
        Bullet new_bullet;
        if (this.getDamage() >= 0) {
            new_bullet = new LaserBullet(this.getTeam(), this.getDamage());
        } else {
            new_bullet = new LaserBullet(this.getTeam());
        }
        new_bullet.setRotation(this.getRotation());
        new_bullet.setVelocity(vx, vy);
        new_bullet.setsize(LASER_LENGTH, 5);

        return new_bullet;
    }
    
    /* public void addBullet(Bullet new_bullet) {
        double rot = this.getRotation();
        rot = Util.degToRad(rot);
        
        double x = this.getX() + Math.cos(rot) * LASER_LENGTH / 6;
        double y = this.getY() + Math.sin(rot) * LASER_LENGTH / 6;

        this.addBullet(new_bullet, (int)x, (int)y);
    } */
}
