package com.ongidideveloper.ToDoApp;

import com.ongidideveloper.ToDoApp.model.Employee;
import com.ongidideveloper.ToDoApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public  void run(String ... Args) throws Exception{
		Employee employee1=new Employee();
		Employee employee2=new Employee();

		employee1.setEmailID("Ongidigeofrey@gmail.com");
		employee1.setFirstName("Geofrey");
		employee1.setLastName("Ongidi");


		employee2.setEmailID("bakhuyamilka@gmail.com");
		employee2.setFirstName("Milka");
		employee2.setLastName("Wanga");

		employeeRepository.save(employee1);
		employeeRepository.save(employee2);


	}


}
