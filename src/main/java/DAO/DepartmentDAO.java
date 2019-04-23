package DAO;

import com.google.common.collect.Lists;
import entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@SuppressWarnings("all")
public class DepartmentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void delete(String id) {
        List<Object> param = Lists.newArrayList();
        param.add(id);
        jdbcTemplate.update("delete from department where id = ?", param.toArray());
    }

    public List<Department> query(Department department) {
        if (department == null)
            return Lists.newArrayList();
        StringBuilder sql = new StringBuilder("select *  from department where 1 = 1 ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(department.getHospitalName())) {
            sql.append(" and hospital_name like ?");
            param.add("%" + department.getHospitalName() + "%");
        }
        if (Objects.nonNull(department.getCode())) {
            sql.append(" and code = ?");
            param.add(department.getCode());

        }
        if (Objects.nonNull(department.getDepartmentName())) {
            sql.append(" and department_name = ?");
            param.add(department.getDepartmentName());
        }
        sql.append(" order by id desc");
        List<Department> result = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<Department>(Department.class));
        return result;
    }

    public void add(Department department) {
        if (department == null)
            return;
        List<Object> param = Lists.newArrayList();
        param.add(department.getDepartmentName());
        param.add(department.getCode());
        param.add(department.getHospitalName());
        param.add(department.getAddress());

        jdbcTemplate.update("insert into department(department_name,code,hospital_name,address) values(?,?,?,?)", param.toArray());
    }

    public void update(Department department) {
        if (department == null || department.getId() == null)
            return;
        StringBuilder sql = new StringBuilder("update department set ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(department.getCode())) {
            sql.append("code = ?, ");
            param.add(department.getCode());
        }
        if (Objects.nonNull(department.getDepartmentName())) {
            sql.append("department_name = ?,");
            param.add(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getAddress())) {
            sql.append("address = ?,");
            param.add(department.getAddress());
        }
        if (Objects.nonNull(department.getHospitalName())) {
            sql.append("hospital_name = ?,");
            param.add(department.getHospitalName());
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" where id = ?");
        param.add(department.getId());
        jdbcTemplate.update(sql.toString(), param.toArray());
    }
}
