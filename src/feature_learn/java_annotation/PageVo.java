package feature_learn.java_annotation;

import java.lang.reflect.Field;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
public class PageVo {

    @CssSelector(selector = "this is title")
    private String title;

    @CssSelector(selector = "this is name")
    private String name;

    @CssSelector(selector = "this is address")
    private String address;

    @Override
    public String toString() {
        return "PageVo{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {

        print(new PageVo());

    }

    public static <T> void print(T t) {
        Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            CssSelector cssSelector = declaredField.getAnnotation(CssSelector.class);
            String defaultValue = cssSelector.selector();
            try {
                declaredField.set(t, defaultValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(t.toString());
    }

}
