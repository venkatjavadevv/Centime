package com.centime.service.app.module.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LogMessage {
	private LogMessage() {
		super();
	}

	public static int logLevel = 4;
	public static final Logger LOGGER = LoggerFactory.getLogger(LogMessage.class);
	public static final ThreadLocal<String> logThreadLocal = new ThreadLocal<String>();

	public static Logger getLogger(String name) {
		return LoggerFactory.getLogger(name);
	}

	static public void setLogLevel(final String lgLevel) {
		if (lgLevel.toUpperCase().startsWith("NO")) { // None
			logLevel = 0;
		} else if (lgLevel.toUpperCase().startsWith("ERR")) { // Error
			logLevel = 1;
		} else if (lgLevel.toUpperCase().startsWith("WARN")) { // Warning
			logLevel = 2;
		} else if (lgLevel.toUpperCase().startsWith("INFO")) { // Info
			logLevel = 3;
		} else if (lgLevel.toUpperCase().startsWith("DEB")) { // Debug
			logLevel = 4;
		}
	}

	static public String getLogLevel() {
		String retLevel = null;
		switch (logLevel) {
		case 0:
			retLevel = "NONE";
			break;
		case 1:
			retLevel = "ERROR";
			break;
		case 2:
			retLevel = "WARN";
			break;
		case 3:
			retLevel = "INFO";
			break;
		case 4:
			retLevel = "DEBUG";
		}
		return retLevel;
	}

	static public void error(final String msg) {
	
		try {
			if (logLevel > 0) {
				log("ERROR: " + msg);
			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void error(final String msg, final Exception exception) {
	
		try {
			if (logLevel > 0) {
				log("ERROR: " + msg);
				if (exception != null) {
					log("Exception Trace: ", exception);
				}
			}

		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void warn(final String msg) {
		try {
			if (logLevel > 1) {
				log("WARN : " + msg);
			}

		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void info(final String msg) {
		try {
			if (logLevel > 2) {
				log("INFO : " + msg);
			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void debug(final String msg) {
		try {
			if (logLevel > 3) {
				log("DEBUG: " + msg);
			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void log(final String msg) {
		try {

			if (LOGGER != null) {
				LOGGER.info("CENTIME -" + msg);

			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void log(final String msg, final Exception exception) {
		try {

			if (LOGGER != null) {
				LOGGER.info("CENTIME -" + msg);
				LOGGER.error("CENTIME - EXCEPTION: ", exception);
			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void logBatchJob(final String msg, final Logger LoggerName) {
		try {

			if (LoggerName != null) {
				LoggerName.info(msg);
			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}
}