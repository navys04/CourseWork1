import java.util.ArrayList;

public class ConsoleHandler
{
    public ArrayList<Post> posts = new ArrayList<Post>();

    public void AddPost(String inAddress)
    {
        Post newPost = new Post(inAddress);
        posts.add(newPost);

        System.out.println("Успешно добавлено отделение по адресу: " + inAddress);
    }

    public Post FindPost(String inAddress)
    {
        for (var post : posts)
        {
            if (post.getAddress().toLowerCase() == inAddress.toLowerCase()) return post;
        }

        return null;
    }
}
