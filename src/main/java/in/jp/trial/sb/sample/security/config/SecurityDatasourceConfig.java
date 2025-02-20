package in.jp.trial.sb.sample.security.config;

import in.jp.trial.sb.sample.security.FileUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:security.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "classpath:security-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
@ConfigurationProperties(prefix = "application.spring.datasource")
public class SecurityDatasourceConfig {

    @Autowired
    Environment env;

    private String url;

    private String driverClassName;

    private String username;

    private String password;

    @PostConstruct
    void checkResources(){
        String defaultFilePath = "/application.properties";
        String profile = env.getProperty("spring.profiles.active");
        String profileFilePath = "/security-"+ profile + ".properties";
        FileUtils.checkFileExistAtLeastOne(defaultFilePath, profileFilePath);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
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
}
