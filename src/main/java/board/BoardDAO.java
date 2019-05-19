package board;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BoardDAO {
    private final String TABLE_NAME = "board";
    private final String GEN_KEY = "id";

    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAct;
    private RowMapper<BoardDTO> rowMapper = BeanPropertyRowMapper.newInstance(BoardDTO.class);

    public BoardDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAct = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(GEN_KEY);
    }

    public Long insert(BoardDTO boardDTO) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(boardDTO);
        return insertAct.executeAndReturnKey(parameterSource).longValue();
    }

    public BoardDTO selectById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put(GEN_KEY, id);
        return jdbc.queryForObject(BoardSQL.SELECT_BY_ID, params, rowMapper);
    }
}
