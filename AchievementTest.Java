package Game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AchievementTest {

    @Test
    void testAchievementConstructor() {
        Achievement achievement = new Achievement("First Cookie", 1);
        assertEquals("First Cookie", achievement.getName());
        assertEquals(1, achievement.getThreshold());
    }

    @Test
    void testGetName() {
        Achievement achievement = new Achievement("First Cookie", 1);
        assertEquals("First Cookie", achievement.getName());
    }

    @Test
    void testGetThreshold() {
        Achievement achievement = new Achievement("First Cookie", 1);
        assertEquals(1, achievement.getThreshold());
    }
}
