package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.dao.PointDao;
import web.model.dto.PointDto;


@Service
@RequiredArgsConstructor
public class PointService {
    private final PointDao pointDao;

    // [1] 포인트
    public int signPoint(PointDto pointDto) {
        int result = pointDao.signPoint(pointDto);
        return result;
    }
}

