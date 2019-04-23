package DAO;

import com.google.common.collect.Lists;
import entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class StaffDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void delete(String id) {
        StringBuilder sql = new StringBuilder("delete from staff where id = ?");
        List<Object> param = Lists.newArrayList();
        param.add(id);
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public void add(Staff staff) {
        if (staff == null)
            return;
        StringBuilder sql = new StringBuilder("insert into staff(job_number,staff_name,type,grade,hospital,department_name) values(?,?,?,?,?,?)");
        List<Object> param = Lists.newArrayList();
        param.add(staff.getJobNumber());
        param.add(staff.getStaffName());
        param.add(staff.getType());
        param.add(staff.getGrade());
        param.add(staff.getHospital());
        param.add(staff.getDepartmentName());
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public void update(Staff staff) {
        if (staff == null || staff.getId() == null)
            return;
        StringBuilder sql = new StringBuilder("update staff set ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(staff.getType())) {
            sql.append(" type = ?,");
            param.add(staff.getType());
        }
        if (Objects.nonNull(staff.getJobNumber())) {
            sql.append(" job_number = ?,");
            param.add(staff.getJobNumber());
        }
        if (Objects.nonNull(staff.getStaffName())) {
            sql.append(" staff_name = ?,");
            param.add(staff.getStaffName());
        }
        if (Objects.nonNull(staff.getGrade())) {
            sql.append(" grade = ?,");
            param.add(staff.getGrade());
        }
        if (Objects.nonNull(staff.getHospital())) {
            sql.append(" hospital = ?,");
            param.add(staff.getHospital());
        }
        if (Objects.nonNull(staff.getDepartmentName())) {
            sql.append(" department_name = ?,");
            param.add(staff.getDepartmentName());
        }
        sql.deleteCharAt(sql.length() - 1);
        param.add(staff.getId());
        sql.append(" where id = ?");
        jdbcTemplate.update(sql.toString(), param.toArray());
    }

    public List<Staff> query(Staff staff) {
        if (staff == null)
            return Lists.newArrayList();
        StringBuilder sql = new StringBuilder(" select * from staff where 1=1 ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(staff.getJobNumber())) {
            sql.append(" and job_number = ? ");
            param.add(staff.getJobNumber());
        }
        if (Objects.nonNull(staff.getStaffName())) {
            sql.append(" and staff_name = ? ");
            param.add(staff.getStaffName());
        }
        if (Objects.nonNull(staff.getType())) {
            sql.append(" and type = ? ");
            param.add(staff.getType());
        }
        if (Objects.nonNull(staff.getGrade())) {
            sql.append(" and grade = ? ");
            param.add(staff.getGrade());
        }
        if (Objects.nonNull(staff.getHospital())) {
            sql.append(" and hospital = ? ");
            param.add(staff.getHospital());
        }
        if (Objects.nonNull(staff.getDepartmentName())) {
            sql.append(" and department_name = ? ");
            param.add(staff.getDepartmentName());
        }
        sql.append(" order by id desc");
        List<Staff> result = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<Staff>(Staff.class));
        return result;

    }
}
