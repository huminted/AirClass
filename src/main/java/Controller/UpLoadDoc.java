package Controller;


import Model.QiNiu;
import Model.Upload;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UpLoadDoc {







    @RequestMapping(value = "/fileupload" ,method = RequestMethod.POST)
    public String UploadFile(@RequestParam("file") MultipartFile file , HttpServletRequest request) throws IOException {

        QiNiu qiNiu=new QiNiu();

       if (!file.isEmpty()){
           System.out.println(file.isEmpty());

           String fileName=file.getOriginalFilename();
           File tempFile =new File( fileName.trim());
           fileName=tempFile.getName();


           System.out.println("文件名称"+fileName);

           String fileNametime=fileName;



           //服务器编译路径
           String path= "C:/AirClass/"+fileNametime;

           File newFile=new File(path);
           //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
           file.transferTo(newFile);

           System.out.println("路径"+path);

           qiNiu.upload(fileName,path);


//
//           String url= request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort();
//           path=url+"/download?filepath="+path+"&filename="+fileNametime;

           String url=" http://a.iwakeup.cn:8091/wopi/files/"+fileName+"/contents";
           String viewurl=" http://a.iwakeup.cn:8091/wopi/files/"+fileName;



           Upload upload =new Upload();
           upload.upload(fileName,fileNametime,url,viewurl);



           return "redirect:/index";

       }

        return "redirect:/index";
    }
//
//    @RequestMapping(value = "/cfileupload" ,method = RequestMethod.POST)
//    public String cUploadFile(@RequestParam("cfile") MultipartFile file   , ModelMap model) throws IOException {
//
//
//
//        if (!file.isEmpty()){
//            System.out.println(file.isEmpty());
//
//            String fileName=file.getOriginalFilename();
//
//
//
//            String fileNametime=System.currentTimeMillis()+fileName;
//
//            //服务器编译路径
//            String path="C:/Files/"+fileNametime;
//
//            File newFile=new File(path);
//            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
//            file.transferTo(newFile);
//
//            System.out.println(path);
//
//
//            Upload upload =new Upload();
//            upload.uploadToCenter(fileName,fileNametime,path);
//
//            LoadFiles loadFiles =new LoadFiles();
//            request.setAttribute("Userfilesmap", loadFiles.loadUser());
//            request.setAttribute("Centerfilesmap",loadFiles.loadCenter());
//
//
//
//
//            return "redirect:/index";
//
//        }
//
//        return "redirect:/index";
//    }


    public File getFilePath(String path){

        File file =new File(path);


        return  file;
    }





}
