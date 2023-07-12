package wjdwo1104.hello.boot.spring5boot.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/board")
public class BoardController {

    Logger logger = LogManager.getLogger(BoardController.class);

    @GetMapping("/list")
    public String board(){
        logger.info("board 호출");
        return "board/list";
    }



}
