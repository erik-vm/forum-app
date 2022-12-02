package forum.app.server;

import com.github.javafaker.Faker;
import forum.app.server.model.Category;
import forum.app.server.model.Post;
import forum.app.server.model.Thread;
import forum.app.server.repository.PostRepository;
import forum.app.server.repository.ThreadRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

import static forum.app.server.model.Category.*;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ThreadRepository threadRepository, PostRepository postRepository){
        return args -> {
            Faker faker = new Faker();

            for (int i = 0; i < 5; i++){
                Thread thread = new Thread();
                thread.setTitle(faker.name().title());
                threadRepository.save(thread);
                for (int j = 1; j <= new Random().nextInt(1, 10); j++){
                    Post post = new Post();
                    post.setThread(thread);
                    post.setCategory(getCategory());
                    post.setBody(faker.lorem().sentence(new Random().nextInt(3,20)));
                    post.setPublic(trueOrFalse(j));
                    postRepository.save(post);
                }
            }
        };
    }

    Category getCategory(){
        int randomNumber = new Random().nextInt(1,4);
        if (randomNumber == 1){
            return SUGGESTION;
        }
        if (randomNumber == 2){
            return QUESTION;
        }else {
            return CLARIFICATION;
        }
    }

    boolean trueOrFalse(int num){
        if (num % 2 == 0){
            return true;
        }else {
            return false;
        }
    }

}
