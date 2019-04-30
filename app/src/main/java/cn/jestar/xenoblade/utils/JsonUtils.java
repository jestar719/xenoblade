package cn.jestar.xenoblade.utils;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import cn.jestar.xenoblade.item.Items;

/**
 * Created by 花京院 on 2019/4/12.
 */

public class JsonUtils {
    private static Gson sGson = new Gson();

    public static String toString(Object o) {
        return sGson.toJson(o);
    }


    public static <T> List<T> readList(Reader reader, Type type) {
        return sGson.fromJson(reader, type);
    }

    public static <T> T readObject(InputStreamReader reader, Class<T> itemsClass) {
        return sGson.fromJson(reader, itemsClass);
    }
}
