package win.waylib.anmould.utils;

import android.content.Context;

import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

import win.waylib.anmould.R;

/**
 * 处理Android应用异常退出的类
 * @date 2016-1-15 上午10:58:39
 */
public class CrashHandler implements UncaughtExceptionHandler {

	private Context context;
	private static CrashHandler instance = null;
	/** 系统默认的UncaughtException处理类 */
	private UncaughtExceptionHandler defaultHandler;

	private CrashHandler(Context context) {
		this.context = context;
	}

	/**
	 * 获得一个CrashHandler实例
	 * 
	 * @return
	 */
	public static CrashHandler getInstance(Context context) {

		if (instance == null) {
			instance = new CrashHandler(context);
		}

		return instance;
	}

	/**
	 * CrashHandler的初始化方法，为线程设置默认的UncaughtException处理器
	 */
	public void init() {
		defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		// 设置该类为线程默认UncaughtException的处理器
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {

		if (!handleException(ex) && defaultHandler != null) {
			// 如果用户没有处理则让系统默认的异常处理器来处理
			defaultHandler.uncaughtException(thread, ex);
		} else { // 如果自己处理了异常，则不会弹出错误对话框，则需要手动退出app
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
//			SysApplication.exit();
		}

	}

	private boolean handleException(final Throwable ex) {
		if (ex == null) {
			return false;
		}
		try {
			FileUtil.saveToSDCard(context, context.getString(R.string.app_name), "crash_log_V" + context.getString(R.string.app_version) + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis())) + ".txt", ex.getLocalizedMessage() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
