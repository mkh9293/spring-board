package board;

public class BoardSql {
    public static final String SELECT_BY_ID = "SELECT * FROM board WHERE `id` = :id";
    public static final String UPDATE_BY_ID = "UPDATE `board` SET `content` = :content, `title` = :title WHERE `id` = :id";
    public static final String DELETE_BY_ID = "DELETE FROM `board` WHERE `id` = :id";
    public static final String SELECT_ALL = "SELECT * FROM `board`";
}
