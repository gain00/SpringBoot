package wjdwo1104.hello.boot.spring5boot.dao;

import wjdwo1104.hello.boot.spring5boot.model.Pds;
import wjdwo1104.hello.boot.spring5boot.model.PdsAttach;

import java.util.List;
import java.util.Map;


public interface PdsDAO {

    int insertPds(Pds p);

    int insertPdsAttach(PdsAttach pa);
}
