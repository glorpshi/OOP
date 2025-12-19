public class Post {
    //attributes
    private String content;
    private int likeCount;
    private boolean isPublished;


    //constructor
    public Post() {
    }
    public Post(String content, int likeCount, boolean isPublished){
        this.content = content;
        this.likeCount = likeCount;
        this.isPublished = isPublished;
    }


    //getters and setters
    //content
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    //likes
    public int getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    //isPublished
    public boolean isPublished(){
        return isPublished;
    }
    public void setPublished(boolean published) {
        isPublished = published;
    }


    //methods
    public void like() {
        this.likeCount++;
    }
    public void printInfo() {
        System.out.println("Post -> Content: \"" + content + "\", likes: " + likeCount + ", published: " + isPublished);
    }
}

