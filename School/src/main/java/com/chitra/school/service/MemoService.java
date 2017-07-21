package com.chitra.school.service;

import java.util.List;

import com.chitra.school.entities.Memo;

public interface MemoService {
	void save(Memo memo);
	List<Memo> listMemoByStudentId(String studentId);

}
