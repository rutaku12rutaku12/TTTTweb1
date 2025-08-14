
console.log('signup.js open');

// *** 유효성검사 체크리스트 ***
const signPass = [ false , false ]; 
// 초기값은 실패 , 0인덱스:아이디체크 , 1인덱스 : 연락처체크

// [1] 회원가입
const signup = async() =>{
    // 만약에 유효성검사 체크리스트에 false 가 존재하면 회원가입 진행 불가능.
    // JS배열내 요소찾기 함수 : 1. .indexOf() 2. .includes()
    if( signPass.includes(false)){
        alert('올바른 정보를 입력후 가능합니다.');
        return;
    }
    // 1. 입력받은 값의 마크업 가져오기 
    const idInput = document.querySelector('.idInput');
    const pwdInput = document.querySelector('.pwdInput');
    const nameInput = document.querySelector('.nameInput');
    const phoneInput = document.querySelector('.phoneInput');
    // 2. DOM객체에서 입력받은 값 가져오기
    const mid = idInput.value;
    const mpwd = pwdInput.value;
    const mname = nameInput.value;
    const mphone = phoneInput.value;
    // 3. 객체화
    const obj = { "mid" : mid , "mpwd" : mpwd , "mname" : mname , "mphone" : mphone }
    try{
    // 4. fetch 실행
        const option = { 
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/signup" , option );
        const data = await response.json();
    // 5. fetch 결과
    if( data > 0 ){
        alert('회원가입 성공')
        location.href="/member/login.jsp" // 메인페이지 이동
    }else{
        alert('회원가입 실패')
    }
    }catch(error){console.log(error);
    }
} // func end

// <마크업> 이벤트 : onClick( 해당 마크업을 클릭했을때 ) , onkeyup( 해당 마크업에 키를 떼었을때 )


// [2] 아이디중복검사 : 입력할때마다 발동
const idCheck = async() => {
    // 1. // 2.
    const mid = document.querySelector('.idInput').value;
    const idCheck = document.querySelector('.idCheck');
    // 2. 유효성검사1 길이검사
    if( mid.length < 6 ){ // 만약에 아이디가 6글자 미만이면 
        idCheck.innerHTML = "아이디는 6글자 이상으로 가능합니다."
        signPass[0] = false; // 유효성검사 상태 변경
        return; // 함수 강제 종료 함으로써 아래 코드는 실행안됨.
    }
    // 2. 유효성검사2 중복검사, /member/check?type=검사할속성명&data=${검사할데이터}
    // 3. fetch 실행
    try{
        const option = { method : "GET"}
        const response = await fetch( `/member/check?type=mid&data=${mid}` , option );
        const data = await response.json();
    // 4. fetch 결과 
    if( data == true ){
        idCheck.innerHTML = "사용중인 아이디 입니다."
        signPass[0] = false; // 유효성검사 상태 변경
    }else{
        idCheck.innerHTML = "사용가능한 아이디 입니다."
        signPass[0] = true; // 유효성검사 상태 변경
    }
    }catch{

    }
} 

// [3] 연락처중복검사 입력할때마다 발동
const phoneCheck = async() => {
    // 1. 입력받은 연락처 가져오기 
    const mphone = document.querySelector('.phoneInput').value;
    // 2. 결과 메시지를 출력할 dom객체 가져오기
    const phoneCheck = document.querySelector('.phoneCheck');
    
    // 3. 유효성 검사1 길이검사 , 만약에 입력받은 연락처가 13글자가 아니면 
    if( mphone.length != 13 ){
        phoneCheck.innerHTML = "-(하이픈) 포함한 13글자 연락처를 입력하세요." // 메시지 출력
        signPass[1] = false; 
        return; // 함수 종료
    }
    // 4. fetch 실행
    // 5. 유효성 검사2 중복검사
        try{
        const option = { method : "GET"}
        const response = await fetch( `/member/check?type=mphone&data=${mphone}` , option );
        const data = await response.json();
    // 6. fetch 결과
        if( data == true ){
            phoneCheck.innerHTML = "사용중인 전화번호 입니다."
            signPass[1] = false;
        }else{
            phoneCheck.innerHTML = "사용가능한 전화번호 입니다."
            signPass[1] = true; 
        }
    }catch(error){console.log(error)}
} 
