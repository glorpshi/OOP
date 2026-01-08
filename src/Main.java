public class Main {
    public static void main(String[] args) {

        //objects
        Profile profile1 = new Profile("User1867003201", 61);
        Profile profile2 = new Profile("iLoveMyKitty68", 5);

        Post post1 = new Post("I was lost today in some of kind Dark World...", 12013, true );
        Post post2 = new Post("I heard of Song it was smooth like a Silk", 26, true);

        SocialNetwork network = new SocialNetwork("GoyTube", 67);


        //info print
        System.out.println("=== SOCIAL MEDIA STATUS ===");
        profile1.printInfo();
        profile2.printInfo();
        post1.printInfo();
        post2.printInfo();
        network.printInfo();


        //comparing objects
        System.out.println("\n=== PROFILE COMPARISON ===");
        int comparison = profile1.compareFollowers(profile2);

        if (comparison > 0) {
            System.out.println(profile1.getUsername() + " is more popular than " + profile2.getUsername() );
        } else if (comparison < 0) {
            System.out.println(profile1.getUsername() + "is less popular than " + profile2.getUsername() );
        } else {
            System.out.println("Both profiles have the same number of followers");
        }


        //counting published posts
        System.out.println("\n=== COUNT PUBLISHED POSTS ===");
        int publishedCount = 0; // int variable [cite: 19]

        if (post1.isPublished()) {
            publishedCount++;
        }
        if (post2.isPublished()) {
            publishedCount++;
        }
        System.out.println("Number of published posts: " + publishedCount);


        //array and for loop
        System.out.println("\n=== LOOP THROUGH POSTS ===");
        Post[] posts = {post1, post2};
        int maxLikes = 0;

        for (int i = 0; i < posts.length; i++) {
            int currentLikes = posts[i].getLikeCount();
            System.out.println("Post " + (i + 1) + " likes: " + currentLikes);

            if (currentLikes > maxLikes) {
                maxLikes = currentLikes;
            }
        }
        System.out.println("Most popular post has: " + maxLikes + " likes");
    }
}
