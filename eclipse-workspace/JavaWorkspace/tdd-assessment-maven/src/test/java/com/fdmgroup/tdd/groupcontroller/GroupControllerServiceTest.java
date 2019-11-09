package com.fdmgroup.tdd.groupcontroller;

import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GroupControllerServiceTest {
	private DatabaseReader mockDatabaseReader;
	private DatabaseWriter mockDatabaseWriter;
	private String traineeUsername;
	private Trainee trainee;

	@Before
	public void setUp() throws Exception {
		mockDatabaseReader = mock(DatabaseReader.class);
		mockDatabaseWriter = mock(DatabaseWriter.class);
		trainee = new Trainee();
	}
	
	@Test
	public void whenAskingTheServiceImplementationForAllTraineesTheTraineesShouldBeReadFromADatabaseReaderObject() {
		PersonRepo group = new PersonRepo(mockDatabaseReader);
		group.getAllTrainees();
		verify(mockDatabaseReader).readGroup();
	}
	
	@Test
	public void whenRemovingATraineeByUsernameADatabaseWriterObjectShouldBeCalledFromTheServiceImplementation() {
		PersonRepo repository = new PersonRepo(mockDatabaseWriter);
		repository.removeTraineeByUsername(traineeUsername);
		verify(mockDatabaseWriter).deleteTraineeByUsername(traineeUsername);
	}
	
	@Test
	public void whenAddingATraineeThroughTheServiceImplementationTheTraineeShouldBePassedToADatabaseWriterObject() {
		PersonRepo repository = new PersonRepo(mockDatabaseWriter);
		repository.addTrainee(trainee);
		verify(mockDatabaseWriter).addTrainee(trainee);
	}
	
	
}