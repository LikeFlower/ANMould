package win.waylib.anmould.activity;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnItemClick;
import win.waylib.anmould.R;
import win.waylib.anmould.base.BaseActivity;
import win.waylib.anmould.cache.CacheActivity;
import win.waylib.anmould.db.NoteActivity;
import win.waylib.anmould.http.HttpActivity;
import win.waylib.anmould.imageloader.ImageActivity;
import win.waylib.anmould.json.JsonActivity;
import win.waylib.anmould.utils.ToastUtil;
import win.waylib.anmould.zxing.CaptureActivity;

public class MainActivity extends BaseActivity {
	@Bind(R.id.lvAllItem)
	ListView lvMain;
	@Bind(R.id.tvTitle)
	TextView tvTitle;

	@OnClick(R.id.tvTitle)
	void click() {
		ToastUtil.showMessage(this, "tvTitle click");
	}

	@OnItemClick(R.id.lvAllItem)
	void onItemClick(int position) {
		switch (position) {
		case 0: // Component
			
			break;

		case 1: // Image Loader
			startActivity(new Intent(this, ImageActivity.class));
			break;

		case 2: // Http
			startActivity(new Intent(this, HttpActivity.class));
			break;

		case 3: // DB
			startActivity(new Intent(this, NoteActivity.class));
			break;

		case 4: // Cache
			startActivity(new Intent(this, CacheActivity.class));
			break;

		case 5: // Json
			startActivity(new Intent(this, JsonActivity.class));
			break;

		case 6: // Zxing
			startActivity(new Intent(this, CaptureActivity.class));
			break;

		default:
			break;
		}
	}

	private String[] items = new String[] { "Component", "Image Loader", "Http", "DateBase", "Cache", "Json", "Zxing" };

	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		// 创建ArrayAdapter
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		// 绑定适配器
		lvMain.setAdapter(arrayAdapter);
	}

}
