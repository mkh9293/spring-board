package board;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    private final String TABLE_NAME = "board";
    private final String GEN_KEY = "id";

    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAct;
    private RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAct = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(GEN_KEY);
    }

    public Long insert(Board board) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(board);
        return insertAct.executeAndReturnKey(parameterSource).longValue();
    }

    public Board selectById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put(GEN_KEY, id);
        return jdbc.queryForObject(BoardSql.SELECT_BY_ID, params, rowMapper);
    }

    public int update(Board board) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(board);
        return jdbc.update(BoardSql.UPDATE_BY_ID, parameterSource);
    }

    public int delete(long id) {
        Map<String, ?> params = Collections.singletonMap(GEN_KEY, id);
        return jdbc.update(BoardSql.DELETE_BY_ID, params);
    }

    public List<Board> list() {
        return jdbc.query(BoardSql.SELECT_ALL, rowMapper);
    }
}
