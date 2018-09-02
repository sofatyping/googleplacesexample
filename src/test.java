
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GaeRequestHandler;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import okhttp3.Authenticator;
import okio.BufferedSource;
import org.joda.time.DateTime;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
//        GeoApiContext context = new GeoApiContext.Builder(new GaeRequestHandler.Builder())
//                .apiKey("AIzaSyCXrXhOFV-isq04CsOC17monLkRiot39lY")
//                .build();
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIza...")
                .build();
        try {
            GeocodingResult[] results =  GeocodingApi.geocode(context,
                    "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(results[0].addressComponents));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
