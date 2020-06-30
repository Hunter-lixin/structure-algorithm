package com.basic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();
        UserService userService = new UserService();
        System.out.println(userService);


        Class<? extends UserController> clazz = userController.getClass();
        Field field = clazz.getDeclaredField("userService");
        String name = field.getName();
        name = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
        Method method = clazz.getDeclaredMethod(name, UserService.class);
        method.invoke(userController, userService);
        System.out.println(userController.getUserService());

    }
}
