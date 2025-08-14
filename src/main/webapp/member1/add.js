
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

    // 1-1 유효성검사
    if( custname == "" ){
        alert('회원성명이 입력되지 않았습니다.')
        return;
    }
    if( phone == "" ){
        alert('회원전화가 입력되지 않았습니다.')
        return;
    }
    if( address == "" ){
        alert('회원주소가 입력되지 않았습니다.')
        return;
    }
    if( grade == "" ){
        alert('고객등급이 입력되지 않았습니다.')
        return;
    }
    if( city == "" ){
        alert('도시코드가 입력되지 않았습니다.')
        return;
    }
    
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

// 조회 이동 함수
function memberPrint(){console.log('memberPrint')
    
    location.href =`/member/list.jsp`;
}