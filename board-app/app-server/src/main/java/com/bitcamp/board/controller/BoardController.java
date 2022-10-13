package com.bitcamp.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.BoardService;


//CRUD 요청을 처리하는 페이지 컨트롤러들을 한 개의 클래스로 합친다.
@Controller 
@RequestMapping("/board/")
public class BoardController {


  ServletContext sc;
  BoardService boardService;


  public BoardController(BoardService boardService, ServletContext sc) {
    this.boardService = boardService;
    this.sc = sc; //ServletContext 객체는 생성자를 통해 주입 받는다.
  }

  // InternalResourceViewResolver 설정 전 
  //  @GetMapping("form")
  //  public String form() throws Exception {
  //    return "board/form";
  //  }

  // InternalResourceViewResolver 설정 후 
  @GetMapping("form")
  public void form() throws Exception {

  }



  @PostMapping("add") 
  public String add(
      Board board,
      MultipartFile[] files, //여러개가 넘어올때는 배열(files라는 이름으로)
      HttpSession session) throws Exception {

    board.setAttachedFiles(saveAttachedFiles(files)); //저장된 첨부파일을 담고(setAttachedFiles)
    board.setWriter((Member) session.getAttribute("loginMember"));

    // 서비스 객체에 업무를 맡긴다.
    boardService.add(board);
    return "redirect:list";
  }

  private List<AttachedFile> saveAttachedFiles(MultipartFile[] files) throws IOException, ServletException {
    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/board/files");

    for (MultipartFile part : files) {
      if (part.isEmpty()) { // 만약 비어있다면 
        continue;
      }

      String filename = UUID.randomUUID().toString();
      part.transferTo(new File( dirPath + "/" + filename));
      // 파일 경로를 파일 객체에 담아서 넘겨야 한다. 

      attachedFiles.add(new AttachedFile(filename));
    }
    return attachedFiles;
  }


  private List<AttachedFile> saveAttachedFiles(Part[] files) throws IOException, ServletException {
    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/board/files");

    for (Part part : files) {
      if (part.getSize() == 0) {
        continue;
      }

      String filename = UUID.randomUUID().toString();
      part.write(dirPath + "/" + filename);
      attachedFiles.add(new AttachedFile(filename));
    }
    return attachedFiles;
  }

  @GetMapping("list")
  public void list(Model model)  throws Exception {
    model.addAttribute("boards", boardService.list());
  }

  @GetMapping("detail") // 요청이 들어 왔을 때 호출될 메서드에 붙이는 애노테이션
  public Map detail(int no) throws Exception {

    Board board = boardService.get(no);
    if (board == null) {
      throw new Exception("해당 번호의 게시글이 없습니다!");
    }

    Map map = new HashMap();
    map.put("board", board);
    return map;
  }

  @PostMapping("update")      
  public String update(
      Board board,
      Part[] files, // 서블릿에 있는 파트
      HttpSession session) throws Exception {

    //게시글 정보를 만든다.
    board.setAttachedFiles(saveAttachedFiles(files));

    //오너 여부를 검사한다.
    checkOwner(board.getNo(),session);

    if (!boardService.update(board)) {
      throw new Exception("게시글을 변경할 수 없습니다!");
    }
    return "redirect:list";
  }

  //오너 여부를 검사한다.
  private void checkOwner(int boardNo, HttpSession session) throws Exception {
    Member loginMember = (Member) session.getAttribute("loginMember");
    if (boardService.get(boardNo).getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }

  }


  @GetMapping("delete")
  public String delete(
      int no,
      HttpSession session)
          throws Exception {

    //오너 여부를 검사한다.
    checkOwner(no,session);

    if (!boardService.delete(no)) {
      throw new Exception("게시글을 삭제할 수 없습니다.");
    }

    return "redirect:list";
  }

  @GetMapping("fileDelete")
  public String fileDelete(
      int no,
      HttpSession session
      ) throws Exception {

    AttachedFile attachedFile = boardService.getAttachedFile(no); 

    Member loginMember = (Member) session.getAttribute("loginMember");
    Board board = boardService.get(attachedFile.getBoardNo()); 

    if (board.getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }

    if (!boardService.deleteAttachedFile(no)) {
      throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
    }

    return"redirect:detail?no=" + board.getNo();
  }

}





