package DAO;

import com.google.common.collect.Lists;
import entity.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@SuppressWarnings("all")
public class DiseaseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void delete(String id) {
        List<Object> param = Lists.newArrayList();
        param.add(id);
        jdbcTemplate.update("delete from disease where id = ?", param.toArray());

    }

    public List<Disease> query(Disease disease) {
        if (disease == null)
            return Lists.newArrayList();
        StringBuilder sql = new StringBuilder("select * from disease where 1 = 1 ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull((disease.getCode()))) {
            sql.append(" and code = ? ");
            param.add(disease.getCode());
        }
        if (Objects.nonNull(disease.getDieaseName())) {
            sql.append(" and disease_name like ?");
            param.add("%" + disease.getDieaseName() + "%");
        }
        if (Objects.nonNull(disease.getIcdCode())) {
            sql.append(" and icd_code = ?");
            param.add(disease.getIcdCode());
        }
        sql.append(" order by id desc");
        List<Disease> result = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<Disease>(Disease.class));
        return result;
    }

    public void add(Disease disease) {
        if (disease == null)
            return;
        StringBuilder sql = new StringBuilder("insert into disease(icd_code,disease_name,code) values(?,?,?)");
        List<Object> param = Lists.newArrayList();
        param.add(disease.getIcdCode());
        param.add(disease.getDieaseName());
        param.add(disease.getCode());
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public void update(Disease disease) {
        if (disease == null || disease.getId() == null)
            return;
        StringBuilder sql = new StringBuilder("update disease set");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(disease.getIcdCode())) {
            sql.append(" icd_code = ?,");
            param.add(disease.getIcdCode());
        }
        if (Objects.nonNull(disease.getDieaseName())) {
            sql.append(" disease_name = ?,");
            param.add(disease.getDieaseName());
        }
        if (Objects.nonNull(disease.getCode())) {
            sql.append(" code = ?,");
            param.add(disease.getCode());
        }

        sql.deleteCharAt(sql.length() - 1);
        sql.append(" where id = ?");
        param.add(disease.getId());

        jdbcTemplate.update(sql.toString(), param.toArray());

    }
}
