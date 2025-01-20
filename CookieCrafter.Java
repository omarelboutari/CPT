package Game;
import java.util.*;

/**
 * Main class for the Cookie Crafter game.
 * This class manages the game logic, including upgrades, achievements, and stats.
 */
public class CookieCrafter {
    private int cookies;
    private double cookiesPerSecond;
    private List<Upgrade> upgrades;
    private Queue<Achievement> achievements;

    // Constants for upgrade costs and achievement thresholds
    public static final int AUTO_CLICKER_COST = 50;
    public static final int COOKIE_FACTORY_COST = 200;
    public static final int COOKIE_EMPIRE_COST = 1000;
    public static final int FIRST_COOKIE_THRESHOLD = 1;
    public static final int HUNDRED_COOKIES_THRESHOLD = 100;
    public static final int COOKIE_MILLIONAIRE_THRESHOLD = 1000000;

    /**
     * Constructor to initialize game variables.
     */
    public CookieCrafter() {
        cookies = 0;
        cookiesPerSecond = 0;
        upgrades = new ArrayList<>();
        achievements = new LinkedList<>();
        setupGame();
    }

    /**
     * Sets up initial upgrades and achievements.
     */
    private void setupGame() {
        upgrades.add(new Upgrade("Auto Clicker", AUTO_CLICKER_COST, 1));
        upgrades.add(new Upgrade("Cookie Factory", COOKIE_FACTORY_COST, 5));
        upgrades.add(new Upgrade("Cookie Empire", COOKIE_EMPIRE_COST, 20));

        achievements.add(new Achievement("First Cookie", FIRST_COOKIE_THRESHOLD));
        achievements.add(new Achievement("Hundred Cookies", HUNDRED_COOKIES_THRESHOLD));
        achievements.add(new Achievement("Cookie Millionaire", COOKIE_MILLIONAIRE_THRESHOLD));
    }

    /**
     * Displays the main menu and handles user input.
     */
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Cookie Crafter ---");
            System.out.println("1. Click for cookies");
            System.out.println("2. Buy upgrades");
            System.out.println("3. View stats");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> clickCookie();
                case 2 -> buyUpgrades(scanner);
                case 3 -> viewStats();
                case 4 -> {
                    System.out.println("Thanks for playing!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Simulates clicking for cookies and checks for unlocked achievements.
     */
    private void clickCookie() {
        cookies++;
        System.out.println("You clicked a cookie. Total cookies: " + cookies);
        checkAchievements();
    }

    /**
     * Displays available upgrades and allows the user to purchase one.
     * @param scanner Scanner to read user input.
     */
    private void buyUpgrades(Scanner scanner) {
        System.out.println("\nAvailable Upgrades:");
        for (int i = 0; i < upgrades.size(); i++) {
            Upgrade upgrade = upgrades.get(i);
            System.out.printf("%d. %s - Cost: %d, CPS: %.1f\n", i + 1, upgrade.getName(), upgrade.getCost(), upgrade.getCookiesPerSecond());
        }
        System.out.print("Choose an upgrade to buy (or 0 to cancel): ");
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < upgrades.size()) {
            Upgrade selectedUpgrade = upgrades.get(choice);
            if (cookies >= selectedUpgrade.getCost()) {
                cookies -= selectedUpgrade.getCost();
                cookiesPerSecond += selectedUpgrade.getCookiesPerSecond();
                System.out.println("You bought: " + selectedUpgrade.getName());
            } else {
                System.out.println("Not enough cookies.");
            }
        } else {
            System.out.println("Upgrade canceled.");
        }
    }

    /**
     * Displays the game statistics including total cookies and cookies per second.
     */
    private void viewStats() {
        System.out.println("\n--- Stats ---");
        System.out.println("Total Cookies: " + cookies);
        System.out.println("Cookies Per Second: " + cookiesPerSecond);
    }

    /**
     * Checks and unlocks achievements based on the number of cookies.
     */
    private void checkAchievements() {
        while (!achievements.isEmpty() && cookies >= achievements.peek().getThreshold()) {
            Achievement unlocked = achievements.poll();
            System.out.println("Achievement unlocked: " + unlocked.getName());
        }
    }

    /**
     * Starts the game by initiating the automatic cookie generation loop.
     */
    public void startGame() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                cookies += cookiesPerSecond;
            }
        }, 1000, 1000);

        displayMenu();
        timer.cancel();
    }

    /**
     * Main method to start the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        CookieCrafter game = new CookieCrafter();
        game.startGame();
    }
}
