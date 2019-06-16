package board;

import config.RootConfiguration;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.core.Is.is;
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
        HttpStatus result = boardService.insert(board);

        //then
        assertThat(result.value(), is(200));
    }

    @Test
    public void get_test() {
        //given
        int id = 3;

        //when
        Board board = boardService.selectById(id);

        //then
        assertThat(board.getId(), is(3));
        assertThat(board.getContent(), is("test content"));
        assertThat(board.getTitle(), is("test title"));
    }

    @Test
    public void update_test() {
        //given
        int id = 3;

        //when
        Board board = boardService.selectById(id);
        board.setContent("update content");
        board.setTitle("update title");
        int result = boardService.update(board);

        //then
        assertThat(result, is(1));

        board = boardService.selectById(id);
        assertThat(board.getTitle(), is("update title"));
        assertThat(board.getContent(), is("update content"));
    }

    @Test
    public void delete_test() {
        //given
        int id = 3;

        //when
        int result = boardService.delete(id);

        //then
        assertThat(result, is(1));
    }

    @Test
    public void list_test() {
        //when
        List<Board> boardList = boardService.list();

        //then
        assertThat(boardList.size(), is(3));
    }
}

