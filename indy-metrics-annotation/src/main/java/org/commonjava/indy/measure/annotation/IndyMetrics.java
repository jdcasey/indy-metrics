package org.commonjava.indy.measure.annotation;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by xiabai on 3/2/17.
 */
@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
public @interface IndyMetrics {
    public enum MetricsType {
        TIMER,
        METER,
        GAUGES,
        COUNTER,
        HISTOGRAMS
    }

    @Nonbinding
    Class c() default Object.class;

    @Nonbinding
    String name() default "indy";

    MetricsType type() default MetricsType.TIMER;
}