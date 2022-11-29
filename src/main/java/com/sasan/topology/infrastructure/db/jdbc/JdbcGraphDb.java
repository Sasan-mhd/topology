package com.sasan.topology.infrastructure.db.jdbc;

import com.sasan.topology.core.Graph;
import com.sasan.topology.core.GraphDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcGraphDb implements GraphDb {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(Graph graph){
        jdbcTemplate.update(
                "update graphs set graph = ? where id = ?",
                graph, 1);

    }

    public Graph get(){
        return jdbcTemplate.queryForObject(
                "select graph from graphs where id=?",
                (rs, rowNuM) -> (Graph) rs.getObject("graph"),
                1
        );

    }
}
