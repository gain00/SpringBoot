package wjdwo1104.hello.boot.spring5boot.board;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import wjdwo1104.hello.boot.spring5boot.dao.BoardDAO;
import wjdwo1104.hello.boot.spring5boot.dao.BoardDAOImpl;
import wjdwo1104.hello.boot.spring5boot.model.Board;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(BoardDAOImpl.class)
public class BoardDAOUnitTest {

    @Autowired private BoardDAO bdao;

    @Test
    @DisplayName("BoardDAO select Test")
    void selectBoard() {
        int stnum=1;
        List<Board> results = bdao.selectBoard(stnum);
        //System.out.println(resutls);
        assertNotNull(results);
    }
    @Test
    @DisplayName("BoardDAO select Test")
    void selectOneBoard() {
        String bno = "1374";
        Board results = bdao.selectOneBoard(bno);
        //System.out.println(resutls);
        assertNotNull(results);
    }

    @Test
    @DisplayName("boardMapper select Test")
    @Transactional
    void insertBoard(){
        Board b = new Board();
        b.setUserid("abc123a");
        b.setTitle("테스트");
        b.setContent("테스트");
        b.setIpaddr("127.0.0.1");
        int result =  bdao.insertBoard(b);

        assertEquals(result,1);
    }



}