package com.example.sanjeev.exoplayer_androidplayer.logging;

public interface Logger {

    void e (String tag, String message);
    void e (String tag, String message, Exception e);
    void w (String tag, String message);
    void w (String tag, String message, Exception e);
    void i (String tag, String message);
    void d (String tag, String message);

    void setVerbosityLevel (Verbosity level);

    enum Verbosity {
        NONE(0),
        ERROR(1),
        WARN(2),
        INFO(3),
        DEBUG(4);

        private final int level;

        Verbosity(int level)
        {
            this.level = level;
        }

        public int getLevel()
        {
            return level;
        }
    }


}
