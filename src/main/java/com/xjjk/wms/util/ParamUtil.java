package com.xjjk.wms.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ParamUtil {
    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean strEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean strNotEmpty(String str) {
        return !strEmpty(str);
    }

    /**
     * 判断对象是否为空
     *
     * @param object
     * @return
     */
    public static boolean objectEmpty(Object object) {
        return null == object;
    }

    public static boolean objectNotEmpty(Object object) {
        return null != object;
    }

    /**
     * 集合判断是否为空
     *
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> boolean listEmpty(Collection<T> collection) {
        return !listNotEmpty(collection);
    }

    public static <T> boolean listNotEmpty(Collection<T> collection) {
        if (collection != null) {
            Iterator<T> iterator = collection.iterator();
            if (iterator != null) {
                while (iterator.hasNext()) {
                    Object next = iterator.next();
                    if (next != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 集合MAP是否为空
     *
     * @param map 使用泛型，可以传递不同的类型参数
     * @return
     */
    public static <T> boolean mapEmpty(Map<T, T> map) {
        return !mapNotEmpty(map);
    }

    public static <T> boolean mapNotEmpty(Map<T, T> map) {
        return map != null && !map.isEmpty();
    }

    /**
     * 各类型数组判断不为空
     *
     * @param
     * @return
     */
    public static boolean arrEmpty(byte[] t) {
        return !arrNotEmpty(t);
    }

    public static boolean arrEmpty(short[] t) {
        return !arrNotEmpty(t);
    }

    public static boolean arrEmpty(int[] t) {
        return !arrNotEmpty(t);
    }

    public static boolean arrEmpty(long[] t) {
        return !arrNotEmpty(t);
    }

    public static boolean arrEmpty(String[] t) {
        return !arrNotEmpty(t);
    }

    public static boolean arrEmpty(Object[] t) {
        return !arrNotEmpty(t);
    }

    public static boolean arrNotEmpty(byte[] t) {
        return t != null && t.length > 0;
    }

    public static boolean arrNotEmpty(short[] t) {
        return t != null && t.length > 0;
    }

    public static boolean arrNotEmpty(int[] t) {
        return t != null && t.length > 0;
    }

    public static boolean arrNotEmpty(long[] t) {
        return t != null && t.length > 0;
    }

    public static boolean arrNotEmpty(String[] t) {
        return t != null && t.length > 0;
    }

    public static boolean arrNotEmpty(Object[] t) {
        return t != null && t.length > 0;
    }

}
