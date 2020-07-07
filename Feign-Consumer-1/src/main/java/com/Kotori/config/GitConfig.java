package com.Kotori.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/***
 * 要读取配置中心的内容，需要增加相关的配置类，Spring Cloud Config
 * 读取配置中心内容的方式和读取本地配置文件中的配置是一模一样的。
 * 可以通过 @Value 或 @ConfigurationProperties 来获取
 */
@Component
@RefreshScope // 自动刷新配置  http://localhost:8001/actuator/refresh
public class GitConfig {
    @Bean
    public GitConfig getConfig() {
        return new GitConfig();
    }

    @Value("${data.env}")
    private String env;

    @Value("${data.user.username}")
    private String username;

    @Value("${data.user.password}")
    private String password;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "GitConfig{" +
                "env='" + env + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
