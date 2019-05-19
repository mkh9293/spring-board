package board;

import config.RootConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfiguration.class)
public class boardDAOTest {
    @Autowired
    BoardDAO boardDAO;

    @Test
    public void test_insert(){
        // given
        BoardDTO boardDTO = new BoardDTO("test title", "test content");

        //when
        Long boardPk = boardDAO.insert(boardDTO);

        //then
        assertThat(boardPk, is(3L));
    }

    @Test
    public void test_select() {
        //given
        int id = 1;

        //when
        BoardDTO boardDTO = boardDAO.selectById(id);

        //then
        assertThat(boardDTO.getTitle(), is("test title"));
        assertThat(boardDTO.getContent(), is("test content"));
    }
}
