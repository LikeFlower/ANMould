package win.waylib.anmould.http;

import android.view.View;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import win.waylib.anmould.R;
import win.waylib.anmould.base.BaseActivity;
import win.waylib.anmould.utils.ToastUtil;

public class HttpActivity extends BaseActivity {
	@Bind(R.id.tvGetURL)
	TextView tvGetURL;
	@Bind(R.id.tvResult)
	TextView tvResult;
	@Bind(R.id.tvPostURL)
	TextView tvPostURL;

	@OnClick({ R.id.btnHttpGet, R.id.btnPost })
	void onBtnClick(View view) {
		switch (view.getId()) {
		case R.id.btnHttpGet:
			httpGet();
			break;

		case R.id.btnPost:
			httpPost2();
			break;

		}
	}

	String getUrl = "http://news-at.zhihu.com/api/4/version/android/2.3.0";
//	String postUrl = "https://api.github.com/repos/vmg/redcarpet/issues";
	String postUrl ="http://192.168.31.185:8080/deplay/api/common/list_cities";
	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_http);
	}

	@Override
	protected void initData() {
		tvGetURL.setText(getUrl);
		tvPostURL.setText(postUrl);
		
	}

	void httpGet() {
		// GET请求
		OkHttpUtils.get().url(getUrl).build().execute(new StringCallback() {
			@Override
			public void onError(Call arg0, Exception arg1, int arg2) {
				// TODO Auto-generated method stub
				ToastUtil.showMessage(HttpActivity.this, "error");
			}

			@Override
			public void onResponse(String arg0, int arg1) {
				// TODO Auto-generated method stub
				// ToastUtil.showMessage(HttpActivity.this, "" + arg0);
				tvResult.setText(arg0);
			}
		});
	}

//	void httpPost() {
//		OkHttpUtils.post().url(postUrl).addParams("state", "closed").build().execute(new StringCallback() {
//
//			@Override
//			public void onResponse(String arg0, int arg1) {
//				// TODO Auto-generated method stub
//				tvResult.setText(arg0);
//			}
//
//			@Override
//			public void onError(Call arg0, Exception arg1, int arg2) {
//				// TODO Auto-generated method stub
//				ToastUtil.showMessage(HttpActivity.this, "error");
//			}
//		});
//	}
	
	void httpPost2() {
		OkHttpUtils.post().url(postUrl).addParams("country", "japan").build().execute(new StringCallback() {

			@Override
			public void onResponse(String arg0, int arg1) {
				// TODO Auto-generated method stub
				tvResult.setText(arg0);
			}

			@Override
			public void onError(Call arg0, Exception arg1, int arg2) {
				// TODO Auto-generated method stub
				ToastUtil.showMessage(HttpActivity.this, "error");
			}
		});
	}
}
