package feature_learn.java_annotation;

import java.lang.annotation.*;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
@Retention( RetentionPolicy.RUNTIME )
@Documented
@Target(ElementType.FIELD)
public @interface CssSelector {
    public String selector() default "";
}
