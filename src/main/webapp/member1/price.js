
console.log('price.js exe');

// [1] 매출조회

const moneyPrint = async () => {console.log('moneyPrint exe');

    // 1. fetch option 중 GET은 생략가능
    const response = await fetch("/money");
    // 2. 응답자료 타입변환
    const data = await response.json();
    // 3. 어디에
    const priceTbody = document.querySelector('#priceTbody');
    // 4. 무엇을
    let html = ''; // 초기값 빈칸
    for( let i = 0; i<data.length; i++){
        const member = data[i]; // i번째 dto 꺼내기
        html +=`<tr>
                <td>${member.custno}</td>
                <td>${member.custname}</td>
                <td>${member.grade}</td>
                <td>${member.매출}</td>
                </tr>`
    }
    // 5. 출력
    priceTbody.innerHTML = html;
}

moneyPrint(); // 매출조회 함수 1번 실행