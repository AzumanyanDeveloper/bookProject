package blog;

import blog.model.Post;
import blog.model.User;
import blog.storage.PostStorageImpl;

import java.util.Date;
import java.util.Scanner;


public class PostMain {
    static PostStorageImpl post = new PostStorageImpl();
    static Scanner scanner = new Scanner(System.in);
    static UserStorage userStorage = new UserStorage();

    public static void main(String[] args) {
        startPage();
    }

    private static void startPage() {
        System.out.println("Welcome! Log in to add your post");
        boolean isrun = true;
        while (isrun) {
            loginOrRegisterCommands();
            String commandStr = scanner.nextLine();
            int command = Integer.parseInt(commandStr);
            switch (command) {
                case Commands.EXIT:
                    isrun = false;
                    break;
                case Commands.LOGIN:
                    userLogin();
                    break;
                case Commands.REGISTER:
                    userRegister();
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }


    private static void loginUsersForm() {
        boolean isrun1 = true;
        while (isrun1) {
            commands();
            String commandStr = scanner.nextLine();
            int command = Integer.parseInt(commandStr);
            switch (command) {
                case Commands.EXIT:
                    isrun1 = false;
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
                case Commands.ALL_USERS:
                    userStorage.printAllUsers();
                    break;
                case Commands.LOGOUT:
                    System.out.println("You are logged out. Please log in or register");
                    startPage();
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }


    private static void userLogin() {
        System.out.println("Enter your Email");
        String userEmailStr = scanner.nextLine();
        User email = userStorage.userSearch(userEmailStr);
        if (email != null) {
            System.out.println("Welcome " + email.getName() + " " + email.getSurName());
            System.out.println("Enter your password");
            String passUserStr = scanner.nextLine();
            User pass = userStorage.userSearchpass(passUserStr);
            if (pass != null) {
                System.out.println("You are successfully logged in");
                loginUsersForm();
            } else {
                System.out.println("You entered an incorrect password.Please enter again");
            }
        } else {
            System.out.println("The account for this email was not found.Please enter again or register");
        }


    }

    private static void userRegister() {
        System.out.println("Input user data: (name,surName,email,password)");
        String userDataStr = scanner.nextLine();
        String[] userDate = userDataStr.split(",");
        User user = new User();
        user.setName(userDate[0]);
        user.setSurName(userDate[1]);
        user.setEmail(userDate[2]);
        user.setPassword(userDate[3]);
        userStorage.add(user);
        System.out.println("Welcome " + user.getName() + " " + user.getSurName());
        loginUsersForm();

    }


    private static void searchPost() {
        System.out.println("Input post name by search post");
        String byPostName = scanner.nextLine();
        try {
            Post posts = post.getPostByTitle(byPostName);
            System.out.println(posts);
        } catch (PostNotFoundException e) {
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
        System.out.println("Enter your name to add a post");
        String usrName = scanner.nextLine();
        User users = userStorage.searchUserbyName(usrName);
        if (users != null) {
            System.out.println("Input post data: (title,text,category)");
        } else {
            System.out.println("You entered the wrong name (enter the name you entered when registering)");
            addPosts();
        }
        try {
            String postDataStr = scanner.nextLine();
            String[] postDate = postDataStr.split(",");
            Post posts = new Post();
            posts.setTitle(postDate[0]);
            posts.setText(postDate[1]);
            posts.setCategory(postDate[2]);
            posts.setUser(users);
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
        System.out.println("Input " + Commands.EXIT + " for Exit");
        System.out.println("Input " + Commands.ADD_POST + " for add new posts");
        System.out.println("Input " + Commands.SEARCH_POST + " for search posts in title");
        System.out.println("Input " + Commands.POSTS_BY_CATEGORY + " for serach post in category");
        System.out.println("Input " + Commands.ALL_POSTS + " for print all posts");
        System.out.println("Input " + Commands.SERACH_BY_KEYWORD + " for print post to title name or text");
        System.out.println("Input " + Commands.ALL_USERS + " for print all users");
        System.out.println("Input " + Commands.LOGOUT + " for Logout");
    }

    private static void loginOrRegisterCommands() {
        System.out.println("Input " + Commands.LOGIN + " for Login");
        System.out.println("Input " + Commands.REGISTER + " for Register");
    }

}




