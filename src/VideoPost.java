public class VideoPost extends Post {
    private int durationSeconds;

    public VideoPost(String content, int likeCount, boolean isPublished, int durationSeconds) {
        super(content, likeCount, isPublished);
        this.durationSeconds = durationSeconds;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    // polymorphism
    public void printInfo() {
        System.out.println("VideoPost -> Content: \"" + getContent() + "\", likes: " + getLikeCount() + ", duration: " + durationSeconds + "s");
    }

    public String toString() {
        return "VideoPost{content='" + getContent() + "', likes=" + getLikeCount() + ", duration=" + durationSeconds + "}";
    }
}
