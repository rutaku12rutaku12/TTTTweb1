
console.log('view.js open');

// [1] 개별조회
const waitingFind = async() => {console.log('waitingFind exe');
    // 1. URL 경로상의 쿼리스트링 가져오기 클릭한 wno 가져오기
        // (1) 경로상 웹주소 가져오기 
        const url = new URLSearchParams( location.search);
        // (2) 웹주소에서 쿼리스트링 값 가져오기 
        const wno = url.get('wno');
    // 2. 클릭한 wno를 fetch로 통신하기 , 백틱`이용한 쿼리스트링 사용
    const response = await fetch(`/waiting/find?wno=${wno}`);
    const data = await response.json();
    // 3. 어디에
    const phoneBox = document.querySelector('.phoneBox');
    const countBox = document.querySelector('.countBox');
    const wdateBox = document.querySelector('.wdateBox');
    // 4. 무엇을
    const phone = data.phone;
    const count = data.count;
    const wdate = data.wdate;
    // 5. 출력
    phoneBox.innerHTML = phone;
    countBox.innerHTML = count;
    wdateBox.innerHTML = wdate;
} // func end

waitingFind(); // 최초 1회 실행

// [2] 삭제
const waitingDelete = async () => { console.log('waitingDelete exe');
    // 1. 현재 삭제할 게시물 번호 주소에서 가져오기
    const wno = new URLSearchParams( location.search).get('wno')
    // 2. 확인
    let check = confirm('정말 삭제 하시겠습니까?');
    if( check == true ){
        // 3. fetch
        const option = { method : "DELETE"}
        const response = await fetch(`/waiting?wno=${wno}`,option);
        const data = await response.json();
        // 4. 
        if( data == true ){
            alert('삭제 성공');
            location.href="/waiting/list.jsp"
        }else{
            alert('삭제 실패');
        }
    } // if end
} // func end

// [3] 수정페이지로 이동
const waitingUpdateView = () =>{
    // 1. 현재 수정할 대기번호 가져오기
    const wno = new URLSearchParams( location.search).get('wno');
    // 2. 수정페이지에게 wno 전달하기
    location.href=`/waiting/update.jsp?wno=${wno}`;
}

































