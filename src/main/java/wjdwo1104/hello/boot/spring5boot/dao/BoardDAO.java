package wjdwo1104.hello.boot.spring5boot.dao;

import wjdwo1104.hello.boot.spring5boot.model.Board;

import java.util.List;
import java.util.Map;


public interface BoardDAO {

    int insertBoard(Board b);

    List<Board> selectBoard(int stnum);

    Board selectOneBoard(String bno);//bno로 매개변수 주는이유 몇번째 글번호를 찾을것인지

    int selectCountBoard();

    List<Board> selectFindBoard(Map<String, Object> params);

    int countFindBoard(Map<String, Object> params);

}
