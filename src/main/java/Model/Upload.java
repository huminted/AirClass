package Model;

import Bean.CodeBean;
import Bean.DocBean;
import Bean.UserBean;
import Controller.Api.Find.Doc;
import Service.DocService;
import Service.DocServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Upload {




    public void upload(String filename, String filenametime, String fileurl, String viewurl, HttpServletRequest request){

        DocBean DocBean =new DocBean();
        CookieUtils cookieUtils=new CookieUtils();
        Cookie cookiename=cookieUtils.getCookieByName(request,"username");
        Cookie cookieid=cookieUtils.getCookieByName(request,"userid");

        DocBean.setUserid(Integer.parseInt(cookieid.getValue()));
        DocBean.setGroupid(CodeBean.docGroupId);
        DocBean.setUsername(cookiename.getValue());
        DocBean.setFilename(filename);
        DocBean.setFileurl(fileurl);
        DocBean.setFilenametime(filenametime);
        DocBean.setViewurl(viewurl);

        DocService service =new DocServiceImpl();
        service.addFile(DocBean);


    }


//    public void uploadToCenter(String filename,String filenametime,String fileurl){
//
//        DocBean DocBean =new DocBean();
//
//
//        DocBean.setId(UserBean.id);
//        DocBean.setUsername(UserBean.username);
//        DocBean.setFilename(filename);
//        DocBean.setFileurl(fileurl);
//        DocBean.setFilenametime(filenametime);
//
//        DocService service =new DocServiceImpl();
//        service.addFileToCenter(DocBean);
//
//
//    }


}
