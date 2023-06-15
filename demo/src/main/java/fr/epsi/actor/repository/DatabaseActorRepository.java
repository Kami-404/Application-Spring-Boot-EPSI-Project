package fr.epsi.actor.repository;

import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import fr.epsi.actor.model.Actor;

public class DatabaseActorRepository implements ActorRepository {

    private static final String jdbcURL = "jdbc:postgresql://epsi.simplearetenir.com:5432/sakila";

    private DataSource datasource;

    public void setDataSource(DataSource ds) {
        this.datasource = ds;
    }

    @Override
    public List<Actor> listActor() {

        String query = "select * from actor";

        JdbcTemplate template = new JdbcTemplate(datasource);
        return template.query(query, (ResultSet rs, int rowNum) -> new Actor(rs.getString("last_name"),
                rs.getString("last_name"), rs.getInt("actor_id")));
    }

}
