
console.log('find.js open');

// [1] 
// const findId = async() =>{ console.log('findId exe');  
//     const mname = document.querySelector('.mname').value;
//     const mphone = document.querySelector('.mphone').value;
//     const obj = [{ "mname": mname}, { "mphone":mphone }];
//     try{ // fetch 실행
//         const option = { method : "POST",
//             headers : { "Content-Type" : "application/json"},
//             body : JSON.stringify( obj )}
//         const response = await fetch( "/member/find" , option ); 
//         console.log(response);
//         const data = await response.text(); 
//         console.log(data);
//         if( data ){ alert(`찾은 아이디는 : ${data} 입니다.`);
//         }else{ alert('회원정보 없음');}
//     }catch (error){console.log(error);}
    
// [1-1]
const findId = async() =>{ console.log('findId exe');  
    // 1. HTML 로 부터 사용자가 이름과 연락처를 입력받은 INPUT 마크업을 객체로(DOM) 가져오기
    // 2. 가져온 DOM 객체내 입력받은 값 가져오기
    // 3. 이름 과 연락처를 객체화 + 유효성검사 부가적인
    // 4. FETCH 이용하여 controller 매핑 통신하기 /member/findid?mname=&mphone=
    // 5. 통신한 결과 { msg: 결과메시지 } 출력하기

    const mname = document.querySelector('.mname').value;
    const mphone = document.querySelector('.mphone').value;
    try{ // fetch 실행
        const option = { method : "GET" };
        const response = await fetch( `/member/findid?mname=${mname}&mphone=${mphone}` , option ); 
        console.log(response);
        const data = await response.json(); 
        console.log(data);
        alert(data.msg)

    }catch (error){console.log(error);}
} // func end

// // [2]
// const findPwd = async() =>{ console.log('findPwd exe');  

//     const mid = document.querySelector('.mid').value;
//     const mphone = document.querySelector('.mphone').value;
//     const obj = { "mid":mid , "mphone":mphone };
//     try{
//         const option = { 
//             method : "PUT",
//             headers : { "Content-Type" : "application/json"},
//             body : JSON.stringify( obj )
//         }
//         const response = await fetch( "/member/find" , option );
//         console.log(response);
//         const data = await response.text();
//         console.log(data);
//         if (data.length == 6){
//             alert(`비밀번호를 ${data}로 변경합니다.`); location.href="/member/login.jsp"
//         }else{alert('회원정보 없음');}
//   }catch (error){console.log(error);}
// }

// [2-1]
const findPwd = async() =>{ console.log('findPwd exe');  

    const mid = document.querySelector('.mid').value;
    const mphone = document.querySelector('.mphone').value;
    try{
        const option = { method : "GET" };
        const response = await fetch( `/member/findpwd?mid=${mid}&mphone=${mphone}` , option );
        console.log(response);
        const data = await response.json();
        console.log(data);
        alert(`새 비밀번호는 ${data.msg}입니다.`);

  }catch (error){console.log(error);}

} // func end