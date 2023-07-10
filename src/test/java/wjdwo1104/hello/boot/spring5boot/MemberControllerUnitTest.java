package wjdwo1104.hello.boot.spring5boot;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import wjdwo1104.hello.boot.spring5boot.model.Member;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MemberControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("MemberController save Test")
    @Transactional
    void saveMember() throws Exception {
        Member m = new Member(null,"","","","","","","","","",null);

      mvc.perform(post("/join/joinme")
              .param("userid","abc123a")
              .param("passwd","")
              .param("name","abc123a")
              .param("email","abc123a")
              .param("zipcode","")
              .param("addr1","")
              .param("addr2","")
              .param("phone",""))
              .andExpect(status().is3xxRedirection())
              .andDo(print());
    }




}
