package example.과정평가.service;

import example.과정평가.model.dao.MoneyDao;
import example.과정평가.model.dto.MoneyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyService {
    @Autowired private MoneyDao moneyDao;

    // [1] 전체조회
    public List<MoneyDto> moneyPrint(){
        System.out.println("MoneyService.moneyPrint");
        List<MoneyDto> result = moneyDao.moneyPrint();
        return result;
    } // m end
} // class end
