package com.feature.learn.stack;//package com.quick.stack;
//
///**
// * 方法区是存放虚拟机加载类的相关信息，如类、静态变量和常量，大小由-XX:PermSize和-XX:MaxPermSize来调节，类太多有可能撑爆永久带
// */
//public class MethodAreaOOM {
//
//    static class OOMOjbect{}
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        while(true){
//            Enhancer eh = new Enhancer();
//            eh.setSuperclass(OOMOjbect.class);
//            eh.setUseCache(false);
//            eh.setCallback(new MethodInterceptor(){
//
//                @Override
//                public Object intercept(Object arg0, Method arg1,
//                        Object[] arg2, MethodProxy arg3) throws Throwable {
//                    // TODO Auto-generated method stub
//                    return arg3.invokeSuper(arg0, arg2);
//                }
//
//            });
//            eh.create();
//        }
//    }
//
//}