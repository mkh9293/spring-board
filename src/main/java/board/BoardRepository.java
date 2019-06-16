package board;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

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

    public Optional<Long> insert(Board board) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(board);
        return Optional.of(insertAct.executeAndReturnKey(parameterSource).longValue());
    }

    public Optional<Board> selectById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put(GEN_KEY, id);
        return Optional.of(jdbc.queryForObject(BoardSql.SELECT_BY_ID, params, rowMapper));
    }

    public Optional<Integer> update(Board board) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(board);
        return Optional.of(jdbc.update(BoardSql.UPDATE_BY_ID, parameterSource));
    }

    public Optional<Integer> delete(long id) {
        Map<String, ?> params = Collections.singletonMap(GEN_KEY, id);
        return Optional.of(jdbc.update(BoardSql.DELETE_BY_ID, params));
    }

    public List<Board> list() {
        List<Board> list = jdbc.query(BoardSql.SELECT_ALL, rowMapper);
        return list.isEmpty() ? Collections.EMPTY_LIST : list;
    }
}
