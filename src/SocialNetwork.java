import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SocialNetwork {
    // attributes
    private String platformName;
    // data pool logic
    private List<Profile> users;
    private List<Post> posts;

    // constructor
    public SocialNetwork(String platformName) {
        this.platformName = platformName;
        this.users = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    // getters and setters
    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public List<Profile> getUsers() {
        return users;
    }

    public List<Post> getPosts() {
        return posts;
    }

    // methods
    public void registerUser(Profile user) {
        this.users.add(user);
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    // searching
    public Post searchPostByContent(String keyword) {
        for (Post post : posts) {
            if (post.getContent().contains(keyword)) {
                return post;
            }
        }
        return null;
    }

    // Sorting
    public void sortUsersByPopularity() {
        users.sort(Comparator.comparingInt(Profile::getFollowersCount).reversed());
    }

    // filtering
    public List<Post> filterPublishedPosts() {
        List<Post> publishedPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post.isPublished()) {
                publishedPosts.add(post);
            }
        }
        return publishedPosts;
    }

    public void printInfo() {
        System.out.println("Social Network -> Platform: " + platformName + ", total users: " + users.size() + ", total posts: " + posts.size());
    }
}