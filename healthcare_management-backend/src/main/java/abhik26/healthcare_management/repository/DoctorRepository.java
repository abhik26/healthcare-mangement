package abhik26.healthcare_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abhik26.healthcare_management.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
}
