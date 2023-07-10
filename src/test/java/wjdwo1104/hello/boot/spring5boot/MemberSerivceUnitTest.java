package wjdwo1104.hello.boot.spring5boot;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import wjdwo1104.hello.boot.spring5boot.dao.MemberDAOImpl;
import wjdwo1104.hello.boot.spring5boot.model.Member;
import wjdwo1104.hello.boot.spring5boot.service.MemberService;
import wjdwo1104.hello.boot.spring5boot.service.MemberServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({MemberServiceImpl.class, MemberDAOImpl.class})
public class MemberSerivceUnitTest {

    @Autowired
    private MemberService msrv;

    @Test
    @DisplayName("MemberDAO insert Test")
    void saveMember(){
        Member m = new Member(null,"","","","","","","","","",null);

        boolean result = msrv.saveMember(m);
        System.out.println(result);
        assertEquals(result,true);

    }

    @Test
    @DisplayName("MemberDAO Test")
    void readMember(){

        List<Member> result = msrv.readMember();
        System.out.println(result);
        assertNotNull(result);

    }


}
