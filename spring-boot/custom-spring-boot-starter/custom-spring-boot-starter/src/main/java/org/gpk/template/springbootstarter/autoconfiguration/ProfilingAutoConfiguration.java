package org.gpk.template.springbootstarter.autoconfiguration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(ProfilingProperties.class)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
// @AutoConfigureBefore(...)
// @ConditionalOnClass({...})
public class ProfilingAutoConfiguration {
    @Autowired
    private ProfilingProperties properties;

    private long thresholdNs = 0;

    @PostConstruct
    private void init() {
        try {
            thresholdNs = Long.parseLong(properties.getThresholdNs());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public BeanPostProcessor profilingBeanPostProcessor() {
        return new BeanPostProcessor() {
            private Map<String, Class<?>> beansToBeProfiled = new HashMap<>();
            private List<Class<? extends Annotation>> annotations = Arrays.asList(
                    Controller.class,
                    RestController.class
            );

            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                Class<?> beanClass = bean.getClass();
                if (checkIfShouldBeProcessed(beanClass)) {
                    beansToBeProfiled.put(beanName, beanClass);
                }
                return bean;
            }

            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                Class<?> beanClass = beansToBeProfiled.get(beanName);
                if (beanClass != null) {
                    try {
                        beanClass.getConstructor();
                    } catch (NoSuchMethodException e) {
                        // cglib requires a no-args constructor
                        return bean;
                    }

                    System.out.println("proxying bean `" + beanName + "` of class `" + beanClass + "`");

                    Enhancer enhancer = new Enhancer();
                    enhancer.setSuperclass(beanClass);
                    enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
                        long start = System.nanoTime();
                        Object retVal = method.invoke(bean, args);
                        long time = System.nanoTime() - start;
                        if (time > thresholdNs) {
                            System.out.println("Class `" + beanClass + "`, method `" + method.getName() + "`" +
                                    " - " + time + "ns");
                        }
                        return retVal;
                    });
                    return beanClass.cast(enhancer.create());
                }
                return bean;
            }

            private boolean checkIfShouldBeProcessed(Class<?> aClass) {
                for (Class<? extends Annotation> annotation : annotations) {
                    if (aClass.isAnnotationPresent(annotation)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }
}
