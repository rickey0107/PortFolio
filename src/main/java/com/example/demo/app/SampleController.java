package com.example.demo.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {

	//JDBCでクラスを操作するためのクラス。
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public SampleController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@GetMapping("/test")
	public String test(Model model) {

		String sql = "SELECT id, menu "
				+ "FROM training WHERE id = 1";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);

		model.addAttribute("title", "Training Form");
		model.addAttribute("part", map.get("part"));
		model.addAttribute("menu", map.get("menu"));
		return "test";
	}

}
