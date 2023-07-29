package org.example;


public class DatabaseInitService {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        String script = db.getSqlFromFile("./sql/init_db.sql");
        db.executeUpdate(script);
    }
}
