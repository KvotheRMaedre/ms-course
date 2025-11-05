package tech.kvothe.hrpayroll.service;

import org.springframework.stereotype.Service;
import tech.kvothe.hrpayroll.entity.Payment;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days) {
        return new Payment("Kvothe", 200.0, days);
    }
}
