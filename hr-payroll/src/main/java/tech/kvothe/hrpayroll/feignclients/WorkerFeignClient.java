package tech.kvothe.hrpayroll.feignclients;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.kvothe.hrpayroll.entity.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/worker")
@LoadBalancerClient()
public interface WorkerFeignClient {

    @LoadBalanced
    @GetMapping("/{workerId}")
    ResponseEntity<Worker> findById(@PathVariable("workerId") Long workerId);

}
