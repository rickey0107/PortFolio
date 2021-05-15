package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Training;

public interface TrainingService {

	void save(Training training);

	List<Training> getAll();

}
