package com.example.a2020mkhan.madlibs;

public class story {

    private String title;
    private String story;
    private String[] types;
    private String[] words;

    public story(String t, String story, String[] types) {
        this.title = t;
        this.story = story;
        this.types = types;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
