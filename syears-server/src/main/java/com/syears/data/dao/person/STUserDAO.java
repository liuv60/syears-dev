package com.syears.data.dao.person;

import com.syears.commons.vo.person.STUserVO;
import com.syears.controllers.params.person.UserParams; 

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

public interface STUserDAO {
	
    String SEQ_STUSER = "STUSER";

    STUserVO insert(STUserVO userEntity);  //插入用户
    
    STUserVO getUser(UserParams params);   //获取用户信息
    
    int deleteUser(String username);  //删除用户，逻辑型
    
    
    STUserVO findUserById(String userid);  //通过用户编号查找用户
    
    STUserVO findUserByName(String username); //用户用户名称查找用户
    
    int countAll();  //统计所有用户
    
    int countUser(String username); //统计用户数，判断是否有该用户
    
    int updatePassword(UserParams params);  //修改密码
    
    int updateUserName(String username);    //修改用户名称
    
    

    default <E, T> E convertToEntity(T t, Class<E> entityClass, Class<T> voClass) {
        try {
            E entity = entityClass.newInstance();

            Map<String, Field> entityFieldMap = Arrays.stream(entityClass.getDeclaredFields())
                    .map(field -> {
                        field.setAccessible(true);
                        return field;
                    })
                    .collect(Collectors.toMap(Field::getName, field -> field));

            Field[] fields = voClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (Objects.equals(BigDecimal.class, entityFieldMap.get(field.getName()).getType())) {
                    entityFieldMap.get(field.getName())
                            .set(entity, BigDecimal.valueOf((Double) field.get(t)));
                } else if (Objects.equals(Date.class, field.getType())) {
                    if (Objects.equals(Timestamp.class, entityFieldMap.get(field.getName()).getType())) {
                        entityFieldMap.get(field.getName()).set(entity, Timestamp.from(((Date) field.get(t)).toInstant()));
                    } else {
                        entityFieldMap.get(field.getName()).set(entity, field.get(t));
                    }
                } else {
                    entityFieldMap.get(field.getName()).set(entity, field.get(t));
                }

            }

            return entity;
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return null;
    }

    default <E, T> T convertToVO(E entity, Class<E> entityClass, Class<T> voClass) {
    	if(entity==null){
    		return null;
    	}
        try {
            T t = voClass.newInstance();

            Map<String, Field> voFieldMap = Arrays.stream(voClass.getDeclaredFields())
                    .map(field -> {
                        field.setAccessible(true);
                        return field;
                    })
                    .collect(Collectors.toMap(Field::getName, field -> field));

            Field[] fields = entityClass.getDeclaredFields();
            for (Field field : fields) {
                if (voFieldMap.containsKey(field.getName())) {
                    field.setAccessible(true);
                    if (Objects.equals(BigDecimal.class, field.getType())) {
                        voFieldMap.get(field.getName())
                                .set(t, ((BigDecimal) field.get(entity)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    } else {
                        voFieldMap.get(field.getName()).set(t, field.get(entity));
                    }

                }
            }

            return t;
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return null;
    }

    default <E, T> List<E> convertToEntityList(List<T> tList, Class<E> entityClass, Class<T> voClass) {
        return tList.stream().map(t -> convertToEntity(t, entityClass, voClass)).filter(e -> e != null).collect(Collectors.toList());
    }

    default <E, T> List<T> convertToVOList(List<E> eList, Class<E> entityClass, Class<T> voClass) {
        return eList.stream().map(e -> convertToVO(e, entityClass, voClass)).filter(t -> t != null).collect(Collectors.toList());
    }


}
