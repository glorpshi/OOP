package org.example.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Profile {
    private String username;
    private int followersCount;

    public Profile() {
    }

    @JsonCreator
    public Profile(@JsonProperty("username") String username,
                   @JsonProperty("followersCount") int followersCount) {
        this.username = username;
        this.followersCount = followersCount;
    }

    // builder
    public static class Builder {
        private String username;
        private int followersCount;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder followers(int count) {
            this.followersCount = count;
            return this;
        }

        public Profile build() {
            return new Profile(username, followersCount);
        }
    }


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public int getFollowersCount() { return followersCount; }
    public void setFollowersCount(int followersCount) { this.followersCount = followersCount; }

    @Override
    public String toString() {
        return "Profile{username='" + username + "', followers=" + followersCount + "}";
    }
}