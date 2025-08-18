
console.log('datamap.js open');

/*
    [ APP KEY 발급 ]
    1. https://apis.map.kakao.com/
    2. 로그인
    3. 상단 메뉴 -> [앱] 탭 -> [웹 생성]
    4. 
        앱이름 : springweb(아무거나)
        회사명 : 개발테스트(아무거나)
        카테고리 : 교육(아무거나)
        동의여부 체크
        [생성]
    5. 생성된 앱 클릭 -> 대시보드 접속
    6. 사이드바메뉴 ->[앱] -> [일반]-> 중간 스크롤  
        '앱 키' 확인 가능 , * JS 카카오지도 사용시 에는 'JAvaScript 키' 사용한다.
    7. '플랫폼' Web 주소 등록
        http//localhost:8080
        tp//192.168.40.5:8080
        * 추후에 배포단계에서는 실제 존재하는 도메인 또는 클라우드 ip를 동록한다.
    8. 사이브바메뉴-> [카카오맵]
        사용 설정 -> 활성화(on) , * 게정마다 카카오지도 1개만 활성화 가능 *

        

    [ KAKAO 지도 ]
    1. https://apis.map.kakao.com/
    2. [WEB] 클릭 -> 왼쪽 메뉴 -> [Guide] -> 시작하기
    
 */

// [1] 공공데이터 , 인천시 동구 약국 , https://www.data.go.kr/data/15051492/fileData.do#tab-layer-openapi

const dataAPI = async () =>{
    // 1. 공공데이터 준비
    const serviceKey ='lxvZMQzViYP1QmBRI9MrdDw5ZmsblpCAd5iEKcTRES4ZcynJhQxzAuydpechK3TJCn43OJmweWMoYZ10aspdgQ%3D%3D'
    const URL = 'https://api.odcloud.kr/api/15051492/v1/uddi:852bbc11-63ed-493e-ab09-caaaf54fd144?page=1&perPage=34&serviceKey='
    // 2. fetch 실행
    const response = await fetch( URL+serviceKey , { method : "GET" } );
    const data = await response.json();
    console.log(data);
    // 3. 사이드바 정보 출력하기(위도/경도 제외한->지도에서 사용) , 소재지도로명주소/약국명/전화번호
    const sidebar = document.querySelector('#sidebar');
    let html = '';
        data.data.forEach( (value)=>{
            html += `<div id="store">
                        <div> ${value.약국명} </div>
                        <div> ${value.전화번호} </div>
                        <div> ${value.소재지도로명주소} </div>
                    </div>`
        })
    sidebar.innerHTML = html;
}
dataAPI();

// [2] 카카오맵 , https://apis.map.kakao.com/web/sample/addClustererClickEvent/
const kakaomap = async () => {
    // (1) 지도를 표시할 div
    var map = new kakao.maps.Map(document.getElementById('map'), { 
    center : new kakao.maps.LatLng(36.2683, 127.6358), level : 10 });

    // (2) 마커 클러스터 ( 여러개 마커가 겹칠때 도형으로 마커수를 표현 ) 를 생성합니다
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 4, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });

    // (3) FETCH 이용한 공공데이터 자료 활용
    const serviceKey ='lxvZMQzViYP1QmBRI9MrdDw5ZmsblpCAd5iEKcTRES4ZcynJhQxzAuydpechK3TJCn43OJmweWMoYZ10aspdgQ%3D%3D'
    const URL = 'https://api.odcloud.kr/api/15051492/v1/uddi:852bbc11-63ed-493e-ab09-caaaf54fd144?page=1&perPage=34&serviceKey='
    const response = await fetch( URL+serviceKey , { method : "GET" } );
    const data = await response.json();
    console.log(data); // 약국 정보
    
    // (4) map 반복문을 이용하여 마커를 하나씩 생성하여 return 한 마커를 markers 변수(배열)에 대입한다.
    let markers = data.data.map( (value) =>{ // forEach 리턴없다 vs map 리턴있다.
        // (5-1) 마커 생성
        let marker = new kakao.maps.Marker({
                position : new kakao.maps.LatLng(value.위도, value.경도) // 위도 Latitude 경도 Longitude
        });
        // (5-2) 마커 클릭 이벤트 넣기  kakao.maps.event.addListener( marker, 'click' , () => { })
        kakao.maps.event.addListener( marker, 'click' , () => {
            // (*) 내가 클릭한 마커의 약구 정보를 사이드바특정html)에 출력하기
            const sidebar = document.querySelector('#sidebar');
            let html = `<div id="store">
                            <div> ${value.약국명} </div>
                            <div> ${value.전화번호} </div>
                            <div> ${value.소재지도로명주소} </div>
                        </div>
                        <button type="button" onclick="dataAPI()"> 전체보기 </button>`
            sidebar.innerHTML = html;
        })
        // (5-3) 마키 리턴
        return marker;
    }); // map end
    // (6) 여러개 마커를 가진 marker 변수를 클러스터에 등록
    clusterer.addMarkers(markers);
    // (7) 마커 클러스터에 클릭이벤트를 등록합니다.
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {
    // 현재 지도 레벨에서 1레벨 확대한 레벨
    var level = map.getLevel()-1;
    // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
    map.setLevel(level, {anchor: cluster.getCenter()});
    });
}
kakaomap();