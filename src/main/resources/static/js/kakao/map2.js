
console.log('map2.js open');

const dataAPI = async () =>{
    // (1) 요청 URL , perPage=72 변경
    const URL = 'https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=72&serviceKey=lxvZMQzViYP1QmBRI9MrdDw5ZmsblpCAd5iEKcTRES4ZcynJhQxzAuydpechK3TJCn43OJmweWMoYZ10aspdgQ%3D%3D'
    // (2) fetch 공공데이터 API 요청
    const option = { method : "GET" }
    const response = await fetch( URL , option );
    const data = await response.json();
    console.log(data);
    console.log(data.data);
    // (3) JSP 표에 출력하기
    // 1. 어디에
    const sidebar = document.querySelector('#sidebar');
    // 2. 무엇을
    let html = '';
    data.data.forEach( ( value ) => {
        html +=`<div id="school">
                    <div> ${value.학교명}</div>
                    <div> ${value.주소}</div>
                    <div> ${value.교무실} </div>
                    <div> ${value.행정실} </div>
                </div>`
    });
    // 3. 출력
    sidebar.innerHTML = html;
}
dataAPI();

// [2] 카카오맵 , https://apis.map.kakao.com/web/sample/addClustererClickEvent/
const kakaomap = async () => {
    // (1) 지도를 표시할 div
    var map = new kakao.maps.Map(document.getElementById('map'), { 
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
        level : 10 // 지도의 확대 레벨
    });
    // (2) 마커 클러스터 ( 여러개 마커가 겹칠때 도형으로 마커수를 표현 ) 를 생성합니다.
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 4, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });

    // (3) FETCH 이용한 공공데이터 자료 활용
    const URL = 'https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=72&serviceKey=lxvZMQzViYP1QmBRI9MrdDw5ZmsblpCAd5iEKcTRES4ZcynJhQxzAuydpechK3TJCn43OJmweWMoYZ10aspdgQ%3D%3D'
    const response = await fetch( URL , { method : "GET" } );
    const data = await response.json();
    console.log(data); // 학교 정보

    // (4) map 반복문을 이용하여 마커를 하나씩 생성하여 return 한 마커를 makers 변수에 대입한다.
    let markers = data.data.map( (value) =>{
        // (5-1) 마커 생성
        let marker = new kakao.maps.Marker({
                position : new kakao.maps.LatLng(value.위도, value.경도) // 위도 Latitude 경도 Longitude
    });
        // (5-2) 마커 클릭 이벤트 넣기
        kakao.maps.event.addListener( marker, 'click' , () => {
            const sidebar = document.querySelector('#sidebar');
            let html = `<div id="school">
                             <div> ${value.학교명}</div>
                            <div> ${value.주소}</div>
                            <div> ${value.교무실} </div>
                            <div> ${value.행정실} </div>
                        </div>
                       <button type="button" onclick="dataAPI()"> 전체보기 </button>`
            sidebar.innerHTML = html;
                       
        })
        // (5-3) 마커 리턴
        return marker;
    });
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