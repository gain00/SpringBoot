package wjdwo1104.hello.boot.spring5boot.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import wjdwo1104.hello.boot.spring5boot.model.Board;

import wjdwo1104.hello.boot.spring5boot.mybatis.BoardMapper;


import java.util.List;

@Repository("bdao")//이 클래스를 Spring에서 데이터 접근 객체(DAO)로 관리하도록 지정. 이름은 "bdao"로 설정
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {

    // mybatis를 사용하기 위해 필요한 객체 DI
    // 단, 생성자 주입 방식 사용!
    //@Autowired//꼭명시하지않아도됨 @RequiredArgsConstructor를 적용하면 없이사용가능
    final BoardMapper boardMapper;


    @Override
    public int insertBoard(Board b) {
        return boardMapper.insertBoard(b);
    }

    @Override
    public List<Board> selectBoard(int stnum) {
        return boardMapper.selectBoard(stnum);
    }

    @Override
    public Board selectOneBoard(String bno) {
        boardMapper.updateViewBoard(bno);
        return boardMapper.selectOneBoard(bno);
    }

    @Override
    public int selectCountBoard() {
        return boardMapper.selectCountBoard();
    }


}