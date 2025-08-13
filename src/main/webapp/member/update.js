
console.log('update.js open');

// [1] 수정 화면 조회

const memberFind = async () => { console.log('memberFind exe');
    // 1. URL 경로상의 쿼리스트링 가져오기 클릭한 custno 가져오기
        // (1) 경로상 웹주소 가져오기
        const url = new URLSearchParams( location.search);
        // (2) 웹주소에서 쿼리스트링 값 가져오기
        const custno = url.get('custno');
        console.log('custno:', custno);

    // 2. 클릭한 cusstno를 fetch로 통신하기 , 백틱`이용한 쿼리스트링 사용
    const response = await fetch(`/member/update?custno=${custno}`);
    console.log(response);
    const data = await response.json();
    console.log(data);
    // 3.현재 게시물의 수정하기 전 내용 출력
    
    // 3. 어디에
    const custnoBox = document.querySelector('.custno');
    // const custnameBox = document.querySelector('.custname');
    const phoneBox = document.querySelector('.phone');
    const addressBox = document.querySelector('.address');
    const joindateBox = document.querySelector('.joindate');
    const gradeBox = document.querySelector('.grade');
    const cityBox = document.querySelector('.city');
    // 4. 무엇을
    // const custno = data.custno; 없어도되네 ㅇㅅㅇ?;
    // const custname = data.custname;
    const phone = data.phone;
    const address = data.address;
    const joindate = data.joindate;
    const grade = data.grade;
    const city = data.city;
    // 5. 출력
    custnoBox.value = custno;
    // custnameBox.innerHTML = custname;
    phoneBox.value = phone;
    addressBox.value = address;
    joindateBox.value = joindate;
    gradeBox.value = grade;
    cityBox.value = city;
 
    document.querySelector('.custname').value = data.custname;

} // func end
memberFind(); // 최초 1회 실행

const memberUpdate = async () => { console.log('memberUpdate exe');
    // 1. 현재 수정할 회원번호 가져오기
    const custno = new URLSearchParams( location.search ).get('custno');
    // 2. 수정할 입력받은 값 가져오기
    // const custno = data.custno; 여기 수정하려면 어떻게하지?
    const custname = document.querySelector('.custname').value;
    const phone = document.querySelector('.phone').value;
    const address = document.querySelector('.address').value;
    const joindate = document.querySelector('.joindate').value;
    const grade = document.querySelector('.grade').value;
    const city = document.querySelector('.city').value;
    // 3. 객체화
    const obj = {"custno":custno , "custname":custname, "phone":phone, "address":address, "jointdate":joindate, "grade":grade,"city":city};
    // 4. fetch옵션
    const option = {
        method:"PUT",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(obj)
    }
    // 5. fetch 실행
    const response = await fetch("/member",option);
    const data = await response.json();
    // 6. fetch 결과
    if( data == true ){
        alert('수정 성공');
        location.href=`/member/list.jsp`
    }else{
        alert('수정 실패')
    }
} // func end

// 조회 이동 함수
function memberPrint(){console.log('memberPrint')
    
    location.href =`/member/list.jsp`;
}