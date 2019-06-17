package board;

import com.google.gson.Gson;
import config.RootConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfiguration.class)
public class BoardControllerTest {

    @InjectMocks
    BoardController boardController;

    MockMvc mvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        this.mvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    @Test
    public void insert_test() throws Exception {
//        this.mvc.perform(post("/board/insert").content(new Gson().toJson(new Board())))
//                .andExpect(status().isOk());

        Board board = new Board();
        board.setTitle("controller title");
        board.setContent("controller content");

        mvc.perform(
                post("/board/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(board))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").value("controller title"))
                .andExpect(jsonPath("$.content").value("controller content"));

    }
}
