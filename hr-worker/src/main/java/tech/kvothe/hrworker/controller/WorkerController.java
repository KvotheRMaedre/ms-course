package tech.kvothe.hrworker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.kvothe.hrworker.entity.Worker;
import tech.kvothe.hrworker.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping("worker")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping()
    public ResponseEntity<List<Worker>> findAll() {
        var worker = workerService.findAll();

        return ResponseEntity.ok(worker);
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<Worker> findById(@PathVariable("workerId") Long workerId) {
        var worker = workerService.findById(workerId);

        return ResponseEntity.ok(worker);
    }
}
