package board;

public class BoardSQL {
    public static final String INSERT_BOARD = "insert into board values(:title, :content)";
    public static final String SELECT_BY_ID = "select * from board where id = :id";
}
