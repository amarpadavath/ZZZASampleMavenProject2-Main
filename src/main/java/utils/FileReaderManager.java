package utils;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager;
    private ConfigReader configReader;

    // Private constructor for singleton pattern
    private FileReaderManager() {
        configReader = new ConfigReader();
    }

    // Singleton instance
    public static FileReaderManager getInstance() {
        if (fileReaderManager == null) {
            fileReaderManager = new FileReaderManager();
        }
        return fileReaderManager;
    }

    // Get the ConfigReader instance
    public ConfigReader getConfigReader() {
        return configReader;
    }

}
