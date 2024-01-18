package ru.ld.springBoot.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.ld.springBoot.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class UserRepository {
    // * Задание. Добавить базу данных H2. Добавить обработку регистрации пользователем Mapper через параметры (в браузере)
    private final JdbcTemplate jdbc;
//    private List<User> users = new ArrayList<>();

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> getUsers() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public void add(User user) {
        String sql = "INSERT INTO userTable VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }

//    public List<User> getUsers(){
//        return users;
//    }

//    public void setUsers(List<User> users) {
//        this.users = users;
//    }

}
