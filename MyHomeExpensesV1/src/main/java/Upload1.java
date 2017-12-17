import java.io.File;
import java.io.IOException;
 
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
 
public class Upload1 {
 
    public static String upload() throws IllegalStateException, JSONException, IOException {
        
 
        /* load image from file
         * This snippet is using Apache HttpComponent libraries ver 4.4. You can down load it here:
         * http://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient
         * http://mvnrepository.com/artifact/org.apache.httpcomponents/httpmime
         * JSON library at json.org
         */
 
        String urlString = "http://www.bitocr.com/api";
        File file = new File("C:\\Users\\Mayank PC\\Desktop\\IMG_7139.JPG");
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost postRequest = new HttpPost(urlString);
 
        // build request parameters
        StringBody apiKey = new StringBody("179839dd508423bd", ContentType.MULTIPART_FORM_DATA);
        StringBody lang = new StringBody("en", ContentType.MULTIPART_FORM_DATA);
        FileBody fileBody = new FileBody(file, ContentType.MULTIPART_FORM_DATA);
 
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addPart("apikey", apiKey);
        builder.addPart("lang", lang);
        builder.addPart("file", fileBody);
 
        postRequest.setEntity(builder.build());
        HttpResponse res = null;
 
        // execute the request
        res = httpClient.execute(postRequest);
 
        JSONObject jsonObject = new JSONObject();
        if (res != null) {
 
            jsonObject = new JSONObject(IOUtils.toString(res.getEntity().getContent(), "UTF-8"));
            String error = jsonObject.get("error").toString();
            if (error.equals("0")) {
                // success
                System.out.println(jsonObject.getString("result"));
            } else {
 
                System.out.println("Error #" + jsonObject.get("error_code") + " " + jsonObject.get("error_message"));
            }
        }
 
        return jsonObject.toString();
    }
 
    public static void main(String[] args) throws IllegalStateException, JSONException, IOException {
 
        upload();
    }
}