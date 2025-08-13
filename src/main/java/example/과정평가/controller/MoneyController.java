package example.과정평가.controller;

import example.과정평가.model.dto.MoneyDto;
import example.과정평가.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/money")
public class MoneyController {
    @Autowired private MoneyService moneyService;

    // [1] 전체조회
    @GetMapping("") // localhost:8080/money
    public List<MoneyDto> moneyPrint(){
        System.out.println("MoneyController.moneyPrint");
        List<MoneyDto> result = moneyService.moneyPrint();
        return result;
    } // m end

} // class end
