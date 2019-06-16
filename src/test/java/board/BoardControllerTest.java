package board;

import config.RootConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfiguration.class)
public class BoardControllerTest {
    @Mock
    BoardService boardService;

    @InjectMocks
    BoardController boardController;

    MockMvc mvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        this.mvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    @Test
    public void name() throws Exception {
        this.mvc.perform(get("/board/test")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
