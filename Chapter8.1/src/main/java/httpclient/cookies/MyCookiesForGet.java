package httpclient.cookies;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        url=bundle.getString("test.url");

    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        String testUrl = this.url + bundle.getString("getCookies.uri");
        HttpGet get = new HttpGet(testUrl);

        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);

        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        System.out.println("==========================================");

        //获取cookies
        this.store = client.getCookieStore();
        List<Cookie> cookiesList = store.getCookies();

        for (Cookie cookie : cookiesList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookieName: " + name + "   " + "cookieValue: " + value);
        }

        System.out.println("==========================================");


    }


    @Test(dependsOnMethods ={"testGetCookies"} )
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);

        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(this.store);

        HttpResponse response = client.execute(get);

        System.out.println("-----*****1******-----");

        //获取相应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode: "+ statusCode);
        System.out.println("-----*****2******-----");

        if(statusCode == 200){

            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }
        System.out.println("-----*****3******-----");


    }

}
