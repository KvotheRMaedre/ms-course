package tech.kvothe.hrpayroll.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.kvothe.hrpayroll.entity.Payment;
import tech.kvothe.hrpayroll.service.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workId, @PathVariable("days") int days) {
        var payment = paymentService.getPayment(workId, days);
        return ResponseEntity.ok(payment);
    }
}
