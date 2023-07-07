package wjdwo1104.hello.boot.spring5boot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import wjdwo1104.hello.boot.spring5boot.model.Member;

import java.util.List;

public class MemberDAOImpl implements MemberDAO{
    @Autowired
    private SqlSession sqlSession;
    @Override
    public int insertMember(Member m) {
        return sqlSession.insert("member.insertMember",m);
    }

    @Override
    public List<Member> selectMember() {
        return null;
    }

}

