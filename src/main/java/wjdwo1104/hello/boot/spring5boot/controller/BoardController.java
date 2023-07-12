package wjdwo1104.hello.boot.spring5boot.controller;



import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wjdwo1104.hello.boot.spring5boot.model.Board;
import wjdwo1104.hello.boot.spring5boot.service.BoardService;


@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final BoardService bsrv;

    Logger logger = LogManager.getLogger(BoardController.class);

    @GetMapping("/list/{cpg}")//@pathVariable를씀으로써 매개변수 cpg의 값을 주소에 쓸수있음
    public String list(Model m, @PathVariable Integer cpg){//moedl m? 컨트롤러는 모델이라는 타입의 객체를 파라미터로 받을수있다 m.addattribue?
        logger.info("board/list 호출");
        m.addAttribute("bds",bsrv.readBoard(cpg));//bsrv.readBoard()여기서 싱행된결과가 "bds"에 담김
        // bsrv.readBoard() 메서드를 호출하여 그 결과(게시판 목록)를 가져옴
        // 이 결과를 모델 객체에 "bds"라는 이름으로 추가. 이를 통해 뷰에서 이 데이터에 접근 가능
        m.addAttribute("cpg",cpg);//현재페이지
        return "board/list";
    }

    @GetMapping("/view/{bno}")
    public String view(Model m, @PathVariable String bno) {
        logger.info("board/view 호출!!");

        m.addAttribute("bd", bsrv.readOneBoard(bno));

        return "board/view";
    }

    @GetMapping("/write")
    public String write(){
        logger.info("board/write 호출");


        return "board/write";
    }

    @PostMapping("/write")
    public String writeok(Board b){
        logger.info("board/writeok 호출");
        String returnPage ="redirect:/board/fail";

        if(bsrv.saveBoard(b))
            returnPage = "redirect:/board/list/1";

        return returnPage;
    }



}
