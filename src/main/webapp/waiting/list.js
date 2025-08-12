
console.log( 'list.js exe');

// [1] 전체조회
const waitingPrint = async () =>{ console.log('waitingPrint exe');

    // 1. fetch option 중 GET 은 생략가능
    const response = await fetch("/waiting");
    // 2. 응답자료 타입변환
    const data = await response.json();
    // 3. 어디에
    const waitingTbody = document.querySelector('#waitingTbody')
    // 4. 무엇을 
    let html = ''; // 초기값 빈칸
    for( let i = 0; i<data.length; i++ ){
        const waiting = data[i]; // i번째 dto 꺼내기
        html += `<tr>
                <td>${waiting.wno}</td>
                <td>
                    <a href="/waiting/view.jsp?wno=${waiting.wno}">
                    ${waiting.phone} ${waiting.count} 
                    </a>
                    ${waiting.wdate}
                </td>
                </tr>`
    }
    // 5. 출력
    waitingTbody.innerHTML = html;
} // func end

waitingPrint(); // 전체조회 함수 1번 실행