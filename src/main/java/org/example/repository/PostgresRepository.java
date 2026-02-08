package org.example.repository;

import org.example.domain.Post;
import org.example.domain.Profile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresRepository implements SocialRepository {

    private final String url = "jdbc:postgresql://localhost:5432/social_network_db";
    private final String user = "postgres";
    private final String pass = "9LLDTBKW8CNN";

    private Connection connect() {
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addProfile(Profile p) {
        String sql = "INSERT INTO profiles(username, followers_count) VALUES(?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (conn == null) return;
            stmt.setString(1, p.getUsername());
            stmt.setInt(2, p.getFollowersCount());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public List<Profile> getAllProfiles() {
        List<Profile> list = new ArrayList<>();
        String sql = "SELECT * FROM profiles";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (conn == null) return list;
            while (rs.next()) {
                list.add(new Profile.Builder()
                        .username(rs.getString("username"))
                        .followers(rs.getInt("followers_count"))
                        .build());
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void updateFollowers(String username, int newCount) {
        String sql = "UPDATE profiles SET followers_count = ? WHERE username = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (conn == null) return;
            stmt.setInt(1, newCount);
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void deleteProfile(String username) {
        String sql = "DELETE FROM profiles WHERE username = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (conn == null) return;
            stmt.setString(1, username);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }


    @Override
    public void addPost(Post p) {
        String sql = "INSERT INTO posts(content, likes, author_username) VALUES(?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (conn == null) return;
            stmt.setString(1, p.getContent());
            stmt.setInt(2, p.getLikes());
            stmt.setString(3, p.getAuthorName());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public List<Post> getPostsByAuthor(String authorName) {
        List<Post> list = new ArrayList<>();
        String sql = "SELECT * FROM posts WHERE author_username = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (conn == null) return list;
            stmt.setString(1, authorName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Post(
                        rs.getInt("id"),
                        rs.getString("content"),
                        rs.getInt("likes"),
                        rs.getString("author_username")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}