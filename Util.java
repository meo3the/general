
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

/**
 * Created by Nam on 5/4/2016.
 */
public class Util {
    public String getDeviceId(Context context) {
//        Get device id function
//        Add this line to manifest file: <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    public boolean isNetworkConnected(Context context) {
//      Determine if you are connecting network or not
        NetworkInfo activeNetworkInfo = getNetworkInfo(context);
        boolean isConnected = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        return isConnected;
    }

    public boolean isWifi(Context context) {
//      Determine if your device is connected to a wifi or not
        return getNetworkInfo(context).getType() == ConnectivityManager.TYPE_WIFI;
    }

    
}
