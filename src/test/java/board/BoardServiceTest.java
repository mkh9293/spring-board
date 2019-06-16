package board;

import config.RootConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Response;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfiguration.class})
@Transactional
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void insert_test() {
        //given
        Board board = new Board();
        board.setTitle("service title1");
        board.setContent("service content");

        //when
        Response result = boardService.insert(board);

        //then
//        assertThat(result.getContext(), is());
    }
}
