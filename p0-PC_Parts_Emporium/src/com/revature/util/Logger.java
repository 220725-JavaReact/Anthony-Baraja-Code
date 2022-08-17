package com.revature.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class that generates and record logs to a file
 * @author Anthony Baraja
 *
 */
public class Logger {
	
	public void writeToFile(String message) {
		
		// In Try Catch block to control scope of File IO
		// try with resources - opens and close execution
		try(FileWriter writer = new FileWriter(LocalDate.now().toString() + ".log", true)){
			writer.append(message + "\n");
			// Use .append instead of write!
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void log(LogLevel logLevel, String message) {
		Log newLog = new Log(logLevel, LocalDateTime.now(), message);
		writeToFile(newLog.toString());
	}
	
	public void logDB(LogLevel logLevel, String crudAction) {
		String message = "Database has been accessed with the action: " + crudAction;
		
		Log newLog = new Log(logLevel, LocalDateTime.now(), message);
		writeToFile(newLog.toString());
	}
	
	private class Log{
		
		LogLevel logLevel;
		LocalDateTime timestamp;
		String message;
		
		public Log(LogLevel logLevel, LocalDateTime timestamp, String message) {
			super();
			this.logLevel = logLevel;
			this.timestamp = timestamp;
			this.message = message;
		}

		@Override
		public String toString() {
			return logLevel + "\t" + timestamp + "\t" + message;
		}
	}
	
	
	/**
	 * Contain constant values set of log level
	 * @author Anthony Baraja
	 *
	 */
	public enum LogLevel{
		info, debug, verbose, warning, fatal, error
	}

}
