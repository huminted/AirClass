package Model;

import Bean.CodeBean;
import Bean.DocBean;
import Bean.UserBean;
import Controller.Api.Find.Doc;
import Service.DocService;
import Service.DocServiceImpl;

public class Upload {




    public void upload(String filename, String filenametime,String fileurl,String viewurl){

        DocBean DocBean =new DocBean();


        DocBean.setUserid(UserBean.userid);
        DocBean.setGroupid(CodeBean.docGroupId);
        DocBean.setUsername(UserBean.username);
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
