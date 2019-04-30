package cn.jestar.libmaker;

import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import cn.jestar.library.utils.JsonUtils;

/**
 * Created by 花京院 on 2019/4/26.
 */

public class Compiler {
    @NonNull
    public BufferedReader getTxtReader(File file, String fileName) throws FileNotFoundException {
        return getReader(file, fileName + ".txt");
    }

    public BufferedReader getReader(File file, String fileName) throws FileNotFoundException {
        File source = new File(file, fileName);
        FileReader reader = new FileReader(source);
        return new BufferedReader(reader);
    }

    public void write2Json(File file, String fileName, Object obj) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(file, fileName + ".json"));
        writer.print(JsonUtils.toString(obj));
        writer.close();
    }


    protected <T> void compile(File file, String fileName, Creator<T> creator) throws IOException {
        BufferedReader bufferedReader = getTxtReader(file, fileName);
        String text;
        while ((text = bufferedReader.readLine()) != null) {
            try {
                creator.create(text);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(text);
            }
        }
        bufferedReader.close();
        write2Json(file, fileName, creator.getList());
    }

    public abstract class Creator<T> {
        private List<T> list = new ArrayList<>();

        public abstract void create(String text);

        public void add(T t) {
            list.add(t);
        }

        public List<T> getList() {
            return list;
        }
    }
}
