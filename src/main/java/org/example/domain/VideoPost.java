package org.example.domain;

public class VideoPost extends Post {
    private int durationSeconds;

    public VideoPost(String content, int likeCount, boolean isPublished, int durationSeconds) {
        super(content,
                likeCount,
                isPublished);
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
        System.out.println("org.example.domain.VideoPost -> Content: \"" + getContent() + "\", likes: " + getLikeCount() + ", duration: " + durationSeconds + "s");
    }

    public String toString() {
        return "org.example.domain.VideoPost{content='" + getContent() + "', likes=" + getLikeCount() + ", duration=" + durationSeconds + "}";
    }

    private String getLikeCount() {
        return null;
    }
}
