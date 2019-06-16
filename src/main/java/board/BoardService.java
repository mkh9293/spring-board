package board;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService{

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public HttpStatus insert(Board board) {
        long result = boardRepository.insert(board);

        if(result == 0) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return HttpStatus.OK;
    }

    public Board selectById(long id) {
        return boardRepository.selectById(id);
    }

    public int update(Board board) {
        return boardRepository.update(board);
    }

    public int delete(long id) {
        return boardRepository.delete(id);
    }

    public List<Board> list() {
        return boardRepository.list();
    }


}
