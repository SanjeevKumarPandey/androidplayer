package com.example.sanjeev.exoplayer_androidplayer.logging;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InMemoryLogger implements Logger {
    private List<LogEntry> logEntries = new ArrayList<LogEntry>();

    private int DEFAULT_MAX_ENTRY_COUNT = 1000;
    private int maxEntryCount = DEFAULT_MAX_ENTRY_COUNT;

    private Verbosity maxVerbosityLevel = Verbosity.INFO;

    private final static SimpleDateFormat sdf = new SimpleDateFormat(
            "dd/MM/yyyy HH:mm:ss");

    private void addEntry(LogEntry logEntry) {
        if (logEntries.size() >= maxEntryCount) {
            logEntries.remove(logEntries.size() - 1);
        }

        logEntries.add(0, logEntry);
    }

    public void setCapacity(int maxEntryCount) {
        this.maxEntryCount = maxEntryCount;
    }

    public List<LogEntry> getEntries() {
        List<LogEntry> entries = new ArrayList<LogEntry>();
        entries.addAll(logEntries);

        return entries;
    }

    public void clear() {
        logEntries.clear();
    }

    @Override
    public void i(String logTag, String message) {
        if (maxVerbosityLevel.getLevel() < Verbosity.INFO.getLevel())
            return;

        addEntry(new LogEntry(now(), message, Verbosity.INFO, logTag));
        android.util.Log.i(logTag, message);
    }

    @Override
    public void d(String logTag, String message) {
        if (maxVerbosityLevel.getLevel() < Verbosity.DEBUG.getLevel())
            return;

        addEntry(new LogEntry(now(), message, Verbosity.DEBUG, logTag));
        android.util.Log.d(logTag, message);
    }

    @Override
    public void w(String logTag, String message) {
        if (maxVerbosityLevel.getLevel() < Verbosity.WARN.getLevel())
            return;

        addEntry(new LogEntry(now(), message, Verbosity.WARN, logTag));
        android.util.Log.w(logTag, message);
    }

    @Override
    public void w(String logTag, String message, Exception exception) {
        if (maxVerbosityLevel.getLevel() < Verbosity.WARN.getLevel())
            return;

        addEntry(new LogEntry(now(), message, Verbosity.WARN, logTag));
        android.util.Log.e(logTag, message, exception);
    }

    @Override
    public void e(String logTag, String message) {
        if (maxVerbosityLevel.getLevel() < Verbosity.ERROR.getLevel())
            return;

        addEntry(new LogEntry(now(), message, Verbosity.ERROR, logTag));
        android.util.Log.e(logTag, message);
    }

    @Override
    public void e(String logTag, String message, Exception exception) {
        if (maxVerbosityLevel.getLevel() < Verbosity.ERROR.getLevel())
            return;

        addEntry(new LogEntry(now(), message, Verbosity.ERROR, logTag));
        android.util.Log.e(logTag, message, exception);
    }

    @Override
    public void setVerbosityLevel(Verbosity level) {
        this.maxVerbosityLevel = level;
    }

    private String now() {
        Calendar cal = Calendar.getInstance();
        return sdf.format(cal.getTime());
    }

    public class LogEntry
    {
        public LogEntry(String dateTime,
                        String message,
                        Verbosity verbosity,
                        String tag)
        {
            this.dateTime = dateTime;
            this.message = message;
            this.verbosity = verbosity;
            this.tag = tag;
        }

        public String getDateTime()
        {
            return dateTime;
        }

        public String getMessage()
        {
            return message;
        }

        public Verbosity getVerbosity()
        {
            return verbosity;
        }

        public String getTag()
        {
            return tag;
        }


        private final String dateTime;
        private final String message;
        private final Verbosity verbosity;
        private final String tag;
    }

}
