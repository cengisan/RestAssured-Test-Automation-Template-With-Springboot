package com.springboot.automation.reporter.annotation.link;

import com.springboot.automation.reporter.annotation.links.Links;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Repeatable(Links.class)
public @interface Link {

    String url() default "";

}