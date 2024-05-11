package com.springboot.automation.reporter.annotation.links;

import com.springboot.automation.reporter.annotation.link.Link;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Links {

    Link[] value();
}
