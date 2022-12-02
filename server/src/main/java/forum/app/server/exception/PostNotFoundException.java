package forum.app.server.exception;

public class PostNotFoundException extends Exception{

    public PostNotFoundException(){
        super("No posts where found!");
    }

    public PostNotFoundException(Integer id){
       super(String.format("Post with id: %s was not found!", id));
    }

    public PostNotFoundException(Thread thread){
        super(String.format("No post where found under thread with title: %s!", thread.getName()));
    }
}
