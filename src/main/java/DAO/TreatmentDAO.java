package DAO;

import com.google.common.collect.Lists;
import entity.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class TreatmentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void update(Treatment treatment) {
        StringBuilder sql = new StringBuilder("update treatment set treatment = ? where id = ?");
        List<Object> param = Lists.newArrayList();
        param.add(treatment.getTreatmentName());
        param.add(treatment.getId());
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public void add(String treatmentName) {
        StringBuilder sql = new StringBuilder("insert into treatment(treatment_name) values(?)");
        List<Object> param = Lists.newArrayList();
        param.add(treatmentName);
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public void delete(String id) {
        StringBuilder sql = new StringBuilder("delete from treatment where id = ?");
        List<Object> param = Lists.newArrayList();
        param.add(id);
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public List<Treatment> query(Treatment treatment) {
        if (treatment == null) {
            return Lists.newArrayList();
        }
        StringBuilder sql = new StringBuilder(" select  * from treatment where 1=1  ");
        List<Object> param = Lists.newArrayList();

        if (Objects.nonNull(treatment.getTreatmentName())) {
            sql.append(" and treatment_name like ?");
            param.add("%" + treatment.getTreatmentName() + "%");
        }
        sql.append(" order by id desc");
        List<Treatment> result = Lists.newArrayList();
        result = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<Treatment>(Treatment.class));

        return result;
    }


}
