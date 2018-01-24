package Service;


import Bean.VideoBean;

import java.util.List;

public interface VideoService {

    List<VideoBean> findAllFile();
    void addVideo(VideoBean videoBean);

    void delVideo(int objectid);
}
