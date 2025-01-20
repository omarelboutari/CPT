package Game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UpgradeTest {

    @Test
    void testUpgradeConstructor() {
        Upgrade upgrade = new Upgrade("Auto Clicker", 50, 1.0);
        assertEquals("Auto Clicker", upgrade.getName());
        assertEquals(50, upgrade.getCost());
        assertEquals(1.0, upgrade.getCookiesPerSecond());
    }

    @Test
    void testGetName() {
        Upgrade upgrade = new Upgrade("Auto Clicker", 50, 1.0);
        assertEquals("Auto Clicker", upgrade.getName());
    }

    @Test
    void testGetCost() {
        Upgrade upgrade = new Upgrade("Auto Clicker", 50, 1.0);
        assertEquals(50, upgrade.getCost());
    }

    @Test
    void testGetCookiesPerSecond() {
        Upgrade upgrade = new Upgrade("Auto Clicker", 50, 1.0);
        assertEquals(1.0, upgrade.getCookiesPerSecond());
    }
}
