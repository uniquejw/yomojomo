package com.bts.yomojomo.service;

import java.util.List;
import com.bts.yomojomo.domain.Board;

public interface BoardService {

  int add(Board board);

  List<Board> list();

  List<Board> findByGroupNo(int no);

  List<Board> findByBoardNo(Board board);

  Board get(int no);

  int update(Board board);

  int delete(Board board);

  int increaseViewCount();
}
