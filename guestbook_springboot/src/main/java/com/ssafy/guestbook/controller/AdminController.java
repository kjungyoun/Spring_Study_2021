package com.ssafy.guestbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
@Api("Admin Controller API v1")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="회원 목록", notes="회원의 <big>전체목록</big>을 반환해줍니다.")
	@ApiResponses({
		@ApiResponse(code = 200, message="회원목록 OK"),
		@ApiResponse(code = 404, message="페이지 없음!!!"),
		@ApiResponse(code = 500, message="서버 에러!!!")
	})
	@GetMapping(value = "/user")
	public ResponseEntity<List<MemberDto>> userList() {
		List<MemberDto> list = userService.userList();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//			return new ResponseEntity(HttpStatus.NOT_FOUND);
//			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@ApiOperation(value="회원 등록", notes="회원 정보를 받아서 DB에 저장.")
	@PostMapping(value = "/user")
	public ResponseEntity<List<MemberDto>> userRegister(@RequestBody @ApiParam(value="회원 한명의 정보", required = true) MemberDto memberDto) {
		int cnt = userService.userRegister(memberDto);
		if(cnt != 0) {
			List<MemberDto> list = userService.userList();
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//			return new ResponseEntity<Integer>(cnt, HttpStatus.CREATED);
		} else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="회원 정보 검색", notes="회원 userid를 받아서 해당 회원 조회")
	@GetMapping(value = "/user/{userid}")
	public ResponseEntity<MemberDto> userInfo(@PathVariable("userid") @ApiParam(value="검색할 회원 id", required = true) String userid) {
		logger.debug("파라미터 : {}", userid);
		MemberDto memberDto = userService.userInfo(userid);
		if(memberDto != null)
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="회원 정보 수정", notes="회원 정보를 수정합니다.")
	@PutMapping(value = "/user")
	public ResponseEntity<List<MemberDto>> userModify(@RequestBody @ApiParam(value="수정할 회원 정보", required = true) MemberDto memberDto) {
		userService.userModify(memberDto);
		List<MemberDto> list = userService.userList();
		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value="회원 삭제", notes="회원 정보를 삭제합니다.")
	@DeleteMapping(value = "/user/{userid}")
	public ResponseEntity<List<MemberDto>> userDelete(@PathVariable("userid") @ApiParam(value="삭제할 회원 정보") String userid) {
		userService.userDelete(userid);
		List<MemberDto> list = userService.userList();
		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
	}
	
}
