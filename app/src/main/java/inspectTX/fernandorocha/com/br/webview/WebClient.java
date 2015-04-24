package inspectTX.fernandorocha.com.br.webview;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebClient extends WebViewClient {

    private WebViewActivity wvFragment;

    public WebClient(WebViewActivity wvFragment) {
        this.wvFragment = wvFragment;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {

        super.onPageStarted(view, url, favicon);


    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);

    }


    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);

    }

}
