package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.entities.Memo;

public interface MemoDao {
	void save(Memo memo);
	List<Memo> listMemoByStudentId(String studentId);

}
