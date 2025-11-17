package tech.kvothe.hrworker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    @Value("${test.config}")
    private String testConfig;

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    private final Environment env;

    private final WorkerService workerService;

    public WorkerController(Environment env, WorkerService workerService) {
        this.env = env;
        this.workerService = workerService;
    }

    @GetMapping("/config")
    public ResponseEntity<Void> findConfig() {
        logger.info("CONFIG = " + testConfig);
        var worker = workerService.findAll();

        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Worker>> findAll() {
        var worker = workerService.findAll();

        return ResponseEntity.ok(worker);
    }

    @GetMapping("/{workerId}")

    public ResponseEntity<Worker> findById(@PathVariable("workerId") Long workerId) {

        logger.info("PORT = " + env.getProperty("local.server.port"));
        var worker = workerService.findById(workerId);

        return ResponseEntity.ok(worker);
    }
}
