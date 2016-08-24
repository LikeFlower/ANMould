
package win.waylib.anmould.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {

    public static final int NONETWORK = 0;
    public static final int WIFI = 1;
    public static final int NOWIFI = 2;

    public static int getNetWorkType(Context context) {
        if (!isNetWorkAvalible(context)) {
            return NetworkUtil.NONETWORK;
        }
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting())
            return NetworkUtil.WIFI;
        else
            return NetworkUtil.NOWIFI;
    }

    public static boolean isNetWorkAvalible(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        }
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null || !ni.isAvailable()) {
            return false;
        }
        return true;
    }

}
