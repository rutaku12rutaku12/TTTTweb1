
console.log('pwdupdate.js open');

// [1] 패스워드 수정

const onPwdUpdate = async() =>{ console.log('onPwdUpdate.exe');
    const oldpwd = document.querySelector('.oldpwd').value;
    const newpwd = document.querySelector('.newpwd').value;
    const obj = { oldpwd , newpwd };
    try{
        const option = { 
            method : "PUT",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/update/password" , option ); console.log(response);
        const data = await response.json(); console.log(data);
        if( data == true ){
            alert('비밀번호 수정 성공'); location.href="/index.jsp"
        }else{
            alert('비밀번호 수정 실패');
        }
    }catch (error){console.log(error);}
}
