public class Profile {
    //attributes
    private String username;
    private int followersCount;


    //constructor
    public Profile() {
    }
    public Profile (String username, int followersCount) {
        this.username = username;
        this.followersCount = followersCount;
    }


    //getters and setters
    //username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    //followers count
    public int getFollowersCount() {
        return followersCount;
    }
    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }


    //methods
    public void printInfo() {
        System.out.println("Profile -> User: @" + username + ", followers:" + followersCount);
    }
    public int compareFollowers(Profile other) {
        return Integer.compare(this.followersCount, other.followersCount);
    }
}