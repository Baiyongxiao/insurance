package com.web.insurance.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 枚举接口方便对枚举进行一些操作
 * @param <E>
 */
public interface IEnum<E extends Enum<E>> {

    public Integer getId();

    public String getName();

    static <T extends Enum> List<Map<String, String>> toSelect(Class<T> enumClass){
        List<Map<String, String>> list = new ArrayList();
        for (T t : enumClass.getEnumConstants()) {
            Map<String, String> map = new HashMap();
            map.put("value", ((IEnum)t).getId().toString());
            map.put("label", ((IEnum)t).getName());
            list.add(map);
        }
        return list;
    }

    static Map<String, String> toMap(IEnum[] values) {

        Map<String, String> map = new HashMap();
        for (IEnum e : values) {
            map.put(e.getId().toString(), e.getName());
        }
        return map;
    }


    public static  <T extends Enum> T getEnum(Class<T> enumClass, Integer index){
        for(T t : enumClass.getEnumConstants()) {
            if(((IEnum)t).getId().equals(index)) {
                return t;
            }
        }
        return null;
    }

    public static  <T extends Enum> String  toName(Class<T> enumClass, Integer index){
        for(T t : enumClass.getEnumConstants()) {
            if(((IEnum)t).getId().equals(index)) {
                return ((IEnum)t).getName();
            }
        }
        return index != null ? index.toString() : null;
    }


    public static  <T extends Enum> String  toName(Class<T> enumClass, String index){
        for(T t : enumClass.getEnumConstants()) {
            if(((IEnum)t).getId().toString().equals(index)) {
                return ((IEnum)t).getName();
            }
        }
        return index;
    }

    /*public static  <T extends Enum> boolean  checkRight(Class<T> enumClass, String index){
        for(T t : enumClass.getEnumConstants()) {
            if(((IEnum)t).getId().toString().equals(index)) {
                return true;
            }
        }
        throw new ServiceException(102,"枚举类型没有匹配成功");
    }*/



    /**
     * 自定义的标签，转化为-1(默认没有意义的)
     * @param enumClass
     * @param index
     * @param <T>
     * @return
     */
    public static  <T extends Enum> Integer  toId(Class<T> enumClass, String index){
        for(T t : enumClass.getEnumConstants()) {
            if(((IEnum)t).getId().toString().equals(index)) {
                return ((IEnum)t).getId();
            }
        }
        return -1;
    }

    /**
     * 名称转为为ID,没有转化为空
     * @param enumClass
     * @param name
     * @param <T>
     * @return
     */
    public static  <T extends Enum> Integer  nameToId(Class<T> enumClass, String name){
        for(T t : enumClass.getEnumConstants()) {
            if(((IEnum)t).getName().equals(name)) {
                return ((IEnum)t).getId();
            }
        }
        return null;
    }

    default E getEnum(Integer index){
        for(IEnum t : this.getClass().getEnumConstants()){
            if(t.getId().equals(index)) {
                return (E)t;
            }
        }
        return null;
    }

}
