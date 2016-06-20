package rukina.jaycee.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import rukina.jaycee.R;

public class MainActivity extends AppCompatActivity {

    private WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebview = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        Bundle b = getIntent().getExtras();
        String Username = b.getString("username");
        String Password = b.getString("password");

        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        //try {
        //String query = URLEncoder.encode(loginType, "utf-8");
        String url = "http://budnetdesign.in/jaycee/api/login_web?username=" + Username + "&password=" + Password + "";
        String a = "";
        mWebview.loadUrl(url);
        setContentView(mWebview);
//        } catch (UnsupportedEncodingException ex) {
//            ex.printStackTrace();
//        }

        this.registerReceiver(this.mConnReceiver, new IntentFilter(
                ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void onBackPressed() {
    }

    public BroadcastReceiver mConnReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            if (isNetworkAvailable(context)) {
                // code here
            } else {
                Toast.makeText(getApplicationContext(), "No Internet Connection. Your device is currently not connected to the internet, please try again!", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    };

    public boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
