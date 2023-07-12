package wjdwo1104.hello.boot.spring5boot.board;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import wjdwo1104.hello.boot.spring5boot.dao.BoardDAOImpl;
import wjdwo1104.hello.boot.spring5boot.model.Board;
import wjdwo1104.hello.boot.spring5boot.service.BoardService;
import wjdwo1104.hello.boot.spring5boot.service.BoardServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({BoardServiceImpl.class, BoardDAOImpl.class})
public class BoardSerivceUnitTest {

    @Autowired
    private BoardService bsrv;



    @Test
    @DisplayName("BoardService read Test")
    void readBoard(){
        int cpg =1;

        List<Board> result = bsrv.readBoard(cpg);
        System.out.println(result);
        assertNotNull(result);

    }


}