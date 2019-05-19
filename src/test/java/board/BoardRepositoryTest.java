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
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void test_insert(){
        // given
        Board board = new Board("test title", "test content");

        //when
        Long boardPk = boardRepository.insert(board);

        //then
        assertThat(boardPk, is(3L));
    }

    @Test
    public void test_select() {
        //given
        int id = 1;

        //when
        Board board = boardRepository.selectById(id);

        //then
        assertThat(board.getTitle(), is("test title"));
        assertThat(board.getContent(), is("test content"));
    }
}
