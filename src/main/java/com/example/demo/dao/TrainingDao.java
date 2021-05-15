package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Training;

public interface TrainingDao {

	void insertTraining(Training training);

	List<Training> getAll();

}
