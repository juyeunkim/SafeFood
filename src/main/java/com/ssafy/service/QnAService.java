package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.Comment;
import com.ssafy.vo.PageBean;
import com.ssafy.vo.QnA;

public interface QnAService {
	public void insert(QnA board);
	public void update(QnA board);
	public void delete(int no);
	public QnA search(int no);
	public List<QnA> searchAll();
	public List<QnA> searchKeyWord(PageBean bean);
	public int searchCount(PageBean bean);
	public void insertComment(Comment com);
	public void deleteComment(int cno);
	public int  getQno(int qno);
	public List<Comment> searchComments(int qno);
	
}
