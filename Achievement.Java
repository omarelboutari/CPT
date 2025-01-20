package Game;
/**
 * Class to represent achievements in the game.
 * Each achievement has a name and a threshold of cookies required to unlock it.
 */
public class Achievement {
    private String name;
    private int threshold;

    /**
     * Constructor to initialize achievement properties.
     * @param name Name of the achievement.
     * @param threshold Threshold of cookies required to unlock the achievement.
     */
    public Achievement(String name, int threshold) {
        this.name = name;
        this.threshold = threshold;
    }

    /**
     * Getter for the name of the achievement.
     * @return Name of the achievement.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the threshold of cookies required to unlock the achievement.
     * @return Threshold of cookies required to unlock the achievement.
     */
    public int getThreshold() {
        return threshold;
    }
}
