import java.util.Objects;

public class Post {
    // attributes
    private String content;
    private int likeCount;
    private boolean isPublished;

    // constructor
    public Post() {
    }

    public Post(String content, int likeCount, boolean isPublished) {
        this.content = content;
        this.likeCount = likeCount;
        this.isPublished = isPublished;
    }

    // getters and setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    // methods
    public void like() {
        this.likeCount++;
    }

    public void printInfo() {
        System.out.println("Post -> Content: \"" + content + "\", likes: " + likeCount + ", published: " + isPublished);
    }

    // NEW methods
    public String toString() {
        return "Post{content='" + content + "', likes=" + likeCount + ", published=" + isPublished + "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return likeCount == post.likeCount &&
                isPublished == post.isPublished &&
                Objects.equals(content, post.content);
    }

    public int hashCode() {
        return Objects.hash(content, likeCount, isPublished);
    }
}
