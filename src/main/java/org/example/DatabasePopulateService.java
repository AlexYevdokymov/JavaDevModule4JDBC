package org.example;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        String script = db.getSqlFromFile("./sql/populate_db.sql");
        db.executeUpdate(script);
    }
}
