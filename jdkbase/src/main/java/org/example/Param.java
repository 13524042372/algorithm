package org.example;

import java.lang.annotation.*;

/*@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD,ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER} )*/
@Target(value = {ElementType.METHOD,ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Param {
}
