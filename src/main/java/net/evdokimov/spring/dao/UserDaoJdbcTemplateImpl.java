package net.evdokimov.spring.dao;

import net.evdokimov.spring.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

//@Repository
public class UserDaoJdbcTemplateImpl implements UserDao {
    private JdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void insert(User user) {
        jdbc.update("INSERT INTO users (login, password, email) VALUES (?, ?, ?)", user.getLogin(), user.getPassword(), user.getEmail());
    }

    @Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public List<User> selectAll() {
        return jdbc.query("SELECT login, password, email FROM users", new UserMapper());
    }
}
