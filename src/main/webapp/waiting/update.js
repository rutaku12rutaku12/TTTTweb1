
console.log('update.js open');

// [1] 개별 조회 ( 수정 전 내용 확인)
const waitingFind = async () => {console.log("waitingFind exe");
    // 1. 현재 대기 번호 가져오기
    const wno = new URLSearchParams(location.search).get('wno');
    // 2. fetch 이용한 wno의 게시물정보 요청
    const response = await fetch(`/waiting/find?wno=${wno}`);
    const data = await response.json();
    // 3. 현재 대기 정보 수정하기 전 내용물 출력
    document.querySelector('.phone').innerHTML = data.phone;
    document.querySelector('.count').innerHTML = data.count;
}
waitingFind(); // JS 실행시 1번 실행 버튼없으므로

// [2] 개별 수정
const waitingUpdate = async () => { console.log("waitingUpdate exe");
    // 1. 현재 수정할 대기번호 가져오기
    const wno = new URLSearchParams( location.search).get('wno');
    // 2. 수정할 입력받은 값 가져오기
    const phone = document.querySelector('.phone').value;
    const count = document.querySelector('.count').value;
    // 3. 객체화
    const obj = {"wno":wno,"phone":phone,"count":count};
    // 4. fetch옵션
    const option = {
        method:"PUT",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(obj)
    }
    // 5.fetch 실행
    const response = await fetch("/waiting",option);
    const data = await response.json();
    // 6. fetch 결과
    if( data == true ){
        alert('수정 성공');
        location.href=`/waiting/view.jsp?wno=${wno}`
    }else{
        alert('수정 실패')
    }
} // func end
