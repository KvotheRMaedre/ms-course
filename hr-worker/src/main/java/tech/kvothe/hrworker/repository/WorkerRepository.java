package tech.kvothe.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kvothe.hrworker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
