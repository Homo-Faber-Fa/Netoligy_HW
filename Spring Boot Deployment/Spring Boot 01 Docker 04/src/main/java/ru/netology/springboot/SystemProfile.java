package ru.netology.springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import ru.netology.springboot.config.JavaConfig;


@ConditionalOnBean(JavaConfig.class)
@Component
public interface SystemProfile {
    String getProfile();
}
