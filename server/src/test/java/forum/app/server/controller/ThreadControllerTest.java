package forum.app.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import forum.app.server.model.Thread;
import forum.app.server.repository.ThreadRepository;
import forum.app.server.service.ThreadService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class ThreadControllerTest {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private ThreadService threadService;

    @Autowired
    private ThreadRepository threadRepository;
    @Autowired
    ObjectMapper objectMapper;

    private static MockHttpServletRequest request;

    public static final MediaType APPLICATION_JSON_UTF8 = APPLICATION_JSON;

    Thread thread;

    @BeforeAll
    public static void setup() {
        request = new MockHttpServletRequest();
        request.setParameter("name", "Cool name");
    }
//    @BeforeEach
//    public void beforeEach(){
//        jdbc.execute("insert into thread(name) " + "values ('Awesome thread')");
//    }
//
//    @AfterEach
//    public void setupAfterTransaction(){
//        jdbc.execute("delete from thread");
//    }


    @Test
    void saveThreadHttpRequest() throws Exception {
        thread.setTitle("Cool title oujee");
        this.mockMvc.perform(post("/thread/")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(thread)))
                .andExpect(status().isOk()).andReturn();

        Thread verifyThread =  threadRepository.findByTitle("Cool title oujee").get();
        assertNotNull(verifyThread, "Thread should not be null");

    }


    @Test
    void findAllThreads() {
    }

//    @Test
//    void getThreadById() throws Exception {
//
//        Thread thread = new Thread();
//        thread.setId(1);
//        thread.setTitle("Title");
//
//        when(threadService.findThreadById(1)).thenReturn(thread);
//        assertEquals(thread, threadService.findThreadById(1));
//
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/thread/id:{id}"))
//                .andExpect(status().isOk()).andReturn();
//
//        ModelAndView mav = mvcResult.getModelAndView();
//
//    }
}