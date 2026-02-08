package org.example.domain;

public class Post {
    private int id;
    private String content;
    private int likes;
    private String authorName;

    // constructor
    public Post() {
    }

    // previous construcor
    public Post(String content, int likeCount, boolean isPublished) {
    }

    // full constructor
    public Post(int id, String content, int likes, String authorName) {
        this.id = id;
        this.content = content;
        this.likes = likes;
        this.authorName = authorName;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }
}