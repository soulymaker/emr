package DAO;

import com.google.common.collect.Lists;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@SuppressWarnings("all")
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void update(User user) {
        if (user == null || !Objects.nonNull(user.getPassword()) || !Objects.nonNull(user.getUserId())) {
            return;
        }
        List<Object> param = Lists.newArrayList();
        param.add(user.getPassword());
        param.add(user.getUserId());
        jdbcTemplate.update("update user set password = ? where user_id = ?", param.toArray());
    }

    public List<User> query(User user) {
        if (user == null) {
            return Lists.newArrayList();
        }
        StringBuilder sql = new StringBuilder("select * from user where 1=1 ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(user.getUserId())) {
            sql.append(" and user_id = ? ");
            param.add(user.getUserId());
        }
        if (Objects.nonNull(user.getUserType())) {
            sql.append(" and user_type = ?");
            param.add(user.getUserType());
        }
        sql.append(" order by id desc");
        return jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<User>(User.class));
    }


    public User login(User user) {
        if (user == null) {
            return null;
        }
        StringBuilder sql = new StringBuilder("select * from user where 1=1 ");
        List<Object> param = Lists.newArrayList();
        if (Objects.nonNull(user.getUserId())) {
            sql.append(" and user_id = ? ");
            param.add(user.getUserId());
        }
        if (Objects.nonNull(user.getPassword())) {
            sql.append(" and password = ?");
            param.add(user.getPassword());
        }
        return jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<User>(User.class)).get(0);
    }

    public void delete(String userId) {
        List<Object> param = Lists.newArrayList();
        param.add(userId);
        jdbcTemplate.update("delete from user where user_id = ?", param.toArray());
    }

    public void add(User user) {
        if (user == null || !Objects.nonNull(user.getUserType()) || !Objects.nonNull(user.getUserId()) || !Objects.nonNull(user.getPassword())) {
            return;
        }
        List<Object> param = Lists.newArrayList();
        param.add(user.getUserId());
        param.add(user.getPassword());
        param.add(user.getUserType());
        jdbcTemplate.update(" insert into user(user_id,password,user_type) values(?,?,?)", param.toArray());

    }

}
