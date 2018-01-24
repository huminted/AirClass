package Controller;


import Model.Upload;
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



       if (!file.isEmpty()){
           System.out.println(file.isEmpty());

           String fileName=file.getOriginalFilename();

           String fileNametime=System.currentTimeMillis()+fileName;



           //服务器编译路径
           String path= "C:/Files/"+fileNametime;

           File newFile=new File(path);
           //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
           file.transferTo(newFile);

           System.out.println(path);

           String url= request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort();


           path=url+"/download?filepath="+path+"&filename="+fileNametime;


           Upload upload =new Upload();
           upload.upload(fileName,fileNametime,path);



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
