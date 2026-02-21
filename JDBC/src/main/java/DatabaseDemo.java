import java.sql.*; // Imports all the JDBC interfaces

public class DatabaseDemo {
    public static void main(String[] args) {
        
        // 1. Setup your credentials
        String url = "jdbc:mysql://localhost:3306/smart_meal_db";
        String username = "root";
        String password = "your_password";

        // 2. The SQL Query (Use '?' for variables, NEVER concatenate strings!)
        String query = "SELECT balance FROM accounts WHERE rfid_tag = ?";

        // 3. Try-With-Resources to automatically close the connection when done
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            // 4. Fill in the blanks in your query
            // The '1' means replace the FIRST '?' with "TAG123"
            pstmt.setString(1, "TAG123"); 

            // 5. Execute the query and get the ResultSet (a virtual table of data)
            try (ResultSet rs = pstmt.executeQuery()) {
                
                // 6. Loop through the results using rs.next()
                if (rs.next()) {
                    // Pulling the double value from the 'balance' column
                    double userBalance = rs.getDouble("balance");
                    System.out.println("Balance found: " + userBalance);
                } else {
                    System.out.println("No account found for that tag.");
                }
            }
            
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}