package com.biziukov.task_2.repository;

import com.biziukov.task_2.domain.SQLQuery;
import com.biziukov.task_2.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbc;
    private final SQLQuery sql;

    public List<User> select() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User user = new User();
            user.setId(r.getInt("id"));
            user.setFirstName(r.getString("firstName"));
            user.setLastName(r.getString("LastName"));
            return user;
        };
        return jdbc.query(sql.getSelect(), userRowMapper);
    }

    public void save(User user) {
        jdbc.update(sql.getInsert(), user.getFirstName(), user.getLastName());
    }

    public void delete(int id) {
        jdbc.update(sql.getDelete(), id);
    }

    public void update(User user) {
        jdbc.update(sql.getUpdate(), user.getFirstName(), user.getLastName(), user.getId());
    }
}