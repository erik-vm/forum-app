package forum.app.server.exception;

public class ThreadNotFoundException extends Exception{

    public ThreadNotFoundException(){
        super("No threads where found!");
    }

    public ThreadNotFoundException(Integer id){
       super(String.format("Thread with id: %s was not found!", id));
    }

    public ThreadNotFoundException(String title){
        super(String.format("Thread with title: %s was not found!", title));
    }
}
