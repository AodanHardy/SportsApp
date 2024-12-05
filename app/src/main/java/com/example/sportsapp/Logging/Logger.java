package com.example.sportsapp.Logging;


import android.util.Log;

public class Logger {
    private final String TAG;
    public Logger(Class<?> clazz) {
        this.TAG = clazz.getSimpleName();
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void warning(String message) {
        log("WARNING", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    private void log(String level, String message) {
        // Log time and class name
        String timestamp = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            timestamp = java.time.LocalDateTime.now().toString();
        }

        switch (level) {
            case "INFO":
                Log.i(TAG, timestamp + " [INFO] " + message);
                break;
            case "WARNING":
                Log.w(TAG, timestamp + " [WARNING] " + message);
                break;
            case "ERROR":
                Log.e(TAG, timestamp + " [ERROR] " + message);
                break;
            default:
                Log.d(TAG, timestamp + " [DEBUG] " + message);
                break;
        }
    }
}


