import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "9LLDTBKW8CNN";

    // connection check method
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // data insert
    public void addProfile(Profile profile) {
        String SQL = "INSERT INTO profiles(username, followers_count) VALUES(?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, profile.getUsername());
            pstmt.setInt(2, profile.getFollowersCount());
            pstmt.executeUpdate();
            System.out.println("Profile added to DB: " + profile.getUsername());

        } catch (SQLException ex) {
            System.out.println("Error adding profile: " + ex.getMessage());
        }
    }

    // read profiles
    public List<Profile> getAllProfiles() {
        List<Profile> profiles = new ArrayList<>();
        String SQL = "SELECT * FROM profiles";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Profile p = new Profile(
                        rs.getString("username"),
                        rs.getInt("followers_count")
                );
                profiles.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error reading profiles: " + ex.getMessage());
        }
        return profiles;
    }

    // update followers_count
    public void updateFollowers(String username, int newCount) {
        String SQL = "UPDATE profiles SET followers_count = ? WHERE username = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, newCount);
            pstmt.setString(2, username);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Updated followers for: " + username);
            } else {
                System.out.println("User not found: " + username);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // profile delete
    public void deleteProfile(String username) {
        String SQL = "DELETE FROM profiles WHERE username = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, username);
            pstmt.executeUpdate();
            System.out.println("Deleted profile: " + username);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}