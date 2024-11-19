package DBConnection;

public class Configs {
    protected static String dbhost = "localhost";
    protected static String dbport = "9001"; // Default port for HSQLDB
    protected static String dbuser = "SA"; // Default user for HSQLDB
    protected static String dbpass = "pass"; // Default password for HSQLDB
    protected static String dbname = "invdbfx"; // Database name

    // HSQLDB connection URL format
    protected static String dburl = "jdbc:hsqldb:hsql://" + dbhost + ":" + dbport + "/" + dbname;
}
