package blog.storage;

import blog.PostNotFoundException;
import blog.PostStorage;
import blog.model.Post;

public class PostStorageImpl implements PostStorage {
    Post[] array = new Post[10];
    int size = 0;

    @Override
    public void add(Post post) {

        if (size == array.length) {
            extend();
        }
        array[size++] = post;
    }

    private void extend() {
        Post[] temp = new Post[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    @Override
    public void getPostByTitle(String title) throws PostNotFoundException {
        for (int i = 0; i < size; i++) {
            if (array[i].getTitle().equals(title)) {
                System.out.println(array[i]);
                break;
            } else {
                throw new PostNotFoundException("posts by this name were not found");
            }
        }
    }

    @Override
    public void searchPostsByKeyword(String keyword) {
        for (int i = 0; i < size; i++) {
            if (array[i].getTitle().contains(keyword) || array[i].getText().contains(keyword)) {
                System.out.println(array[i]);
            }
        }
    }

    @Override
    public void printAllPosts() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    @Override
    public void printPostsByCategory(String category) {
        for (int i = 0; i < size; i++) {
            if (array[i].getCategory().equals(category)) {
                System.out.println(array[i]);
            }
        }
    }


}




