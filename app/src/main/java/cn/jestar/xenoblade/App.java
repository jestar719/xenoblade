package cn.jestar.xenoblade;

import android.app.Application;

/**
 * Created by 花京院 on 2019/4/29.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppRepository.getInstance().init(this);
    }
}
