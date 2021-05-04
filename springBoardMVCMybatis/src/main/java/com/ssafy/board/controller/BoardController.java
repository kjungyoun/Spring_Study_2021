package com.ssafy.board.controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.PageBean;
import com.ssafy.board.model.service.BoardService;

@Controller
public class BoardController {
	
	 @Autowired
	 private BoardService boardService;
	 
	 @ExceptionHandler
	 public ModelAndView handler(Exception e) {
		 e.printStackTrace();
		 ModelAndView mav = new ModelAndView("ErrorHandler");
		 mav.addObject("msg", e.getMessage());
		 return mav;
	 }
	 
	 @GetMapping("/listBoard.do")
	 public String boardList(@ModelAttribute("bean") PageBean bean, Model model) {
		 model.addAttribute("list", boardService.searchAll(bean));
		 return "board/listBoard";
	 }
	 
	 @GetMapping("/searchBoard.do")
	 public String searchBoard(String no, Model model) {
		 model.addAttribute("board", boardService.search(no));
		 return "board/searchBoard";
	 }
	 
	 @GetMapping(value= {"/insertBoardForm.do","insertBoardForm.log"})
	 public String insertBoardForm() {
//		 return "board/boardInsert";
		 return "board/insertBoard";
	 }
	 
	 @PostMapping("/boardInsert.do")
	 public String insertBoard(Board board, HttpServletRequest request, HttpSession session) {
		 String dir = request.getRealPath("/");
		 System.out.println("Board......"+board);
		 board.setDir(dir);
		 board.setId((String)session.getAttribute("id"));
		 boardService.insertBoard(board);
		 return "redirect:listBoard.do";
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="download.do")
	 public void fileDown( HttpServletRequest req, HttpServletResponse res ,  String sfileName
				, String rfileName ){
			res.reset();
		        int len = 0;
		        byte[] buf = new byte[1024];
		        BufferedOutputStream out = null;
		        FileInputStream fis = null;
		        StringBuffer sb = new StringBuffer();
		        try{
		        	System.out.println("=================================");
		        	System.out.println("realFilename:"+sfileName);
		        	System.out.println("File Name = " +rfileName);
		        	System.out.println("=================================");	        	
		        	
		        	String dir = req.getRealPath("/");
		        	System.out.println("dir :"+dir);
		        	//다운 시켜줄 파일에 대한 경로를 지정한 파일 읽어줄 객체를 생성 
		        	fis = new FileInputStream(dir+"/resources/upload/"+sfileName);
		        	
		        	String agent = req.getHeader("User-Agent");
	                if(agent !=null&& agent.indexOf("MSIE 5.5") != -1 ) {
	                	res.setContentType("doesn/matter");
	                	res.setHeader("Content-Disposition", "filename=" + rfileName+ ";");
	                } else {
	                    System.out.println("Header = " + req.getHeader("user-agent"));
	                    res.setContentType("application/octet-stream");
	                    res.setHeader("Content-Disposition", "attachment;filename="+rfileName+ ";");
	                };
	                res.setHeader("Content-Transfer-Encoding", "binary;");
	                res.setHeader("Content-Length", "" + fis.available());
	                res.setHeader("Pragma", "no-cache;");
	                res.setHeader("Expires", "-1;");

	                out = new BufferedOutputStream(res.getOutputStream());

	                System.out.println("OutputStream 생성");
	                //파일의 끝이 아닐때까지 파일 정보를 읽는다. 
	                while ((len = fis.read(buf)) > 0) {
	                    out.write(buf, 0, len); //읽은 데이타를 출력 
	                }
	                System.out.println("OutputStream 완료");
	                out.flush(); //버퍼에 출력된 데이타를 강제로 출력 
	                System.out.println("OutputStream flush()");
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		        }
		        finally {
	                if (out != null)try{   out.close();}catch(Exception e){}
	                if (fis != null)try{   fis.close();}catch(Exception e){}
		        }
		}
}





