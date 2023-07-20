package wjdwo1104.hello.boot.spring5boot.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wjdwo1104.hello.boot.spring5boot.mybatis.GalleryMapper;


import java.util.List;

@Repository("gdao")
public class GalleryDAOImpl implements GalleryDAO{

    //dao에서는 매퍼를 가져오고
    @Autowired
    private GalleryMapper galleryMapper;

    @Override
    public List<Gallery> selectGallery(int stnum) {
        return galleryMapper.selectGallery(stnum);
    }
}
