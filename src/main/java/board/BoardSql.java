package board;

public class BoardSql {
    public static final String SELECT_BY_ID = "select * from board where id = :id";
    public static final String UPDATE_BY_ID = "update board set content = :content, title = :title where id = :id";
}
