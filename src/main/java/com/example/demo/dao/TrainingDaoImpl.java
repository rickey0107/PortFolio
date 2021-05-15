package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Training;

@Repository //データベース操作をするクラスだとDIコンテナに知らせる。
public class TrainingDaoImpl implements TrainingDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public TrainingDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertTraining(Training training) {
		jdbcTemplate.update("INSERT INTO training(part, menu, datetime) VALUES(?, ?, ?)",
				training.getPart(), training.getMenu(), training.getDatetime());
	}

	@Override
	public List<Training> getAll() {
		String sql = "SELECT id, part, menu, datetime FROM training";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Training> list = new ArrayList<Training>();
		for(Map<String, Object> result : resultList) {
			Training training = new Training();
			training.setId      ((int)       result.get("id"));
			training.setPart    ((String)    result.get("part"));
			training.setMenu    ((String)    result.get("menu"));
			training.setDatetime(((Timestamp)result.get("datetime")).toLocalDateTime());
			list.add(training);
		}
		return list;
	}

}
