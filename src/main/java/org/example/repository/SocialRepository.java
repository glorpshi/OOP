package org.example.repository;

import org.example.domain.Post;
import org.example.domain.Profile;
import java.util.List;

// interface for DIP (Dependency Inversion Principle)
public interface SocialRepository {
    void addProfile(Profile p);
    List<Profile> getAllProfiles();
    void updateFollowers(String username, int newCount);
    void deleteProfile(String username);

    // new methods for post
    void addPost(Post p);
    List<Post> getPostsByAuthor(String authorName);
}