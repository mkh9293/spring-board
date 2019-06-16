package board;

import org.springframework.stereotype.Service;

import javax.xml.ws.Response;

@Service
public class BoardService{

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Response insert(Board board) {
        long result = boardRepository.insert(board);

        if(result > 0) {
//            return
        }

        return null;
    }


}
