package com.chitra.school.dao;

import org.springframework.stereotype.Repository;

import com.chitra.school.model.Memo;

@Repository("memoDao")
public class MemoDaoImple extends AbstractDao<Integer, Memo> implements MemoDao {

	public void save(Memo memo) {
		persist(memo);
		
	}

}
