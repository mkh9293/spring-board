package board;

import config.RootConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfiguration.class)
@Transactional
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void write_test() {
        // given
        Board board = new Board("test title", "test content");

        //when
        Long boardPk = boardRepository.insert(board);

        //then
        assertThat(boardPk, is(3L));
    }

    @Test
    public void get_test() {
        //given
        int id = 1;

        //when
        Board board = boardRepository.selectById(id);

        //then
        assertThat(board.getTitle(), is("test title"));
        assertThat(board.getContent(), is("test content"));
    }

    @Test
    public void update_test() {
        //given
        int id = 1;

        //when
        Board board = boardRepository.selectById(id);
        board.setContent("test content update");
        board.setTitle("test title update");
        boardRepository.update(board);

        //then
        Board board1 = boardRepository.selectById(id);
        assertThat(board1.getContent(), is("test content update"));
        assertThat(board1.getTitle(), is("test title update"));
    }

    @Test
    public void delete_test() {
        //given
        int id = 3;

        //when
        int result = boardRepository.delete(id);

        //then
        assertThat(result, is(1));
    }

    @Test
    public void list_test() {
        //when
        List<Board> boardList = boardRepository.list();

        //then
        assertThat(boardList.size(), is(3));
    }
}
