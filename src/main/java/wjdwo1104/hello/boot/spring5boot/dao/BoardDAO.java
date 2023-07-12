package wjdwo1104.hello.boot.spring5boot.dao;

import wjdwo1104.hello.boot.spring5boot.model.Board;
import wjdwo1104.hello.boot.spring5boot.model.Member;
import wjdwo1104.hello.boot.spring5boot.model.Zipcode;

import java.util.List;


public interface BoardDAO {

    int insertBoard(Board b);

    List<Board> selectBoard();

    Board selectOneBoard(String bno);//bno로 매개변수 주는이유 몇번째 글번호를 찾을것인지
}
