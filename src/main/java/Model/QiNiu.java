package Model;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class QiNiu {


    public static  void main(String arg[]){


        upload();


    }



    private static void upload(){



//构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "05tJtixq9qwhyudeLyZ9H4BBxH5Cip4IxPoFh3If";
        String secretKey = "umZ3O8zt7mFV92n_-mzWLVCOYhuegqYhAxCfd3bA";
        String bucket = "chart";
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "D:\\Data\\2010-05-01.txt";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = "hello.txt";
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
}
