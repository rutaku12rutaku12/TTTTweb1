package 종합.예제12.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import 종합.예제12.model.dao.BoardDao;
import 종합.예제12.model.dto.BoardDto;
import 종합.예제12.service.BoardService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/board") // + 공통 URL
public class BoardController {
    @Autowired private BoardService boardService; // 의존성 주입

    // [1] 등록
    // HTTP 정의 : POST /board application/json "게시물등록
    // HTTP 매개변수 : "String bcontent String bwriter" { bcontent : "안녕하세요" , bwriter : "유재석" }
    // HTTP 응답변수 : boolean   " true : 저장성공 flase : 저장실패 "
    @PostMapping("") // localhost:8080/board
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardWrite");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService.boardWrite( boardDto ); // 서비스 호출 하고 응답을 반환
        return result;
    } // m end




    // [2] 전체조회
    @GetMapping("")
    public List<BoardDto> boardPrint( ){
        // dao 에게 전달후 결과를 받는다
        List<BoardDto> result = boardService.boardPrint( );
        // 결과를 리턴한다
        return result;
    } // m end

    // [3] 개별조회
    @GetMapping("/find") // localhost:8080/board/find?bno=1
    public BoardDto boardFind( @RequestParam int bno ){
        System.out.println("BoardController.boardFind");
        System.out.println("bno = " + bno);
        BoardDto result = boardService.boardFind( bno );
        return result;
    }



    // [4] 개별삭제
    @DeleteMapping("")
    public boolean boardDelete(@RequestParam int bno){
        System.out.println("BoardController.boardDelete");
        System.out.println("bno = " + bno);
        // dao 에게 삭제할 번호 전달후 결과를 받는다.
        boolean result = boardService.boardDelete( bno );
        // 결과를 리턴한다.
        return result;
    }

    // [5] 개별수정
    @PutMapping("")
    public boolean boardUpdate(@RequestBody BoardDto boardDto ){
        System.out.println("BoardController.boardUpdate");
        System.out.println("boardDto = " + boardDto);
        // dao에게 삭제할 번호 전달후 결과를 받는다.
        boolean result = boardService.boardUpdate( boardDto );
        // 결과를 리턴한다.
        return result;
    }

}// class end
