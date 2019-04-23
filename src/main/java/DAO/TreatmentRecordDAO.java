package DAO;

import com.google.common.collect.Lists;
import entity.TreatmentRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class TreatmentRecordDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void update(TreatmentRecord treatmentRecord) {
        StringBuilder sql = new StringBuilder("update treatment_record set ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(treatmentRecord.getUid())) {
            sql.append(" uid = ?,");
            param.add(treatmentRecord.getUid());
        }
        if (Objects.nonNull(treatmentRecord.getTreatmentName())) {
            sql.append("treatment_name = ?,");
            param.add(treatmentRecord.getTreatmentName());
        }
        if (Objects.nonNull(treatmentRecord.getDoctor())) {
            sql.append("doctor = ?,");
            param.add(treatmentRecord.getDoctor());
        }
        if (Objects.nonNull(treatmentRecord.getStatus())) {
            sql.append(" status = ?.");
            param.add(treatmentRecord.getStatus());
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" where id = ?");
        param.add(treatmentRecord.getId());
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public void delete(String id) {
        StringBuilder sql = new StringBuilder("delete from treatment_record where id = ?");
        List<Object> param = Lists.newArrayList();
        param.add(id);
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public List<TreatmentRecord> query(TreatmentRecord treatmentRecord) {
        if (treatmentRecord == null)
            return Lists.newArrayList();
        StringBuilder sql = new StringBuilder("select * from treatment_record where 1=1 ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(treatmentRecord.getUid())) {
            sql.append(" and uid = ? ");
            param.add(treatmentRecord.getUid());
        }
        if (Objects.nonNull(treatmentRecord.getTreatmentName())) {
            sql.append(" and treatment_name = ?");
            param.add(treatmentRecord.getTreatmentName());
        }
        if (Objects.nonNull(treatmentRecord.getDoctor())) {
            sql.append(" and doctor = ?");
            param.add(treatmentRecord.getDoctor());
        }
        sql.append(" order by id desc");
        List<TreatmentRecord> result = Lists.newArrayList();
        result = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<TreatmentRecord>(TreatmentRecord.class));
        return result;
    }

    public void add(TreatmentRecord record) {
        if (record == null)
            return;
        StringBuilder sql = new StringBuilder("insert into treatment_record(uid,treatment_name,doctor) values(?,?,?)");
        List<Object> param = Lists.newArrayList();
        param.add(record.getUid());
        param.add(record.getTreatmentName());
        param.add(record.getDoctor());

        jdbcTemplate.update(sql.toString(), param.toArray());
    }
}
