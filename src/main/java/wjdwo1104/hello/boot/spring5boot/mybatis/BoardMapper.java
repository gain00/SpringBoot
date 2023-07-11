package wjdwo1104.hello.boot.spring5boot.mybatis;

import org.apache.ibatis.annotations.Mapper;
import wjdwo1104.hello.boot.spring5boot.model.Board;
import wjdwo1104.hello.boot.spring5boot.model.Member;
import wjdwo1104.hello.boot.spring5boot.model.Zipcode;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insertBoard(Board b);

    List<Board> selectBoard();

    Board selectOneBoard(Board b);
}


