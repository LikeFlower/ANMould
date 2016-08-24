package win.waylib.anmould.component;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import win.waylib.anmould.R;


/**
 * 自定义的加载对话框
 * @author allen@tronsis.com
 * @date 2016-1-15 下午2:14:52
 */
public class LoadingDialog {

	private Context context;
	private Dialog dialog=null;
	private TextView progressbarMessageTv;
	
	public LoadingDialog(Context context){
		
		this.context=context;
		this.dialog= new AlertDialog.Builder(context).create();
		dialog.setCanceledOnTouchOutside(false);
		dialog.setCancelable(true);
	}
	
	/**
	 * 显示对话框
	 * @param messageId 对话框中的提示信息
	 */
	public void showDialog(int messageId){
		
		if(dialog!=null){
			
			// 弹出对话框
			dialog.show();
			
			//加载对话框布局文件
			View view= LayoutInflater.from(context).inflate(R.layout.layout_dialog_loading, null);
			progressbarMessageTv=(TextView) view.findViewById(R.id.tv_progressbar_message);
			progressbarMessageTv.setText(messageId);
			dialog.setContentView(view);
		}
	}
	
	public void setMessage(int messageId){
		progressbarMessageTv.setText(messageId);
	}
	
	/**
	 * 关闭对话框
	 */
	public void dismissDialog(){
		if(dialog!=null&&dialog.isShowing()){
			
			dialog.dismiss();
			dialog=null;
		}
	}
	
	/**
	 * 设置对话框是否可以取消（默认可以）
	 * @param cancelable
	 */
	public void setCancelable(boolean cancelable){
		dialog.setCancelable(cancelable);
	}
}
