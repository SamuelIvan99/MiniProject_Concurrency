package db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseRecycle {

    // for the SetupInvoice.sql file
    private String SET_SQL;
    // for the CleanupInvoice.sql file
    private String CLEAN_SQL;
    // for the PopulateInvoice.sql file
    private String POPULATE_SQL;

    // final connection to the database to be used
    // multiple times inside the class
    private final Connection connection = DatabaseConnection.connect();

    public DatabaseRecycle() {
        readScripts();
    }

    /*
     @return void
     @params String[] scriptPath, String[] scripts
     Accesses the sql scripts and builds
     a local String copy which can later be used.
    */
    private void setScripts(String[] scriptPath, String[] scripts) {
        BufferedReader buffer;
        FileReader file;

        StringBuilder builder;
        String line;
        int i = 0;

        try {
            for (; i < scripts.length; i++) {
                builder = new StringBuilder();

                file = new FileReader(scriptPath[i]);
                buffer = new BufferedReader(file);

                while ((line = buffer.readLine()) != null) {
                    builder.append(line + "\n");
                }

                scripts[i] = builder.toString();
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file located at " + scriptPath[i] + " could not be found.");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void readScripts() {
        String[] scripts = new String[3];
        String[] scriptPathsWindows = {
                ".\\sql\\SetupInvoice.sql",
                ".\\sql\\CleanupInvoice.sql",
                ".\\sql\\PopulateInvoice.sql"
        };

        String[] scriptPathsLinux = {
                "./sql/SetupInvoice.sql",
                "./sql/CleanupInvoice.sql",
                "./sql/PopulateInvoice.sql"
        };

        if (System.getProperty("os.name").equals("Linux")) {
            setScripts(scriptPathsLinux, scripts);
        } else {
            setScripts(scriptPathsWindows, scripts);
        }

        SET_SQL = scripts[0];
        CLEAN_SQL = scripts[1];
        POPULATE_SQL = scripts[2];
    }

    public void cleanDatabase() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(CLEAN_SQL);
        stmt.close();
    }

    public void restoreDatabase() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(SET_SQL);
        stmt.executeUpdate(POPULATE_SQL);
        stmt.close();
    }

    public void recycleDatabase() throws SQLException {
        cleanDatabase();
        restoreDatabase();
    }
}
