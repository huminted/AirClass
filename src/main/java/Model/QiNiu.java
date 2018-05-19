package Model;

import Bean.CodeBean;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class QiNiu {


    public static void main(String arg[]){
        upload("a","F:\\AirClass\\src\\main\\java\\Model\\QiNiu.java");
    }


    public static void upload(String fileName, String filePath){


        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = CodeBean.QiNiu_accessKey;
        String secretKey = CodeBean.QiNiu_secretKey;
        String bucket =CodeBean.bucket;
        //如果是Windows情况下，格式是 D:\\qiniu\\test.png

        String localFilePath = filePath;
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }

    }

    public  void delete(String filename){

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        String accessKey = CodeBean.QiNiu_accessKey;
        String secretKey = CodeBean.QiNiu_secretKey;
        String bucket = CodeBean.bucket;
        String key = filename;
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }


    }

    public static void test(){



        JSONObject jsonObject= (JSONObject) JSONObject.parse("{\"score\":6,\"detial\":[{\"paperid\":\"278\",\"papertitle\":\"测试\",\"singlechoice\":3,\"fillblank\":3,\"tof\":0}]}");


        String score=jsonObject.get("score").toString();

        JSONArray detialArray=jsonObject.getJSONArray("detial");

        JSONObject detialObj=detialArray.getJSONObject(0);




    }

}
