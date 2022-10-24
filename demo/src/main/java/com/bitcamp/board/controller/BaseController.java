package com.bitcamp.board.controller;

import com.bitcamp.board.config.auth.SessionUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@BaseController
public class BaseController {
  private final HttpSession httpSession;

  @GetMapping("/")
  public String index(Model model){

    SessionUser user = (SessionUser) httpSession.getAttribute("user");

    if(user != null) {
      model.addAttribute("userName", user.getName());
      model.addAttribute("userImg", user.getPicture());
    }

    return "index";
  }
}


