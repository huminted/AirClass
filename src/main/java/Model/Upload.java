package Model;

import Bean.DocBean;
import Bean.UserBean;
import Service.DocService;
import Service.DocServiceImpl;

public class Upload {




    public void upload(String filename, String filenametime,String fileurl){

        DocBean DocBean =new DocBean();


        DocBean.setId(UserBean.userid);
        DocBean.setUsername(UserBean.username);
        DocBean.setFilename(filename);
        DocBean.setFileurl(fileurl);
        DocBean.setFilenametime(filenametime);

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
