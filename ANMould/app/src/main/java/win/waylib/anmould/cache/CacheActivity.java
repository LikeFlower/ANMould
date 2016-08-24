package win.waylib.anmould.cache;

import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import win.waylib.anmould.R;
import win.waylib.anmould.base.BaseActivity;
import win.waylib.anmould.logger.Logger;
import win.waylib.anmould.utils.SharedPreferencesUtil;
import win.waylib.anmould.utils.ToastUtil;

public class CacheActivity extends BaseActivity {
	@Bind(R.id.tvACache)
	TextView tvACache;
	@Bind(R.id.tvSharedP)
	TextView tvSharedP;
	@Bind(R.id.tvLruCache)
	TextView tvLruCache;
	@Bind(R.id.etInput)
	EditText etInput;

	@OnClick(R.id.btnSubmit)
	void onClick() {
		String inputStr = etInput.getText().toString().trim();

		// save data
		aCache.put(key, inputStr);
		SharedPreferencesUtil.putString(this, key, inputStr);
		helper.addToMemoryCache(key, inputStr);
		etInput.setText("");
		ToastUtil.showMessage(this, "data has save");
	}

	ACache aCache;
	LruCacheHelper helper;
	String key = "submit";

	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_cache);
		aCache = ACache.get(this);
		helper = LruCacheHelper.getInstance();

		Logger.d("debug");
	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub

		String str = aCache.getAsString(key);
		String str2 = SharedPreferencesUtil.getString(this, key);
		Object str3 = helper.getFromMemCache(key);
		if (str != null) {
			tvACache.setText(str);
		}
		if (str2 != null) {
			tvSharedP.setText(str2);
		}
		if (str3 != null) {
			tvLruCache.setText(str3.toString());
		}
	}
}
