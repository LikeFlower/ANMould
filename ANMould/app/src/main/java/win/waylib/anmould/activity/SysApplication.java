package win.waylib.anmould.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.KeyEvent;

import com.zhy.http.okhttp.OkHttpUtils;

import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import win.waylib.anmould.R;
import win.waylib.anmould.utils.CrashHandler;
import win.waylib.anmould.utils.ToastUtil;

/**
 * 应用入口类
 *
 * @author allen@tronsis.com
 * @date 2016-1-15 上午10:58:46
 */
public class SysApplication extends Application {

	public static LinkedList<Activity> backActivityList = new LinkedList<Activity>(); // Activity集合
	private static long lastPressBackKeyTime;
	public static Context context;
	public static long startTime;

	@Override
	public void onCreate() {
		super.onCreate();
		startTime = System.currentTimeMillis();
		context = this.getApplicationContext();
		
		//初始化OkHttpUtils
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                  .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                  .readTimeout(10000L, TimeUnit.MILLISECONDS)
                  //其他配置
                 .build();
        OkHttpUtils.initClient(okHttpClient);
		
		// 初始化CrashHandler
		CrashHandler.getInstance(context).init();
		File cacheDir = getCacheDir();

	}

	/**
	 * 添加Activity到容器中
	 *
	 * @param activity
	 */
	public static void addActivity(Activity activity) {

		backActivityList.add(activity);
	}

	/**
	 * 应用程序退出
	 */
	public static void exit() {
		for (Activity activity : backActivityList) {
			activity.finish();
			activity = null;
		}
		android.os.Process.killProcess(android.os.Process.myPid());
		// 杀死应用进程
		System.exit(0);
	}

	/**
	 * 连续按两次返回键退出
	 *
	 * @param context
	 *            上下文对象
	 * @param keyCode
	 *            物理按键的keycode
	 */
	public static void keyBackExit(Context context, int keyCode) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			if (System.currentTimeMillis() - lastPressBackKeyTime < 1200) {
				exit();
			} else {
				ToastUtil.showMessage(context, R.string.toast_exit_message);
				lastPressBackKeyTime = System.currentTimeMillis();
			}
		}
	
	}

}
