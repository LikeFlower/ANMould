package win.waylib.anmould.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 操作SharedPreferences的工具类
 * 
 * @date 2016-1-15 下午2:13:29
 */
public class SharedPreferencesUtil {

	/**
	 * 写入String类型的的数据到SharedPreferences
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return True
	 */
	public static boolean putString(Context context, String key, String value) {
		SharedPreferences settings = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(key, value);
		return editor.commit();
	}

	/**
	 * 从SharedPreferences中获得String类型的的数据
	 * 
	 * @param context
	 * @param key
	 * @return
	 * @see #getString(Context, String, String)
	 */
	public static String getString(Context context, String key) {
		return getString(context, key, null);
	}

	/**
	 * 从SharedPreferences中获得String类型的的数据（可设置获取不到时的默认值）
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getString(Context context, String key, String defaultValue) {
		SharedPreferences settings = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		return settings.getString(key, defaultValue);
	}

	/**
	 * 写入int类型的的数据到SharedPreferences
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean putInt(Context context, String key, int value) {
		SharedPreferences settings = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(key, value);
		return editor.commit();
	}

	/**
	 * 从SharedPreferences中获得int类型的数据
	 * 
	 * @param context
	 * @param key
	 * @return
	 * @see #getInt(Context, String, int)
	 */
	public static int getInt(Context context, String key) {
		return getInt(context, key, -1);
	}

	/**
	 * 从SharedPreferences中获得int类型的数据（可设置获取不到时的默认值）
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 *            默认值
	 * @return
	 */
	public static int getInt(Context context, String key, int defaultValue) {
		SharedPreferences settings = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		return settings.getInt(key, defaultValue);
	}

	/**
	 * 写入long类型的数据到SharedPreferences中
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean putLong(Context context, String key, long value) {
		SharedPreferences settings = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putLong(key, value);
		return editor.commit();
	}

	/**
	 * 从SharedPreferences中获得long类型的数据
	 * 
	 * @param context
	 * @param key
	 * @return
	 * @see #getLong(Context, String, long)
	 */
	public static long getLong(Context context, String key) {
		return getLong(context, key, -1);
	}

	/**
	 * 从SharedPreferences中获得long类型的数据（可设置获取不到时的默认值）
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static long getLong(Context context, String key, long defaultValue) {
		SharedPreferences settings = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		return settings.getLong(key, defaultValue);
	}

	/**
	 * 写入float类型的数据到SharedPreferences
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean putFloat(Context context, String key, float value) {
		SharedPreferences settings = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putFloat(key, value);
		return editor.commit();
	}

	/**
	 * 从SharedPreferences中获得float类型的数据
	 * 
	 * @param context
	 * @param key
	 * @return
	 * @see #getFloat(Context, String, float)
	 */
	public static float getFloat(Context context, String key) {
		return getFloat(context, key, -1);
	}

	/**
	 * 从SharedPreferences中获得float类型的数据（可设置获取不到时的默认值）
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static float getFloat(Context context, String key, float defaultValue) {
		SharedPreferences settings = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		return settings.getFloat(key, defaultValue);
	}

	/**
	 * 写入boolean类型的数据到SharedPreferences
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean putBoolean(Context context, String key, boolean value) {
		SharedPreferences settings = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(key, value);
		return editor.commit();
	}

	/**
	 * 从SharedPreferences中获得boolean类型的数据
	 * 
	 * @param context
	 * @param key
	 * @return
	 * @see #getBoolean(Context, String, boolean)
	 */
	public static boolean getBoolean(Context context, String key) {
		return getBoolean(context, key, false);
	}

	/**
	 * 从SharedPreferences中获得int类型的数据（可设置获取不到时的默认值）
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static boolean getBoolean(Context context, String key, boolean defaultValue) {
		SharedPreferences settings = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		return settings.getBoolean(key, defaultValue);
	}

	static class Constants {
		public static final String PREFERENCE_NAME = "dogchain_sharedpreferences";
	}
}