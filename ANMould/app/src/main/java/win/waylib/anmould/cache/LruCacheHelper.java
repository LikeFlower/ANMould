package win.waylib.anmould.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * LruCache使用工具类
 *
 * @author Leve@tronsis.com
 * @date 2016/6/17.
 */
public class LruCacheHelper {
	private LruCache<String, Object> mMemoryCache;
	static LruCacheHelper instance = null;

	public static LruCacheHelper getInstance() {
		if (instance == null) {
			instance = new LruCacheHelper();
		}
		return instance;
	}

	private LruCacheHelper() {
		// 获取应用程序最大可用内存
		int maxMemory = (int) Runtime.getRuntime().maxMemory();
		// 设置图片缓存大小为maxMemory的1/6
		int cacheSize = maxMemory / 6;
		if (mMemoryCache == null)
			mMemoryCache = new LruCache<String, Object>(cacheSize);
	}

	public void clearCache() {
		if (mMemoryCache != null) {
			if (mMemoryCache.size() > 0) {
//				Log.d("YLog", "mMemoryCache.size() " + mMemoryCache.size());
				mMemoryCache.evictAll();
//				Log.d("YLog", "mMemoryCache.size()" + mMemoryCache.size());
			}
			mMemoryCache = null;
		}
	}

	public synchronized void addToMemoryCache(String key, Object obj) {
		if (mMemoryCache.get(key) == null) {
			if (key != null && obj != null)
				mMemoryCache.put(key, obj);
		} else{
//			Log.w("YLog", "the res is aready exits");
	}
	}

	public synchronized Object getFromMemCache(String key) {
		Object obj = mMemoryCache.get(key);
		if (key != null) {
			return obj;
		}
		return null;
	}

	/**
	 * 移除缓存
	 *
	 * @param key
	 */
	public synchronized void removeImageCache(String key) {
		if (key != null) {
			if (mMemoryCache != null && (mMemoryCache.get(key) instanceof Bitmap)) {
				Bitmap bm = (Bitmap) mMemoryCache.remove(key);
				if (bm != null)
					bm.recycle();
			}
		}
	}
}
