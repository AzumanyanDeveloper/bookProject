package blog;

import blog.model.Post;
import blog.storage.PostStorageImpl;

import java.util.Date;
import java.util.Scanner;

public class PostMain {
    static PostStorageImpl post = new PostStorageImpl();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        boolean isrun = true;
        while (isrun) {
            commands();
            String commandStr = scanner.nextLine();
            int command = Integer.parseInt(commandStr);
            switch (command) {
                case Commands.EXIT:
                    isrun = false;
                    System.out.println("Goodby");
                    break;
                case Commands.ADD_POST:
                    addPosts();
                    break;
                case Commands.SEARCH_POST:
                    searchPost();
                    break;
                case Commands.POSTS_BY_CATEGORY:
                    searchPostsByCategory();
                    break;
                case Commands.ALL_POSTS:
                    post.printAllPosts();
                    break;
                case Commands.SERACH_BY_KEYWORD:
                    printByKeyword();
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
    }

    private static void searchPost() {
        System.out.println("Input post name by search post");
            String byPostName = scanner.nextLine();
            try {
                post.getPostByTitle(byPostName);
            }catch (PostNotFoundException e){
                System.out.println(e.getMessage());
                System.out.println("please enter a different name");
                searchPost();
            }

    }

    private static void printByKeyword() {
        String printByKeyword = scanner.nextLine();
        post.searchPostsByKeyword(printByKeyword);
    }

    private static void searchPostsByCategory() {
        System.out.println("Input post category by search post");
        String postByCategory = scanner.nextLine();
        post.printPostsByCategory(postByCategory);
    }


    private static void addPosts() {
        System.out.println("Input post data: (title,text,category)");
        try {
            String postDataStr = scanner.nextLine();
            String[] postDate = postDataStr.split(",");
            Post posts = new Post();
            posts.setTitle(postDate[0]);
            posts.setText(postDate[1]);
            posts.setCategory(postDate[2]);
            Date date = new Date();
            posts.setDate(date);
            post.add(posts);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect value! try again");
            addPosts();
        }
        System.out.println("Thanks, our post is added");

    }

    private static void commands() {
        System.out.println("Input " + Commands.EXIT + " by Exit");
        System.out.println("Input " + Commands.ADD_POST + " by add new posts");
        System.out.println("Input " + Commands.SEARCH_POST + " by search posts in title");
        System.out.println("Input " + Commands.POSTS_BY_CATEGORY + " by serach post in category");
        System.out.println("Input " + Commands.ALL_POSTS + " by print all posts");
        System.out.println("Input " + Commands.SERACH_BY_KEYWORD + " by print post to title name or text");
    }
}

