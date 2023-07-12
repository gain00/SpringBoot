package wjdwo1104.hello.boot.spring5boot.controller;



import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wjdwo1104.hello.boot.spring5boot.service.BoardService;


@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final BoardService bsrv;

    Logger logger = LogManager.getLogger(BoardController.class);

    @GetMapping("/list")
    public String list(Model m){//moedl m? m.addattribue?
        logger.info("board 호출");
        m.addAttribute("bds",bsrv.readBoard());//bsrv.readBoard()여기서 싱행된결과가 "bds"에 담김
        // bsrv.readBoard() 메서드를 호출하여 그 결과(게시판 목록)를 가져옴
        // 이 결과를 모델 객체에 "bds"라는 이름으로 추가. 이를 통해 뷰에서 이 데이터에 접근 가능

        return "board/list";
    }



}
