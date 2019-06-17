package board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/board")
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody Board board){
        long result = boardService.insert(board);

        if(result > 0) return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Board board){
        long result = boardService.update(board);

        if(result > 0) return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/${id}")
    public ResponseEntity<Board> selectById(@PathVariable long id){
        Optional<Board> board = boardService.selectById(id);

        if(board.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(board.get());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/${id}")
    public ResponseEntity delete(@PathVariable long id){
        long result = boardService.delete(id);

        if(result > 0) return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
