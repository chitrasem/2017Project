package com.chitra.school.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitra.school.dao.MemoDao;
import com.chitra.school.model.Memo;

@Service("memoService")
@Transactional
public class MemoServiceImpl implements MemoService{
	
	@Autowired
	MemoDao memoDao;

	public void save(Memo memo) {
		memoDao.save(memo);
		
	}

	public List<Memo> listMemoByStudentId(String studentId) {
		
		return memoDao.listMemoByStudentId(studentId);
	}
}
