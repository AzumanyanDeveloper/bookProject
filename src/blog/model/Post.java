package blog.model;

import java.util.Date;
import java.util.Objects;

public class Post {
    private String title;
    private String text;
    private String category;
    private User user;
    Date date;

    public Post(String title, String text, String category, User user, Date date) {
        this.title = title;
        this.text = text;
        this.category = category;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(text, post.text) &&
                Objects.equals(category, post.category) &&
                Objects.equals(user, post.user) &&
                Objects.equals(date, post.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, category, user, date);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", category='" + category + '\'' +
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}