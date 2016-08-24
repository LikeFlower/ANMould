package win.waylib.anmould.base;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * $desc
 *
 * @author Leve@tronsis.com
 * @date 2016/8/24.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //透明状态栏
        //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        //            Window window = getWindow();
        //            // Translucent status bar
        //            window.setFlags(
        //                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
        //                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //        }
        onCreate();
        //        SysApplication.addActivity(this);
        ButterKnife.bind(this);
        initData();
    }

    protected abstract void onCreate();

    /**
     * 绑定View控件数据
     */
    protected abstract void initData();

}