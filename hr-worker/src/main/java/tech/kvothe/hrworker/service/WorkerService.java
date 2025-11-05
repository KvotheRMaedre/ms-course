package tech.kvothe.hrworker.service;

import org.springframework.stereotype.Service;
import tech.kvothe.hrworker.entity.Worker;
import tech.kvothe.hrworker.repository.WorkerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    public Worker findById(Long id) {
        return workerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
