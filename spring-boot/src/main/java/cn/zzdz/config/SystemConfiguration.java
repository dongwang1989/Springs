package cn.zzdz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

import cn.zzdz.error.MessageSourceHolder;

@Configuration
public class SystemConfiguration {
    @Autowired
    @ConditionalOnClass(MessageSource.class)
    public void setMessageResolver(final MessageSource messageSource) {
        MessageSourceHolder.setMessageSource(messageSource);
    }
}
