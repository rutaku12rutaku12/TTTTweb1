
console.log('add.js open');

// [1] 등록
const memberAdd = async () => {console.log('memberAdd exe');
    // 1. 입력받은 데이터 가져오기
    const custname = document.querySelector('.custname').value;
    const phone = document.querySelector('.phone').value;
    const address = document.querySelector('.address').value;
    const joindate = document.querySelector('.joindate').value;
    const grade = document.querySelector('.grade').value;
    const city = document.querySelector('.city').value;
    // 2. 입력받은 데이터를 객체화 한다.
    const obj = {'custname' : custname , 'phone' : phone , 'address' : address , 'joindate' : joindate , 'grade' : grade , 'city' : city };
    console.log(obj);
    // 3. fetch 옵션
    const option = {
        method : "POST", // HTTP method 보내는 방법
        headers : {"Content-Type" : "application/json"}, // HTTP header 부가정보
        body : JSON.stringify( obj ) // HTTP body 보내는내용물
    }
    // 4. fetch 실행
    const response = await fetch("/member", option);
    // 5. 응답자료 타입변환
    const data = await response.json();
    console.log(data);
    // 6. 응답자료 확인
    if( data == true ){
        alert('회원등록 성공');
        location.href="/member/list.jsp"
    }else{
        alert('회원등록 실패')
    }
} // fucn end