package example.실습1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    @PostMapping("/exam1/board")
    @ResponseBody
    public boolean method1(){ // 1.글쓰기
        System.out.println("BoardController.method1");
        return true;
    }


    @GetMapping("/exam1/board")
    @ResponseBody
    public List<BoardDto > method2(){ // 2. 전체 글 조회
        System.out.println("BoardController.method2");
        ArrayList<BoardDto> list = new ArrayList<>(); // 임의데이터
        list.add( new BoardDto(1,  "제목1"));
        list.add( new BoardDto(2,  "제목2"));
        list.add( new BoardDto(3,  "제목3"));
        return list;
    }

    @GetMapping("/exam1/board/view")
    @ResponseBody
    public Map<Integer,String> method3(){ // 3. 개별 글 조회
        System.out.println("BoardController.method3");
        Map<Integer,String> map = new HashMap<>(); // 임의데이터
        map.put( 1, "제목1");
        return map;
    }

    @PutMapping("/exam1/board")
    @ResponseBody
    public boolean method4(){ // 4. 개별 글 수정
        System.out.println("BoardController.method4");
        return false;
    }

    @DeleteMapping("/exam1/board")
    @ResponseBody
    public BoardDto method5(){ // 개별 글 삭제
        System.out.println("BoardController.method5");
        BoardDto boardDto = new BoardDto();
        return boardDto;

    }


} // class end


















