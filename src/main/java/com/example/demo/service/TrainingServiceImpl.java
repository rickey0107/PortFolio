package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TrainingDao;
import com.example.demo.entity.Training;

@Service //DIコンテナで自動的にシングルトンとしてインスタンス化。
public class TrainingServiceImpl implements TrainingService {

	private final TrainingDao dao;

	@Autowired TrainingServiceImpl(TrainingDao dao){
		this.dao = dao;
	}

	@Override
	public void save(Training training) {
		dao.insertTraining(training);
	}

	@Override
	public List<Training> getAll() {
		return dao.getAll();
	}

}
