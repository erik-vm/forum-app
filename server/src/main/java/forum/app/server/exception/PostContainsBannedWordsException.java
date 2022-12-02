package forum.app.server.exception;

public class PostContainsBannedWordsException extends Exception{

    public PostContainsBannedWordsException(){
        super("Post contains banned words!");
    }

}
