
console.log('list.js exe');

// [1] 전체조회
const memberPrint = async () => { console.log('memberPrint exe');

    // 1. fetch option 중 GET 생략가능
    const response = await fetch("/member");
    // 2. 응답자료 타입변환
    const data = await response.json();
    // 3. 어디에
    const memberTbody = document.querySelector('#memberTbody')
    // 4. 무엇을
    let html = ''; // 초기값 빈칸
    for( let i = 0; i<data.length; i++){
        const member = data[i]; // i번째 dto 꺼내기
        html += `<tr>
                <td><a href="/member/update.jsp?cutno=${member.custno}">
                ${member.custno}</a></td>
                <td>${member.custname}</td>
                <td>${member.phone}</td>
                <td>${member.address}</td>
                <td>${member.joindate}</td>
                <td>${member.grade}</td>
                <td>${member.city}</td>
                </tr>`
    }
    // 5. 출력
    memberTbody.innerHTML = html;
} // func end

memberPrint(); // 전체조회 함수 1번 실행