package tech.kvothe.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import tech.kvothe.hroauth.entities.User;

@Component
@FeignClient(name = "hr-user", path = "/user")
public interface UserFeignClient {

	@GetMapping("/email/{email}")
	public ResponseEntity<User> findUserByEmail(@PathVariable("email") String email);
}
