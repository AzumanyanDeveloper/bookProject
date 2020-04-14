package blog.model;

import java.util.Date;

public class Post {
    private String title;
    private String text;
    private String category;
    Date date;

    public Post(String title, String text, String category,Date date) {
        this.title = title;
        this.text = text;
        this.category = category;
        this.date = date;
    }

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", category='" + category + '\'' +
                ", createdDate='" + date + '\'' +
                '}';
    }
}
