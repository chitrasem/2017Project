package com.chitra.school.service;

import java.util.List;

import com.chitra.school.model.Memo;

public interface MemoService {
	void save(Memo memo);
	List<Memo> listMemoByStudentId(String studentId);

}
