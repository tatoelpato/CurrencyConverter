package com.fdmgroup.tdd.groupcontroller;

import java.util.HashMap;
import java.util.Map;

public class PersonRepo implements GroupControllerService {
	
	private Map<String, Trainee> read = new HashMap<>();
	private DatabaseReader readPeople;
	private DatabaseWriter writePeople;

	public PersonRepo(DatabaseReader mockDatabaseReader) {
		this.readPeople = mockDatabaseReader;
	}

	public PersonRepo(DatabaseWriter mockDatabaseWriter) {
		this.writePeople = mockDatabaseWriter;
	}

	@Override
	public Map<String, Trainee> getAllTrainees() {
		this.read = readPeople.readGroup();
		return null;
	}

	@Override
	public void addTrainee(Trainee trainee) {
		writePeople.addTrainee(trainee);
	}

	@Override
	public void removeTraineeByUsername(String traineeUsername) {
		writePeople.deleteTraineeByUsername(traineeUsername);
	}

}
