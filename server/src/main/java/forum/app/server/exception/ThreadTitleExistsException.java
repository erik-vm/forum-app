package forum.app.server.exception;

public class ThreadTitleExistsException extends Exception{


    public ThreadTitleExistsException(String title){
        super(String.format("Thread with title: %s already exists!", title));
    }
}
