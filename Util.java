/**
 * Write a description of class Util here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Util  
{
    private Util() {}
    
    public static double degToRad(double deg) {
        return deg * 0.0174533;
    }
    
    public static double randomNum(double a, double b) {
        return b + Math.random() * (b - a);
    }
    
    public static double randomFromOne(double a) {
        return randomNum(1 - a, 1 + a);
    }
    
    public static double randomFromOneGeometric(double a) {
        return randomNum(1 * a, 1 / a);
    }
}
