package Service;

import Bean.VideoBean;
import Dao.VideoDao;
import Dao.VideoDaoImpl;

import java.util.List;

public class VideoServiceImpl  implements VideoService{


    private VideoDao videoDao;
    public VideoServiceImpl(){


        videoDao=new VideoDaoImpl();
    }

    public List<VideoBean> findAllFile() {
        return  videoDao.findAllFile();
    }

    @Override
    public void addVideo(VideoBean videoBean) {
        videoDao.addVideo(videoBean);
    }

    @Override
    public void delVideo(int objectid) {
        videoDao.delVideo(objectid);
    }
}
