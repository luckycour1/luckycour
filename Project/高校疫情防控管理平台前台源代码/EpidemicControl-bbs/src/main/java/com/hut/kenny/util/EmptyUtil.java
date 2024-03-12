package com.hut.kenny.util;

import java.util.Collection;
import java.util.Map;

/**
 * 用来判断常用的 集合、对象以及字符串非空
 * 非空有两个含义：
 *  对于集合： ！= null && length != 0
 *  对于对象： ! = null
 *  对于字符串： != null && length != 0
 * @Title: EmptyUtil
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/12 15:10
 */
public class EmptyUtil {
    /**
     * 判断传入的对象是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj){
        if(null == obj) return true;
        if(obj instanceof CharSequence){    //判断字符串是否为null或""
            CharSequence charSequence = (CharSequence)obj;
            return charSequence.length() == 0;
        }
        if(obj instanceof Collection){
            return ((Collection)obj).isEmpty();
        }
        if(obj instanceof Map){
            return ((Map)obj).isEmpty();
        }
        //如果传入的对象是对象数组（注意：数组元素也有可能是上面碰到的类型，甚至有可能也是一个对象数组）
        if(obj instanceof  Object[]){
            Object[] objArray = (Object[])obj;
            if(objArray.length == 0) return true;
            //如果数组有有元素，那么每个元素都需要重复上面的判断 - 递归调用
            for(int i = 0; i < objArray.length; i++){
                if(!isEmpty(objArray[i])){
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean nonEmpty(Object obj){
        return !isEmpty(obj);
    }
}
