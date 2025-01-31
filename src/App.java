public class App {
    public static void main(String[] args) throws Exception {

        // Connect to database, if it doesn't exist it gets automatically created.
        DBOperations.ConnectToDatabase();
        // Check if the table DECKS exists.
        boolean tableExists = DBOperations.doesTableExist();
        // Really self explanatory.
        if (!tableExists) {
            DBOperations.CreateTable();
        }
    }
}
