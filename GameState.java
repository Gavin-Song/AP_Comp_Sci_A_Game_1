public class GameState  
{
    private int city_health = 10000;
    private long score = 0;
    
    public GameState() {
        // No need for constructor
    }
    
    public void damageCity(int damage) {
        this.city_health -= damage;
    }
    
    public void incrementScore(long add) {
        this.score += add;
    }
    
    public long getScore() {
        return score;
    }
    
    public int getCityHealth() {
        return this.city_health;
    }
}
