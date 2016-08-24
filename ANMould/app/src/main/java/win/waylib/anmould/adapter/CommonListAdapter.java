package win.waylib.anmould.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 通用ListView Adapter
 *
 * @author allen@tronsis.com
 * @date 2016-1-18 上午9:57:54
 */
public abstract class CommonListAdapter<T> extends BaseAdapter implements AdapterView.OnItemLongClickListener {
    protected LayoutInflater inflater;
    protected Context context;
    protected List<T> data;
    protected final int itemLayoutId;

    public CommonListAdapter(Context context, List<T> data, int itemLayoutId) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
        this.itemLayoutId = itemLayoutId;
    }

    public void notifyDataSetChanged(List<T> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        convert(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        return true;
    }

    public abstract void convert(ViewHolder helper, T item, int position);

    private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.get(context, convertView, parent, itemLayoutId, position);
    }

}
