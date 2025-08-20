
console.log('find.js open');

const findId = async() =>{ console.log('findId exe');  
    const mname = document.querySelector('.mname').value;
    const mphone = document.querySelector('.mphone').value;
    const obj = [{ "mname": mname}, { "mphone":mphone }];
    try{ // fetch 실행
        const option = { method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )}
        const response = await fetch( "/member/find" , option ); 
        console.log(response);
        const data = await response.text(); 
        console.log(data);
        if( data ){ alert(`찾은 아이디는 : ${data} 입니다.`);
        }else{ alert('회원정보 없음');}
        
   
    }catch (error){console.log(error);}
    
} 

const findPwd = async() =>{ console.log('findPwd exe');  

    const mid = document.querySelector('.mid').value;
    const mphone = document.querySelector('.mphone').value;
    const obj = { "mid":mid , "mphone":mphone };
    try{
        const option = { 
            method : "PUT",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/find" , option );
        console.log(response);
        const data = await response.text();
        console.log(data);
        if (data.length == 6){
            alert(`비밀번호를 ${data}로 변경합니다.`); location.href="/member/login.jsp"
        }else{alert('회원정보 없음');}
  }catch (error){console.log(error);}

}