package Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CookieCrafterTest {

    private CookieCrafter cookieCrafter;

    @BeforeEach
    void setUp() {
        cookieCrafter = new CookieCrafter();
    }

    @Test
    void testClickCookie() {
        int initialCookies = cookieCrafter.getCookies();
        cookieCrafter.clickCookie();
        assertEquals(initialCookies + 1, cookieCrafter.getCookies());
    }

    @Test
    void testBuyUpgrades() {
        cookieCrafter.setCookies(100);
        cookieCrafter.buyUpgrades(new Scanner(System.in));  // Simulate user input for upgrade purchase
        assertEquals(50, cookieCrafter.getCookies());
        assertTrue(cookieCrafter.getCookiesPerSecond() > 0);
    }

    @Test
    void testViewStats() {
        cookieCrafter.setCookies(100);
        cookieCrafter.setCookiesPerSecond(10);
        String expectedStats = "Total Cookies: 100\nCookies Per Second: 10.0";
        assertEquals(expectedStats, cookieCrafter.viewStats());
    }

    @Test
    void testCheckAchievements() {
        cookieCrafter.setCookies(100);
        cookieCrafter.checkAchievements();
        // Assuming achievements are set correctly, check if the first one is unlocked
        assertTrue(cookieCrafter.isAchievementUnlocked("Hundred Cookies"));
    }

    @Test
    void testStartGame() {
        cookieCrafter.startGame();
        // Verify that cookies are increasing (test indirectly by observing side effects or checking method calls)
    }
}
