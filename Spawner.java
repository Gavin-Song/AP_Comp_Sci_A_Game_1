import greenfoot.*;

/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner  
{
    public static final WombatLandUnit[][] WAVES = {
        {
            // Wave 1 Some supply trucks. Nothing dangerous
            new SupplyTruck(), new SupplyTruck(), 
            new SupplyTruck(), new SupplyTruck(),
        },
        {
            // Wave 2 Some supply trucks, new potato trucks
            new SupplyTruck(), new SupplyTruck(),
            new PotatoTruck(), new PotatoTruck()
        },
        {
            // Wave 3 Labs in the mix
            new SupplyTruck(), new SupplyTruck(),
            new LAB(), new LAB(), new LAB(), new LAB(),
            new SupplyTruck(), new SupplyTruck()
        },
        {
            // Wave 4 Start mixing in some tanks
            new SupplyTruck(), new Tank(), new Tank(),
            new LAB(), new LAB(), new Tank(), new Tank(),
            new PotatoTruck(), new SupplyTruck()
        },
        {
            // Wave 5 More tanks, some AntiAir
            new Tank(), new Tank(), new Tank(), new Tank(),
            new LAB(), new AntiAir(), new AntiAir()
        },
        {
            // Wave 6 Spawn even more tanks and anti air
            new Tank(), new Tank(), new Tank(), new Tank(),
            new AntiAir(), new AntiAir(), new AntiAir(), new AntiAir()
        },
        {
            // Wave 7 Throw in a shield generator
            new Tank(), new Tank(), new Tank(), new Tank(),
            new AntiAir(), new ShieldGenerator(), new AntiAir(), new AntiAir()
        },
        {
            // Wave 8 is empty to give more time to deal with the shield generator
        },
        {
            // Wave 9 Throws in lots of anti air
            new AntiAir(), new AntiAir(), new AntiAir(), new AntiAir(),
            new AntiAir(), new AntiAir(), new AntiAir(), new AntiAir()
        },
        {
            // Wave 10 throws in the first TurtleTank
            new AntiAir(), new TurtleTank(), new AntiAir(), new Tank()
        },
        {
            // Wave 11 throws in a fleet of TurtleTanks
            new TurtleTank(), new TurtleTank(), new TurtleTank()
        },
        {
            // Wave 12 throws in even more TurtleTanks and EMP
            new EMPCannon(), new TurtleTank(), new TankHealth2(),
            new TankHealth2(), new TankHealth2(), new AntiAir(), new AntiAir(), 
            new AntiAir(), new AntiAir(), new AntiAir(), new AntiAir(), new AntiAir(),
            new SupplyTruck()
        },
        {
            // Wave 13 brings more fun
            new T3AntiAir(), new ShieldGenerator(), new HeavyTank()
        },
        {
            // Wave 14 :D
            new HeavyTank(), new ShieldGenerator(), new HeavyTank(), new HeavyTank(), new ShieldGenerator()
        },
        {
            // Wave 15. i'm just giving up
            new T3AntiAir(), new MagneticTruck(), new MobileMissileLauncher(), new MobileMissileLauncher(),
            new Tank(), new AntiAir(), new EMPCannon()
        },
        {
            // Wave 16 Project due tomorrow ah.
            new T3AntiAir(), new MobileMissileLauncher()
        },
        {
            // Wave 17
            new T3AntiAir(), new ShieldGenerator(), new Flamethrower()
        },
        {
            // Wave 18 Spam everything
            new T3AntiAir(), new ShieldGenerator(), new Flamethrower(),
            new HeavyTank(), new HeavyTank(), new AntiAir(), new ShieldGenerator()
        },
        { 
            // Wave 19. Just give up pls
            new ShieldGenerator(), new Tank(), new ShieldGenerator(), new Tank()
        },
        {
            // Wave 20 First experimental
            new ExperimentalWombat()
        },
        {
            // Wave 21. LABs make a come back!
            new LAB(), new LAB(), new LAB(), new LAB()
        }
        
    };

    public static final int UNIT_SPACING = 100; // Space between unit spawns
    public static final int X_OFFSET = 100; // Offset from edge of screen
    public static final int TIME_BETWEEN_WAVES = 13; // Seconds between waves
    public static final int END_GAME_EXTRA_TIME = 10; // Extra seconds after last wave spawns
    
    private int current_wave = 0;
    private static long last_wave = 0;
    
    public Spawner()
    {
        // No constructor
    }
    
    public void createWave(World world) {
        if (current_wave >= WAVES.length) {
            last_wave = System.currentTimeMillis() + 1000000000;
            return;
        }
        
        int wave = current_wave;
        
        for (int i=0; i<WAVES[wave].length; i++) {
            world.addObject(WAVES[wave][i], 
                -MyWorld.camera.getRightXBound() + i * Spawner.UNIT_SPACING + Spawner.X_OFFSET, 
                Config.GROUND_Y - 100);
        }
        last_wave = System.currentTimeMillis();
        current_wave++;
    }
    
    public boolean shouldSpawnWave() {
        return (System.currentTimeMillis() - last_wave) / 1000 >= TIME_BETWEEN_WAVES;
    }
    
    public int getWave() {
        return this.current_wave;
    }
}
