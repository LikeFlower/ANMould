package win.waylib.anmould.json;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import win.waylib.anmould.R;
import win.waylib.anmould.base.BaseActivity;
import win.waylib.anmould.utils.StringUtil;
import win.waylib.anmould.utils.ToastUtil;

public class JsonActivity extends BaseActivity {
	@Bind(R.id.tvJson)
	TextView tvJson;
	@Bind(R.id.tvJsonPrase)
	TextView tvJsonPrase;
	@Bind(R.id.etName)
	EditText etName;
	@Bind(R.id.etAge)
	EditText etAge;
	@Bind(R.id.tvCreateJson)
	TextView tvCreateJson;
	
	@OnClick({ R.id.btnAdd, R.id.btnSubmit })
	void onBtnClick(View view) {
		switch (view.getId()) {
		case R.id.btnAdd:
			String name = etName.getText().toString().trim();
			String age = etAge.getText().toString().trim();
			if (StringUtil.isBlank(name) || StringUtil.isBlank(age)) {
				ToastUtil.showMessage(this, "empty input");
				return;
			}
			HashMap map = new HashMap<>();
			map.put("name", name);
			map.put("age", age);
			createList.add(map);
			ToastUtil.showMessage(this, "add input success");
			break;
		case R.id.btnSubmit:
			String createJson = new Gson().toJson(createList);
			tvCreateJson.setText(createJson);
			break;
		default:
			break;
		}
	}

	List<Map<String, Object>> createList = new ArrayList<Map<String, Object>>();

	@Override
	protected void onCreate() {
		setContentView(R.layout.activity_json);
	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		// 待解析json

		// {
		// "students":
		// [
		// {"name":"jack","age":10},
		// {"name":"Lucy","age":40}
		// ]
		// }

		// String json = "{ \"students\": [
		// {\"name\":\"jack\",\"age\":10},{\"name\":\"Lucy\",\"age\":40} ] } ";
		String json = "[{'age':1002,'name':'李四2'},{'age':1003,'name':'李四3'},{'age':1001,'name':'李四1'}]";
		tvJson.setText(json);

		// 1. 解析Json
		List<Person> list = new Gson().fromJson(json, new TypeToken<List<Person>>() {
		}.getType());
		// List<Map<String, Object>> list2 =
		// GsonTools.changeGsonToListMaps(json);
		// 解析结果：
		StringBuilder sb = new StringBuilder();
		for (Person p : list) {
			sb.append("name:" + p.getName());
			sb.append(" age:" + p.getAge());
			sb.append("\n");
		}
		if (sb != null) {
			tvJsonPrase.setText(sb);
		}

		// 2.生成Json

	}

}
