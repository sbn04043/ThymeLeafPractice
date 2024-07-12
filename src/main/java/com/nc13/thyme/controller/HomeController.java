package com.nc13.thyme.controller;

import com.nc13.thyme.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final BoardService boardService;

    public HomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String showHome(Model model) {
        //List<BoardDTO> boardList = boardService.selectAll();
        //model.addAttribute("boardList", boardList);
        model.addAttribute("user", "홍길동");
        return "index";
    }
}
