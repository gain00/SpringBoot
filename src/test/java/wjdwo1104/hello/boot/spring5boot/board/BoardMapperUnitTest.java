package wjdwo1104.hello.boot.spring5boot.board;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import wjdwo1104.hello.boot.spring5boot.model.Member;
import wjdwo1104.hello.boot.spring5boot.mybatis.BoardMapper;
import wjdwo1104.hello.boot.spring5boot.mybatis.MemberMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardMapperUnitTest {

    @Autowired
    private BoardMapper boardMapper;

 /*   @Test
    @DisplayName("MemberMapper Test")
    void insertMember(){
        Member m = new Member(null,"","","","","","","","","",null);

        int result = memberMapper.insertMember(m);
        System.out.println(result);
        assertEquals(result,1);

    }*/

    @Test
    @DisplayName("MemberMapper Test")
    void selectMember(){

       /* List<Member> result = boardMapper.selectBoard();
        System.out.println(result);
        assertNotNull(result);*/

    }

    /*@Test
    @DisplayName("MemberMapper selelctOneMember Test")
    void selectOneMember(){
        Member m = new Member();
        m.setUserid("abc123");
        m.setPasswd("987xyz");

        Member result = memberMapper.selectOneMember(m);

        System.out.println(result);
        assertNotNull(result);

    }
*/

}
