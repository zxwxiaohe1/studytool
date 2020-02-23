package com.study.en.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author heyong
 */
public class JacksonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * @param obj Object类型
     * @return String对象
     * @throws IOException
     */
    public static String bean2Json(Object obj) {
        StringWriter sw = null;
        JsonGenerator gen = null;
        try {
            sw = new StringWriter();
            gen = new JsonFactory().createGenerator(sw);
            mapper.writeValue(gen, obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                gen.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sw.toString();
    }

    /**
     * @param jsonStr  String类型
     * @param objClass Class<T>
     * @return T泛型对象
     * @throws IOException
     * @throws JsonParseException
     * @throws JsonMappingException
     */
    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        try {
            return mapper.readValue(jsonStr, objClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json转换为复杂集合对象
     *
     * @param jsonStr
     * @param collectionClass
     * @param elementClasses
     * @return
     * @Title: json2JavaType
     * @Description:
     * @return: T
     */
    public static <T> T json2JavaType(String jsonStr, Class<?> collectionClass, Class<?>... elementClasses) {
        if (StringUtils.isEmpty(jsonStr) || collectionClass == null || elementClasses.length <= 0) {
            return null;
        }
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, elementClasses);
            return collectionClass.equals(String.class) ? (T) jsonStr : mapper.readValue(jsonStr, javaType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
