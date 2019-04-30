package cn.jestar.xenoblade.base;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by 花京院 on 2019/4/29.
 */

public class BaseRepository {

    protected InputStreamReader getReader(Context context, String fileName) throws IOException {
        InputStream open = context.getAssets().open(fileName);
        InputStreamReader reader = new InputStreamReader(open);
        return reader;
    }
}
