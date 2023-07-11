package wjdwo1104.hello.boot.spring5boot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wjdwo1104.hello.boot.spring5boot.dao.BoardDAO;
import wjdwo1104.hello.boot.spring5boot.dao.MemberDAO;
import wjdwo1104.hello.boot.spring5boot.model.Board;
import wjdwo1104.hello.boot.spring5boot.model.Member;

import java.util.List;

@Service("msrv")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDAO bdao;

    @Override
    public boolean saveBoard(Board b) {
        boolean boardSaved = false;
        if(bdao.insertBoard(b)>0) boardSaved = true;
        return boardSaved;
    }
}
