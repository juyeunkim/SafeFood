package com.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.service.QnAService;
import com.ssafy.vo.Comment;
import com.ssafy.vo.PageBean;
import com.ssafy.vo.QnA;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
public class RestFulMainController {
	@Autowired
	private QnAService qservice;
	
	@ExceptionHandler
	public ResponseEntity<Map<String, Object>> handle(Exception e){
		return handleFail(e.getMessage(),HttpStatus.OK);
	}
	
	@ApiOperation("QnA 등록")
	@PostMapping("/qna")
	public ResponseEntity<Map<String, Object>> addQnA(@RequestBody QnA board) { // @RestController이어도 @RequestBody 생략하면 안됨.
		System.out.println("addEmployee.........................."+board);
		qservice.insert(board);
		
		return handleSuccess("등록 성공");
	}
	
	@ApiOperation("QnA 수정")
	@PutMapping("/qna")
	public ResponseEntity<Map<String, Object>> updateQnA(@RequestBody QnA board) { // @RestController이어도 @RequestBody 생략하면 안됨.
		System.out.println("updateEmployee.........................."+board);
		qservice.update(board);
		
		return handleSuccess("수정 성공");
	}
	
	@ApiOperation("QnA 삭제")
	@DeleteMapping("/qna/{no}")
	public ResponseEntity<Map<String, Object>> deleteQnA(@PathVariable int no) { 
		System.out.println("deleteEmployee.........................."+no);
		qservice.delete(no);
		return handleSuccess("삭제 성공");
	}
	
	@ApiOperation("모든 Qna 정보 가져오기")
	@GetMapping("/qna")
	public ResponseEntity<Map<String, Object>> searchAllQnA() { 
		System.out.println("searchAll..........................");
		List<QnA> list = qservice.searchAll();
		for (QnA qnA : list) {
			System.out.println(qnA);
		}
		return handleSuccess(list);
	}
	
	@ApiOperation("QnA 번호로 QnA 정보 가져오기")
	@GetMapping("/qna/{no}")
	public ResponseEntity<Map<String, Object>> searchQnAById(@PathVariable int no) { 
		System.out.println("searchQnAById.........................."+no);
		QnA board = qservice.search(no);
		return handleSuccess(board);
	}
	
	@ApiOperation("댓글 추가하기")
	@PostMapping("/qna/comment")
	public ResponseEntity<Map<String, Object>> addComment(@RequestBody Comment com) { 
		System.out.println("addComment.........................."+com);
		qservice.insertComment(com);
		System.out.println("ADQSD");
		return handleSuccess("댓글 등록 성공");
	}
	
	@ApiOperation("댓글 삭제하기")
	@DeleteMapping("/qna/comment/{cno}")
	public ResponseEntity<Map<String, Object>> deleteComment(@PathVariable int cno) { 
		System.out.println("deleteEmployee.........................."+cno);
		qservice.deleteComment(cno);
		return handleSuccess("댓글 삭제 성공");
	}
	
	@ApiOperation("모든 댓글 정보 가져오기")
	@GetMapping("/qna/comment/{qno}")
	public ResponseEntity<Map<String, Object>> searchComments(@PathVariable int qno) {
		System.out.println(qno);
		System.out.println("searchComments..........................");
		System.out.println(111111111);
		List<Comment> list = qservice.searchComments(qno);
		
		return handleSuccess(list);
	}
	
	public ResponseEntity<Map<String, Object>> handleFail(Object data, HttpStatus state){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("state", "fail");
		resultMap.put("data", data);
		return new ResponseEntity<Map<String, Object>>(resultMap,state);
	}
	
	public ResponseEntity<Map<String, Object>> handleSuccess(Object data){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("state", "ok");
        resultMap.put("data", data);
        return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
    }
}
