
console.log('add.js open');

// [1] 등록
const waitingAdd = async () => {console.log('waitingAdd exe');
    // 1. 입력받은 데이터 가져오기
    const phone = document.querySelector('.phone').value;
    const count = document.querySelector('.count').value;
    // 2. 입력받은 데이터를 객체화 한다.
    const obj = {'phone' : phone , 'count' : count };
    // 3. fetch 옵션
    const option = {
        method : "POST", // HTTP METHOD 보내는방법
        headers : {"Content-Type" : "application/json"}, // HTTP HEADER 부가정보/설정
        body : JSON.stringify( obj ) // HTTP BODY 보내는내용물
        
        // 주의!! JS 대소문자 구분 
    }
    // 4. fetch 실행
    const response = await fetch("/waiting", option);
    // 5. 응답자료 타입변환
    const data = await response.json();
    // 6. 응답자료 확인
    if( data == true ){
        alert('대기등록 성공');
        location.href="/waiting/list.jsp"
    }else{
        alert('대기등록 실패')
    }
} // func end