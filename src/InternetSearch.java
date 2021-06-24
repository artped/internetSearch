import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.io.*;
import com.google.gson;

public class InternetSearch {

	public static void main(String[] args)  throws Exception{
		String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
	    String search = "Oracle";
	    String charset = "UTF-8";

	    URL url = new URL(google + URLEncoder.encode(search, charset));
	    Reader reader = new InputStreamReader(url.openStream(), charset);
	    GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

	    // Show title and URL of 1st result.
	    for (int x=0;x <= results.getResponseData().getResults().size()-1; x++ ){
		    System.out.println(results.getResponseData().getResults().get(x).getTitle());
		    System.out.println(results.getResponseData().getResults().get(x).getUrl());	
			InetAddress address = InetAddress.getByName(results.getResponseData().getResults().get(x).getUrl());
			System.out.println(address);
		    System.out.println();
	    }
	    System.out.println(results.getResponseData().getResults().size());	
	}
}