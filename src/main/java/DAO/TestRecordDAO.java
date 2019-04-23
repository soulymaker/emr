package DAO;

import com.google.common.collect.Lists;
import entity.TestRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class TestRecordDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TestRecord> query(TestRecord testRecord) {
        if (testRecord == null)
            return Lists.newArrayList();
        StringBuilder sql = new StringBuilder("select * from test_record where 1=1 ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(testRecord.getDepartment())) {
            sql.append(" and department = ?");
            param.add(testRecord.getDepartment());
        }
        if (Objects.nonNull(testRecord.getTestName())) {
            sql.append(" and test_name = ?");
            param.add(testRecord.getTestName());
        }
        if (Objects.nonNull(testRecord.getUid())) {
            sql.append(" and uid = ?");
            param.add(testRecord.getUid());
        }
        sql.append(" order by id desc");
        List<TestRecord> result = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<TestRecord>(TestRecord.class));
        return result;
    }

    public void delete(String id) {
        List<Object> param = Lists.newArrayList();
        param.add(id);
        jdbcTemplate.update("delete from test_record where id = ?", param.toArray());
    }

    public void update(TestRecord testRecord) {
        if (testRecord == null || testRecord.getId() == null)
            return;
        StringBuilder sql = new StringBuilder("update test_record set ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(testRecord.getUid())) {
            sql.append(" uid = ?,");
            param.add(testRecord.getUid());
        }
        if (Objects.nonNull(testRecord.getTestName())) {
            sql.append(" test_name = ?,");
            param.add(testRecord.getTestName());

        }
        if (Objects.nonNull(testRecord.getDepartment())) {
            sql.append(" department = ?.");
            param.add(testRecord.getDepartment());
        }
        if (Objects.nonNull(testRecord.getStatus())) {
            sql.append(" status = ?.");
            param.add(testRecord.getStatus());
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" where id = ?");
        param.add(testRecord.getId());
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public void add(TestRecord record) {
        if (record == null)
            return;
        StringBuilder sql = new StringBuilder(" insert into test_record(test_name,department,uid) values(?,?,?)");
        List<Object> param = Lists.newArrayList();
        param.add(record.getTestName());
        param.add(record.getDepartment());
        param.add(record.getUid());
        jdbcTemplate.update(sql.toString(), param.toArray());

    }
}
