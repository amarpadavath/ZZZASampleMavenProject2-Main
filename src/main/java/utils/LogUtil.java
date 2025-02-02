package utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;



public class LogUtil {
	
	 private static final Logger logger = LogManager.getLogger(LogUtil.class);
			
	// Logging methods
	    public static void info(String message) {
	        logger.info(message);
	    }

	    public static void warn(String message) {
	        logger.warn(message);
	    }

	    public static void error(String message) {
	        logger.error(message);
	    }

	    public static void debug(String message) {
	        logger.debug(message);
	    }

	    public static void fatal(String message) {
	        logger.fatal(message);
	    }
}
