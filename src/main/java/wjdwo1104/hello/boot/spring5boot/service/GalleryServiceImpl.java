package wjdwo1104.hello.boot.spring5boot.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wjdwo1104.hello.boot.spring5boot.dao.GalleryDAO;
import wjdwo1104.hello.boot.spring5boot.model.GalAttach;
import wjdwo1104.hello.boot.spring5boot.model.Gallery;
import wjdwo1104.hello.boot.spring5boot.utils.GalleryUtils;

import java.util.List;

@Service("gsrv")
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService{

    final GalleryDAO gdao;
    final GalleryUtils galUtils;

    @Override
    public List<Gallery> readGallery(int stnum) {
        return gdao.selectGallery(stnum-1);
    }

    @Override
    public int countGallery() {
        return 0;
    }

    @Override
    public int newGallery(Gallery g) {
        return gdao.insertGallery(g);
    }

    @Override
    public boolean newGalAttach(List<MultipartFile> attachs, int gno) {
        //이미지 파일 저장후 파일 정보 받아오기
        GalAttach ga = galUtils.processUpload(attachs);
        //썸네일이미지생성
        galUtils.makeThumbnail(ga);
        //이미지파일정보저장
        ga.setGno(gno+"");
        return (gdao.insertGalAttach(ga) > 0) ? true : false;

    }


}
