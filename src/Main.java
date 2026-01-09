import java.util.List;

public class Main {
    public static void main(String[] args) {

        SocialNetwork network = new SocialNetwork("GoyTube");

        Profile profile1 = new Profile("User1867003201", 61);
        Profile profile2 = new Profile("iLoveMyKitty68", 5);
        Profile profile3 = new Profile("FamousStar", 10000);

        Post post1 = new Post("I was lost today in some of kind Dark World...", 12013, true);
        Post post2 = new Post("I heard of Song it was smooth like a Silk", 26, true);
        Post post3 = new Post("amongus", 0, false);

        Post videoPost = new VideoPost("Bad Apple", 99999, true, 211);

        network.registerUser(profile1);
        network.registerUser(profile2);
        network.registerUser(profile3);

        network.addPost(post1);
        network.addPost(post2);
        network.addPost(post3);
        network.addPost(videoPost);

        // info print
        System.out.println("=== SOCIAL MEDIA STATUS ===");
        network.printInfo();

        // searching
        System.out.println("\n=== SEARCH RESULT (Keyword: Silk) ===");
        Post foundPost = network.searchPostByContent("Silk");
        if (foundPost != null) {
            System.out.println(foundPost.toString());
        } else {
            System.out.println("Not found");
        }

        // sorting
        System.out.println("\n=== USERS SORTED BY POPULARITY ===");
        network.sortUsersByPopularity();
        for (Profile p : network.getUsers()) {
            System.out.println(p.toString());
        }

        // filtering and polymorphism check
        System.out.println("\n=== PUBLISHED POSTS ONLY (Polymorphism Check) ===");
        List<Post> published = network.filterPublishedPosts();
        for (Post p : published) {
            p.printInfo(); // Will call VideoPost.printInfo() for the video
        }
    }
}
