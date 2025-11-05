package tech.kvothe.hrpayroll.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.kvothe.hrpayroll.entity.Payment;
import tech.kvothe.hrpayroll.entity.Worker;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private final RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(Long workerId, int days) {
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", workerId.toString());
        Worker worker = restTemplate.getForObject(workerHost + "/worker/{id}", Worker.class, uriVariable);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
