package utils;



public class ScenarioContext {
    // Using ThreadLocal to handle parallel execution safely
    private static ThreadLocal<String> currentScenarioName = new ThreadLocal<>();

    public static void setCurrentScenarioName(String name) {
        currentScenarioName.set(name);
    }

    public static String getCurrentScenarioName() {
        return currentScenarioName.get();
    }

    // Optionally, clear the value after the scenario ends
    public static void clear() {
        currentScenarioName.remove();
    }
}
