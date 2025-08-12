package example.실습.실습5.service;

import example.실습.실습5.model.dao.WaitingDao;
import example.실습.실습5.model.dto.WaitingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaitingService {
    @Autowired private WaitingDao waitingDao;

    // [1] 등록
    public boolean waitingAdd(WaitingDto waitingDto){
        System.out.println("WaitingService.waitingAdd");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.waitingAdd( waitingDto );
        return result;
    } // m end

    // [2] 전체조회
    public List<WaitingDto> waitingPrint(){
        System.out.println("WaitingService.waitingPrint");
        List<WaitingDto> result = waitingDao.waitingPrint();
        return result;
    } // m end

    // [3] 개별조회
    public WaitingDto waitingFind( int wno ){
        System.out.println("WaitingService.waitingFind");
        System.out.println("wno = " + wno);
        WaitingDto result = waitingDao.waitingFind( wno );
        return result;
    } // m end

    // [4] 개별삭제
    public boolean waitingDelete( int wno ){
        System.out.println("WaitingService.waitingDelete");
        System.out.println("wno = " + wno);
        boolean result = waitingDao.waitingDelete(wno);
        return result;
    } // m end

    // [5] 개별수정
    public boolean waitingUpdate( WaitingDto waitingDto ){
        System.out.println("WaitingService.waitingUpdate");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.waitingUpdate( waitingDto );
        return result;
    } // m end

} // class end
















