package com.rifat.vnoticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rifat.vnoticeboard.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	public Board findByName(String name);
}
