public class GameState  
{
    public static int TOTAL_CITY_HEALTH = 10000;
    
    private int city_health = 10000;
    private long score = 0;
    
    private int player_base_health = Config.HELICOPTER_LIFE;
    private int player_health = player_base_health;
    
    private Spawner spawner;
    private long start_time;
    
    public GameState() {
        spawner = new Spawner();
        start_time = System.currentTimeMillis();
    }
    
    public void updatePlayerBaseHealth(int n) {
        this.player_base_health = n;
    }
    
    public void updatePlayerHealth(int n) {
        this.player_health = 0;
    }
    
    public void addPlayerBaseHealth(int add) {
        this.player_base_health += add;
    }
    
    public void addPlayerHealth(int add) {
        this.player_health += add;
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
    
    public int getPlayerBaseHealth() {
        return this.player_base_health;
    }
    
    public Spawner getSpawner() {
        return this.spawner;
    }
    
    public int getPlayerHealth() {
        return this.player_health;
    }
}
