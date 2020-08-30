package org.gpk.template.springbootstarter.autoconfiguration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "gpk.web.profiling")
public class ProfilingProperties {
    private String thresholdNs;
}
