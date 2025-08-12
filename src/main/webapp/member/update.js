
console.log('update.js open');

const memberFind = async () => { console.log('memberFind exe');
    // 1. URL 경로상의 쿼리스트링 가져오기 클릭한 custno 가져오기
        // (1) 경로상 웹주소 가져오기
        const url = new URLSearchParams( location.search);
        // (2) 웹주소에서 쿼리스트링 값 가져오기
        const custno = url.get('custno');
    // 2. 클릭한 cusstno를 fetch로 통신하기 , 백틱`이용한 쿼리스트링 사용
    const response = await fetch(`/member/find?custno=${custno}`);
    const data = await response.json();
    // 3. 어디에
    // const custnoBox = document.querySelector('.custnoBox');
    const custnameBox = document.querySelector('.custnameBox');
    const phoneBox = document.querySelector('.phoneBox');
    const addressBox = document.querySelector('.addressBox');
    const joindateBox = document.querySelector('.joindateBox');
    const gradeBox = document.querySelector('.gradeBox');
    const cityBox = document.querySelector('.cityBox');
    // 4. 무엇을
    // const custno = data.custno;
    const custname = data.custname;
    const phone = data.phone;
    const adress = data.adress;
    const joindate = data.joindate;
    const grade = data.grade;
    const city = data.city;
    // 5. 출력
    custnameBox.innerHTML = custname;
    phoneBox.innerHTML = phone;
    addressBox.innerHTML = adress;
    joindateBox.innerHTML = joindate;
    gradeBox.innerHTML = grade;
    cityBox.innerHTML = city;

} // func end