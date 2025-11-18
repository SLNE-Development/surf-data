package dev.slne.surf.data;

import dev.slne.surf.data.core.configuration.DataCacheConfiguration;
import dev.slne.surf.data.core.configuration.DataObjectMapperConfiguration;
import dev.slne.surf.data.core.configuration.DataRedisConfiguration;
import dev.slne.surf.data.core.configuration.DataWebClientConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@EnableRedisRepositories
@EnableSpringDataWebSupport
@Import({
    DataWebClientConfiguration.class,
    DataCacheConfiguration.class,
    DataObjectMapperConfiguration.class,
    DataRedisConfiguration.class
})
@EnableFeignClients
@EnableCaching
@SpringBootApplication
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DataApplication {

  @AliasFor(annotation = SpringBootApplication.class, attribute = "scanBasePackages")
  String[] scanBasePackages() default {};

  @AliasFor(annotation = EnableFeignClients.class, attribute = "basePackages")
  String[] feignBasePackages() default {};
}