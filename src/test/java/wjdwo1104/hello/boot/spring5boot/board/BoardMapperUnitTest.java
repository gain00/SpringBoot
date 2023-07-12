package wjdwo1104.hello.boot.spring5boot.board;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import wjdwo1104.hello.boot.spring5boot.model.Board;
import wjdwo1104.hello.boot.spring5boot.mybatis.BoardMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardMapperUnitTest {

    @Autowired
    private BoardMapper boardMapper;


    @Test
    @DisplayName("boardMapper select Test")
    void selectBoard(){
        int cpg = 1;
        int stnum=(cpg-1) * 25;
        List<Board> results =  boardMapper.selectBoard(stnum);
        System.out.println(results);
        assertNotNull(results);
    }

    @Test
    @DisplayName("boardMapper select Test")
    void selectOneBoard(){
        String bno = "1374";
        Board results =  boardMapper.selectOneBoard(bno);

        assertNotNull(results);
    }



    }

