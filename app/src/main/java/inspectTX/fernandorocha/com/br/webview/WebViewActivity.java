package inspectTX.fernandorocha.com.br.webview;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = (WebView) findViewById(R.id.webview);
        getActionBar().hide();
        //webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setGeolocationDatabasePath( getFilesDir().getPath() );

        String agentModified = webView.getSettings().getUserAgentString().concat(this.getPackageName());

        String packageStr = this.getPackageName();

        webView.getSettings().setUserAgentString(agentModified);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new WebAppInterface(this), "Android");


        webView.loadUrl("http://www.fernandoaugustorocha.com/inspect-tx/");

        //Toast.makeText(this,this.getPackageName(),Toast.LENGTH_LONG).show();
        Log.d("package",agentModified);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.web_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
