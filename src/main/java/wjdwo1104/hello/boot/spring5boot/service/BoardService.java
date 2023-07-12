package wjdwo1104.hello.boot.spring5boot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import wjdwo1104.hello.boot.spring5boot.model.Board;
import wjdwo1104.hello.boot.spring5boot.model.Member;

import java.util.List;

public interface BoardService {

    boolean saveBoard(Board b);

    List<Board> readBoard();

    Board readOneBoard(String bno);


}
