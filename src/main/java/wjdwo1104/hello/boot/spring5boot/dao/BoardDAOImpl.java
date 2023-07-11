package wjdwo1104.hello.boot.spring5boot.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wjdwo1104.hello.boot.spring5boot.model.Board;
import wjdwo1104.hello.boot.spring5boot.model.Member;
import wjdwo1104.hello.boot.spring5boot.model.Zipcode;
import wjdwo1104.hello.boot.spring5boot.mybatis.BoardMapper;
import wjdwo1104.hello.boot.spring5boot.mybatis.MemberMapper;

import java.util.List;

@Repository("mdao")
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {

    // mybatis를 사용하기 위해 필요한 객체 DI
    // 단, 생성자 주입 방식 사용!
    @Autowired
    final BoardMapper boardMapper;


    @Override
    public int insertBoard(Board b) {
        return boardMapper.insertBoard(b);
    }

    @Override
    public List<Board> selectBoard() {
        return null;
    }

    @Override
    public Board selectOneBoard(Board b) {
        return null;
    }
}