package DAO;

import com.google.common.collect.Lists;
import entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class TestDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void delete(String id) {
        StringBuilder sql = new StringBuilder("delete from test where id = ?");
        List<Object> param = Lists.newArrayList();
        param.add(id);
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public void add(Test test) {
        StringBuilder sql = new StringBuilder("insert into test(test_name,department) values(?,?)");
        List<Object> param = Lists.newArrayList();
        param.add(test.getTestName());
        param.add(test.getDepartment());
        jdbcTemplate.update(sql.toString(), param.toArray());

    }

    public List<Test> query(Test test) {
        if (test == null)
            return Lists.newArrayList();
        StringBuilder sql = new StringBuilder("select * from test where 1=1 ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(test.getDepartment())) {
            sql.append(" and department = ?");
            param.add(test.getDepartment());
        }
        if (Objects.nonNull(test.getTestName())) {
            sql.append(" and test_name = ?");
            param.add(test.getTestName());
        }
        sql.append(" order by id desc");
        List<Test> result = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<Test>(Test.class));
        return result;
    }

    public void update(Test test) {
        if (test == null || test.getId() == null)
            return;
        StringBuilder sql = new StringBuilder("update test set ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(test.getTestName())) {
            sql.append(" test_name = ?,");
            param.add(test.getTestName());
        }
        if (Objects.nonNull(test.getDepartment())) {
            sql.append(" department = ?,");
            param.add(test.getDepartment());
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" where id = ?");
        param.add(test.getId());
        jdbcTemplate.update(sql.toString(), param.toArray());
    }
}
