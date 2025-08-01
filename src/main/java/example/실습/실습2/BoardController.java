package example.실습.실습2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BoardController {

    // 1. 게시물등록
    @PostMapping("/board")
    public boolean boardWrite(@RequestBody String bcontent , String bwriter){
        System.out.println("BoardController.boardWrite");
        System.out.println("bcontent = " + bcontent + ", bwriter = " + bwriter);
        return true;
    }


    // 2. 게시물 전체조회
    @GetMapping("/board")
    public ArrayList<BoardDto> boardPrint(){
        System.out.println("BoardController.boardPrint");
        ArrayList<BoardDto> boardDto = new ArrayList<>();
        boardDto.add( new BoardDto(1, "안녕하세요" ,  "유재석") );
        boardDto.add( new BoardDto(2, "안녕하세요2" ,  "강호동") );
        return boardDto;
    }

    // 3. 게시물 개별조회
    @GetMapping("/board/detail")
    public BoardDto boardDetail(@RequestParam int bno){
        ArrayList<BoardDto> boardDto = new ArrayList<>();
        boardDto.add( new BoardDto(1, "안녕하세요" ,  "유재석") );
        boardDto.add( new BoardDto(2, "안녕하세요2" ,  "강호동") );
        return boardDto.get(1);
    }

    // 4. 게시물 삭제
    @DeleteMapping("/board")
    public boolean boardDelete(@RequestParam int bno){
        ArrayList<BoardDto> boardDto = new ArrayList<>();
        boardDto.add( new BoardDto(1, "안녕하세요" ,  "유재석") );
        boardDto.add( new BoardDto(2, "안녕하세요2" ,  "강호동") );
                return true;

} // m end

    // 5. 게시물 수정
    @PutMapping("/board")
    public boolean boardUpdate( @RequestBody BoardDto boardDto) {
        ArrayList<BoardDto> dto = new ArrayList<>();
        dto.add(new BoardDto(1, "안녕하세요", "유재석"));
        dto.add(new BoardDto(2, "안녕하세요2", "강호동"));
        return true;

    } // m end

} // class end
