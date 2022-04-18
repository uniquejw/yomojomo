package com.bts.yomojomo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bts.yomojomo.domain.Board;

@Mapper 

public interface BoardDao {
  int countAll();

  List<Board> findAll();

  List<Board> findByGroupNo(int no);

  List<Board> findBoardNo(Board board);

  int insert(Board board);

  Board findByNo(int no);

  int update(Board board);

  int delete(Board board);

  int increaseViewCount(int no);
}
