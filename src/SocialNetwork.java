public class SocialNetwork {
    //attributes
     private String platformName;
     private int usersCount;


    //constructor
    public SocialNetwork() {
    }
    public SocialNetwork(String platformName, int usersCount) {
        this.platformName = platformName;
        this.usersCount = usersCount;
    }


    //getters and setters
    //platform
    public String getPlatformName() {
        return platformName;
    }
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    //users count
    public int getUsersCount() {
        return usersCount;
    }
    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }


    //methods
    public void registerNewUser() {
        this.usersCount++;
    }
    public void printInfo() {
        System.out.println("Social Network -> Platform: " + platformName + ", total users " + usersCount);
    }
}
