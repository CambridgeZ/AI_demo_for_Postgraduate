package utils;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AIUtiles {
    //设置APPID/AK/SK
    public static final String APP_ID = "46322650";
    public static final String API_KEY = "oblIocrPZn2dtd0sU13DqaEH";
    public static final String SECRET_KEY = "TVESF48proV9ms15WYGEjE5lXIjQAWLh";

    public static String picToWord(MultipartFile file) throws IOException {

        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
//        String path = "/Users/mac/Downloads/img-1672451656780910a4cbebb95be7ea8784d717f2f1c2dd3e91df7e06fa29f678bf97a04fb3b09.jpg";
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());

        JSONArray word_result=  res.getJSONArray("words_result");

        String result="";
        for(int i=0;i<word_result.length();i++){
            JSONObject word=word_result.getJSONObject(i);
            result += word.getString("words");
            result+= "\n";
        }

        return result;
    }


//    public static void main(String[] args) {
//        // 初始化一个AipOcr
//        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
//
//        // 可选：设置网络连接参数
////        client.setConnectionTimeoutInMillis(2000);
////        client.setSocketTimeoutInMillis(60000);
//
//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
////        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
////        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
//
//        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
//        // 也可以直接通过jvm启动参数设置此环境变量
////        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
//
//        // 调用接口
//        String path = "/Users/mac/Downloads/img-1672451656780910a4cbebb95be7ea8784d717f2f1c2dd3e91df7e06fa29f678bf97a04fb3b09.jpg";
//        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
//
//        JSONArray word_result=  res.getJSONArray("words_result");
//
////        System.out.println(res.toString(2));
//
//        for(int i=0;i<word_result.length();i++){
//            JSONObject word=word_result.getJSONObject(i);
//            System.out.println(word.getString("words"));
//        }
//    }
}
