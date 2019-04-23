package DAO;

import com.google.common.collect.Lists;
import entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@SuppressWarnings("all")
public class HospitalDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void delete(String id) {
        List<Object> param = Lists.newArrayList();
        param.add(id);
        jdbcTemplate.update("delete from hospital where id = ?", param.toArray());
    }

    public List<Hospital> query(Hospital hospital) {
        if (hospital == null)
            return Lists.newArrayList();

        StringBuilder sql = new StringBuilder("select * from hospital where 1=1 ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(hospital.getCode())) {
            sql.append("and code = ? ");
            param.add(hospital.getCode());

        }
        if (Objects.nonNull(hospital.getHospitalName())) {
            sql.append(" and hospital_name = ?");
            param.add(hospital.getHospitalName());
        }
        if (Objects.nonNull(hospital.getLevel())) {
            sql.append(" and level = ? ");
            param.add(hospital.getLevel());
        }
        sql.append(" order by id desc");
        List<Hospital> result = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<Hospital>(Hospital.class));
        return result;
    }

    public void add(Hospital hospital) {
        if (hospital == null)
            return;
        List<Object> param = Lists.newArrayList();
        param.add(hospital.getCode());
        param.add(hospital.getHospitalName());
        param.add(hospital.getLevel());
        param.add(hospital.getTelephone());
        param.add(hospital.getAddress());
        jdbcTemplate.update("insert into hospital(code,hospital_name,level,telephone,address) values(?,?,?,?,?)", param.toArray());

    }

    public void update(Hospital hospital) {
        if (hospital == null || hospital.getId() == null)
            return;
        StringBuilder sql = new StringBuilder("update hospital set ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(hospital.getLevel())) {
            sql.append(" level = ?,");
            param.add(hospital.getLevel());
        }
        if (Objects.nonNull(hospital.getHospitalName())) {
            sql.append(" hospital_name = ?,");
            param.add(hospital.getHospitalName());
        }
        if (Objects.nonNull(hospital.getCode())) {
            sql.append(" code = ?,");
            param.add(hospital.getCode());
        }
        if (Objects.nonNull(hospital.getAddress())) {
            sql.append(" address = ?,");
            param.add(hospital.getAddress());
        }
        if (Objects.nonNull(hospital.getTelephone())) {
            sql.append(" telephone = ?,");
            param.add(hospital.getTelephone());
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" where id = ?");
        param.add(hospital.getId());
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

}
