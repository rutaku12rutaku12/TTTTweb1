
console.log('update.js open');

// [1] 기존 정보 불러오기
const oninfo = async() =>{
    try{
        const option = { method : "GET"} 
        const response = await fetch( "/member/info" , option ); console.log(response);
        const data = await response.json(); console.log(data);
        
        const mno = document.querySelector('.mno').innerHTML = data.mno;
        const mid = document.querySelector('.mid').innerHTML = data.mid;
        const mname = document.querySelector('.mname').value = data.mname;
        const mphone = document.querySelector('.mphone').value = data.mphone;
    }catch (error){console.log(error);}
} 
oninfo();
// [2] 새로운 정보 수정하기
const onUpdate = async() =>{
    const mname = document.querySelector('.mname').value;
    const mphone = document.querySelector('.mphone').value;
    const obj = { mname , mphone };
    try{
        const option = { 
            method : "PUT",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/update" , option );console.log(response);
        const data = await response.json(); console.log(data);
    if( data == true ){
        alert('수정완료')
        location.href="/index.jsp"
    }else{
        alert('수정실패')
    }
    }catch (error){console.log(error);}
}