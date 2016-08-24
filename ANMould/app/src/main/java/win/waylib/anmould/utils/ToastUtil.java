package win.waylib.anmould.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {  
	  
    private static String oldMsg;
    protected static Toast toast   = null;
    private static long oneTime=0;  
    private static long twoTime=0;  
      
    public static void showMessage(Context context, String message){
        if(toast==null){   
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.show();  
            oneTime= System.currentTimeMillis();
        }else{  
            twoTime= System.currentTimeMillis();
            if(message.equals(oldMsg)){  
                if(twoTime-oneTime> Toast.LENGTH_SHORT){
                    toast.show();  
                }  
            }else{  
                oldMsg = message;  
                toast.setText(message);  
                toast.show();  
            }         
        }  
        oneTime=twoTime;  
    }  
      
      
    public static void showMessage(Context context, int resId){
        showMessage(context, context.getString(resId));  
    }  
  
}  
