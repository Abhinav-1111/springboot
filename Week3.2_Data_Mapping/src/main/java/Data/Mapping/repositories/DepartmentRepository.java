package Data.Mapping.repositories;

import Data.Mapping.entities.DepartmentEntity;
import Data.Mapping.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByManager(EmployeeEntity employeeEntity);
}
