package wjdwo1104.hello.boot.spring5boot.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wjdwo1104.hello.boot.spring5boot.model.Pds;
import wjdwo1104.hello.boot.spring5boot.model.PdsAttach;
import wjdwo1104.hello.boot.spring5boot.mybatis.PdsMapper;

import java.util.List;
import java.util.Map;


@Repository("pdao")
public class PdsDAOImpl implements PdsDAO {

    @Autowired
    private PdsMapper pdsMapper;

    @Override
    public int insertPds(Pds p) {
        int cnt = pdsMapper.insertPds(p);

        if (cnt > 0)
            cnt = pdsMapper.lastPdsPno();

        return cnt;
    }

    @Override
    public int insertPdsAttach(PdsAttach pa) {
        return pdsMapper.insertPdsAttach(pa);
    }

    @Override
    public List<Pds> selectPds(int stnum) {
        return pdsMapper.selectPds(stnum);
    }

    @Override
    public int selectCountPds() {
        return pdsMapper.selectCountPds();
    }

    @Override
    public Pds selectOnePds(String pno) {
        return pdsMapper.selectOnePds(pno);
    }

}