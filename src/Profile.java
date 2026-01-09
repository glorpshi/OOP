import java.util.Objects;

public class Profile {
    // attributes
    private String username;
    private int followersCount;

    // constructor
    public Profile() {
    }

    public Profile(String username, int followersCount) {
        this.username = username;
        this.followersCount = followersCount;
    }

    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    // methods
    public void printInfo() {
        System.out.println("Profile -> User: @" + username + ", followers:" + followersCount);
    }

    public int compareFollowers(Profile other) {
        return Integer.compare(this.followersCount, other.followersCount);
    }

    // NEW methods
    public String toString() {
        return "Profile{username='" + username + "', followers=" + followersCount + "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return followersCount == profile.followersCount &&
                Objects.equals(username, profile.username);
    }

    public int hashCode() {
        return Objects.hash(username, followersCount);
    }
}
