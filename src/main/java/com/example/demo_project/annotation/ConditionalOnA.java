package com.example.demo_project.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented // 記錄用(javadoc)
@ConditionalOnProperty(
		name = "condition.test",
		havingValue = "AAA",
		//預設為false所以加true
		matchIfMissing = true)
public @interface ConditionalOnA {

}
