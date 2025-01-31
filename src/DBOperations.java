import java.sql.*;

public class DBOperations {
   public static void ConnectToDatabase() {
      Connection connection = null;

      try {
         Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection("jdbc:sqlite:database.db");
         connection.close();
      } catch ( Exception e ) {
         System.out.println("Exception on ConnectToDatabase method.");
         System.exit(0);
      }
   }

   public static void CreateTable() {
      Connection connection = null;
      Statement statement = null;

      try {
         Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection("jdbc:sqlite:database.db");

         statement = connection.createStatement();

         String sql =   "CREATE TABLE DECKS" + "(ID INT PRIMARY KEY NOT NULL," + "NAME TEXT NOT NULL)";
         statement.executeUpdate(sql);
         statement.close();
         connection.close();
      } catch (Exception e) {
         System.out.println("Exception on CreateTable method.");
         System.exit(0);
      }
   }

   public static boolean doesTableExist() {
      boolean doesExist = false;
      String query = "SELECT name FROM sqlite_master WHERE type='table' AND name='DECKS';";

      try (
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            PreparedStatement statement = connection.prepareStatement(query)
         ) {
            try (ResultSet resultSet = statement.executeQuery()) {
               if (resultSet.next()) {
                  doesExist = true;
               }
            }
      } catch (SQLException e) {
         System.out.println("SQLException on doesTableExist method.");
      }
      return doesExist;
  }
}
