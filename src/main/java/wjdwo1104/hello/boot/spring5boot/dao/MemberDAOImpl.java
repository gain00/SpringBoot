package wjdwo1104.hello.boot.spring5boot.dao;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wjdwo1104.hello.boot.spring5boot.model.Member;
import wjdwo1104.hello.boot.spring5boot.mybatis.MemberMapper;

import java.util.List;
@Repository("mdao")
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO{

    //mybatis를 사용하기 위해 필요한 객체 DI
    // 단, 생성자 주입 방식 사용
    @Autowired
    final MemberMapper memberMapper;

    @Autowired
    private SqlSession sqlSession;


    @Override
    public int insertMember(Member m) {
        // sqlSession.insert("insertMember",m)로 사용하는 방식보다는 편리
        //return sqlSession.insert("wjdwo1104.hello.boot.spring5boot.mybatis.MemberMapper.insertMember",m);
        return memberMapper.insertMember(m);
    }

    @Override
    public List<Member> selectMember() {
        return null;
    }

}

