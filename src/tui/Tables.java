package tui;

import java.sql.*;

public class Tables {

    public static void display(Connection connection, String tableName, char option) {
        String SELECT_SQL = String.format("SELECT * FROM %s", tableName);

        String[] COLUMN_NAMES = new String[10];

        try (Statement stmt = connection.createStatement()) {
            ResultSet resultRows = stmt.executeQuery(SELECT_SQL);
            ResultSetMetaData resultCols = resultRows.getMetaData();


            while (resultRows.next()) {
                for (int i = 1, length = resultCols.getColumnCount(); i <= length; i++) {
                    Object cell = resultRows.getObject(i);
                    if (option == 't' &&
                            cell instanceof String && ((String) cell).length() > 20) {
                        System.out.print(((String) cell).substring(0, 20) + "...");
                    } else {
                        System.out.print(cell);
                    }
                    System.out.print("\t|\t");
                }
                System.out.println("\n\n");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
