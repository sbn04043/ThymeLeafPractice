package com.nc13.thyme.controller;

import com.nc13.thyme.model.BoardDTO;
import com.nc13.thyme.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardController {
    private final BoardService BOARD_SERVICE;

    @GetMapping("showAll")
    public String showAll(Model model) {
        model.addAttribute("boardList", BOARD_SERVICE.selectAll());
        return "/board/showAll";
    }

    @GetMapping("showOne/{id}")
    public String showOne(Model model, @PathVariable int id) {
        model.addAttribute("board", BOARD_SERVICE.selectOne(id));
        model.addAttribute("logIn", 1);
        return "/board/showOne";
    }

    @GetMapping("write")
    public String write(Model model) {
        //빈 객체를 만들어 /board/write.html 로 보낸다.
        model.addAttribute("board", new BoardDTO());
        return "/board/write";
    }

    @PostMapping("write")
    public String write(BoardDTO board) {
        System.out.println(board);
        return "redirect:/board/showAll";
    }
}
