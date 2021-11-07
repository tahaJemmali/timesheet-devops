package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Role;

@Repository
public interface EmployeRepository extends CrudRepository<Employee, Long>{

	@Query("SELECT e FROM Employee e where e.email=:email and e.password=:password")
    public Employee getEmployeeByEmailAndPassword(@Param("email") String login,@Param("password") String password);
}
