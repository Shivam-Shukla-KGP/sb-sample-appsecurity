package in.jp.trial.sb.sample.security;

import in.jp.trial.sb.sample.security.config.SecurityConfiguration;
import in.jp.trial.sb.sample.security.config.SecurityDatasourceConfig;
import org.springframework.context.annotation.Import;

@Import({SecurityDatasourceConfig.class,
        SecurityConfiguration.class
})
public @interface EnableSampleSecurity {
}
