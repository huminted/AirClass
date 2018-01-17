package Service;

import Bean.VideoBean;
import Dao.VideoDao;
import Dao.VideoDaoImpl;

import java.util.List;

public class VideoServiceImpl  implements VideoService{


    public VideoDao videoDao;
    public VideoServiceImpl(){


        videoDao=new VideoDaoImpl();
    }

    public List<VideoBean> findAllFile() {
        return  videoDao.findAllFile();
    }
}
