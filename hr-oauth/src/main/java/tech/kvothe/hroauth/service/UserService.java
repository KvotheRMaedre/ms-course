package tech.kvothe.hroauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.kvothe.hroauth.entity.User;
import tech.kvothe.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

    private final UserFeignClient userFeignClient;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public User findByEmail(String email) {
        User user = userFeignClient.findUserByEmail(email).getBody();
        if (user == null) {
            logger.error("Email not found: {}", email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: {}", email);
        return user;
    }

    public User findById(Long id) {
        User user = userFeignClient.findUserById(id).getBody();
        if (user == null) {
            logger.error("Email not found: {}", id);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: {}", id);
        return user;
    }

}
