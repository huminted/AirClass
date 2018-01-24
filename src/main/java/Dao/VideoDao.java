package Dao;


import Bean.VideoBean;

import java.util.List;

public interface VideoDao {

    List<VideoBean> findAllFile();

    void addVideo(VideoBean videoBean);

    void delVideo(int objectid);

}
