package tech.kvothe.hrpayroll.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.kvothe.hrpayroll.entity.Payment;
import tech.kvothe.hrpayroll.entity.Worker;
import tech.kvothe.hrpayroll.feignclients.WorkerFeignClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(Long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
