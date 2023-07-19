package wjdwo1104.hello.boot.spring5boot.service;

import org.springframework.web.multipart.MultipartFile;
import wjdwo1104.hello.boot.spring5boot.model.Board;
import wjdwo1104.hello.boot.spring5boot.model.Pds;
import wjdwo1104.hello.boot.spring5boot.model.PdsComment;

import java.util.List;
import java.util.Map;
public interface PdsService {

    int newPds(Pds p);

    boolean newPdsAttach(MultipartFile attach, int pno);


    List<Pds> readPds(Integer cpg);

    int countPds();

    Pds readOnePds(String pno);

    String readOnePdsAttach(String pno);

    Map<String, Object> getHeaderResouce(String fname);

    boolean newPdsComment(PdsComment pc);



    List<PdsComment> readPdsComment(String pno);

    boolean newPdsReply(PdsComment pc);
}