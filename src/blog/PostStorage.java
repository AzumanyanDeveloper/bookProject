package blog;

import blog.model.Post;

public interface PostStorage {

     void add(Post post);
     void getPostByTitle(String title) throws PostNotFoundException;
     void searchPostsByKeyword(String keyword);
     void printAllPosts();
     void printPostsByCategory(String category);

}



