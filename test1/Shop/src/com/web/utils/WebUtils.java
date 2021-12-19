package com.web.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2021/12/1 22:13
 * @Version 1.0
 */
public class WebUtils {
    public static void changeParaToBean(Map m, Object bean) {
        try {
            BeanUtils.populate(bean, m);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
