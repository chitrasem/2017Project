package com.chitra.school.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.dao.MemoDao;
import com.chitra.school.entities.Memo;

@Service("memoService")
@Transactional
public class MemoServiceImpl implements MemoService{
	
	@Autowired
	MemoDao memoDao;
	@Transactional(rollbackFor=Exception.class)
	public void save(Memo memo) {
		
		memoDao.save(memo);
		
	}

	public List<Memo> listMemoByStudentId(String studentId) {		
		return memoDao.listMemoByStudentId(studentId);
	}
}
