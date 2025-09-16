package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;
import web.model.dto.PointDto;


@Service
@RequiredArgsConstructor
public class PointService {
    private final MemberDao memberDao;

    // [1] 포인트
    public int Point( PointDto pointDto){
        int result = memberDao.Point(pointDto);
        return result;
    }

