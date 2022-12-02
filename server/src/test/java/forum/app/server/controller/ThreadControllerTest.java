package forum.app.server.controller;

import forum.app.server.model.Thread;
import forum.app.server.repository.ThreadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@AutoConfigureMockMvc
class ThreadControllerTest {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private MockMvc mockMvc;

    private Thread thread;


    @BeforeEach
    void setUp() {
        thread = new Thread();
        thread.setTitle("Awesome thread!");
    }

    @Test
    void whenSaveThread_thenReturnThread() throws Exception {

        threadRepository.save(thread);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/thread/"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findAllThreads() {
    }

    @Test
    void findThreadById() {
    }
}