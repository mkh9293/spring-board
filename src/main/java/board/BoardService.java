package board;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService{
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public long insert(Board board) {
        return boardRepository.insert(board);
    }

    public Optional<Board> selectById(long id) {
        return Optional.of(boardRepository.selectById(id));
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
