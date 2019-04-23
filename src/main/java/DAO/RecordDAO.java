package DAO;

import com.google.common.collect.Lists;
import entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class RecordDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void delete(String id) {
        StringBuilder sql = new StringBuilder("delete from record where id = ?");
        List<Object> param = Lists.newArrayList();
        param.add(id);
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public void add(Record record) {
        if (record == null)
            return;
        StringBuilder sql = new StringBuilder("insert into record(uid,patient_name,doctor_name,consultation_date,description,disease_type,conclusion,visit_type) values(?,?,?,?,?,?,?,?)");
        List<Object> param = Lists.newArrayList();
        param.add(record.getUid());
        param.add(record.getPatientName());
        param.add(record.getDoctorName());
        param.add(record.getConsultationDate());
        param.add(record.getDescription());
        param.add(record.getDiseaseType());
        param.add(record.getConclusion());
        param.add(record.getVisitType());
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public void update(Record record) {
        if (record == null || record.getId() == null)
            return;
        StringBuilder sql = new StringBuilder("update record set ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(record.getUid())) {
            sql.append(" uid = ?,");
            param.add(record.getUid());
        }
        if (Objects.nonNull(record.getPatientName())) {
            sql.append(" patient_name = ?,");
            param.add(record.getPatientName());
        }
        if (Objects.nonNull(record.getDoctorName())) {
            sql.append(" doctor_name = ?,");
            param.add(record.getDoctorName());
        }
        if (Objects.nonNull(record.getUid())) {
            sql.append(" uid = ?,");
            param.add(record.getUid());
        }
        if (Objects.nonNull(record.getConsultationDate())) {
            sql.append(" consultation_date = ?,");
            param.add(record.getConsultationDate());
        }
        if (Objects.nonNull(record.getTest())) {
            sql.append(" test = ?,");
            param.add(record.getTest());
        }
        if (Objects.nonNull(record.getDescription())) {
            sql.append(" description = ?,");
            param.add(record.getDescription());
        }
        if (Objects.nonNull(record.getDiseaseType())) {
            sql.append(" disease_type = ?,");
            param.add(record.getDiseaseType());
        }
        if (Objects.nonNull(record.getConclusion())) {
            sql.append(" conclusion = ?,");
            param.add(record.getConclusion());
        }
        if (Objects.nonNull(record.getTreatment())) {
            sql.append(" treatment = ?,");
            param.add(record.getTreatment());
        }
        if (Objects.nonNull(record.getVisitType())) {
            sql.append(" visit_type= ?,");
            param.add(record.getVisitType());
        }
        sql.deleteCharAt(sql.length() - 1);
        param.add(record.getId());
        sql.append(" where id = ?");
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public List<Record> query(Record record) {
        if (record == null)
            return Lists.newArrayList();
        StringBuilder sql = new StringBuilder("select * from record where 1 = 1");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(record.getUid())) {
            sql.append(" and uid = ?");
            param.add(record.getUid());
        }
        if (Objects.nonNull(record.getPatientName())) {
            sql.append(" and patient_name = ?");
            param.add(record.getPatientName());
        }
        if (Objects.nonNull(record.getDoctorName())) {
            sql.append(" and doctor_name = ?");
            param.add(record.getDoctorName());
        }
        if (Objects.nonNull(record.getConsultationDate())) {
            sql.append(" and consultation_date = ?");
            param.add(record.getConsultationDate());
        }
        if (Objects.nonNull(record.getUid())) {
            sql.append(" and uid = ?");
            param.add(record.getUid());
        }
        if (Objects.nonNull(record.getDiseaseType())) {
            sql.append(" and disease_type = ?");
            param.add(record.getDiseaseType());
        }
        if (Objects.nonNull(record.getVisitType())) {
            sql.append(" and visit_type = ?");
            param.add(record.getVisitType());
        }
        sql.append(" order by id desc");
        List<Record> result = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<Record>(Record.class));
        return result;
    }
}
