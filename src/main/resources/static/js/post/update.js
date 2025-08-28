
console.log('update.js open');

// [*] 썸머노트 실행
$(document).ready(function() {
    $('#summernote').summernote({
    lang: 'ko-KR', // 썸머노트 메뉴들을 한글화 속성
    minHeight: 300, // 썸머노트 구역 최소높이    
    });
});

// [*] URL 주소상 쿼리스트링 PNO 가져오기
const params = new URL(location.href).searchParams;
const pno = params.get('pno'); // 수정할 게시물번호

// [1] 기존 게시물정보 가져오기
const getPost = async () =>{
    try{
        const option = { method : "GET"} 
        const response = await fetch( `/post/view?pno=${pno}` , option ); console.log(response);
        const data = await response.json(); console.log(data);
        document.querySelector('.cno').value = data.cno;
        document.querySelector('.ptitle').value = data.ptitle; // value vs innerHTML
        document.querySelector('.note-editable').innerHTML = data.pcontent;
        
    }catch (error){console.log(error);}
}
getPost();
// [2] 수정처리
const updatePost = async () =>{
const cno = document.querySelector('.cno').value;
const ptitle = document.querySelector('.ptitle').value;
const pcontent = document.querySelector('.note-editable').innerHTML;
const obj = {cno,ptitle,pcontent,pno};
try{
        const option = { 
            method : "PUT",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/post" , option );console.log(response);
        const data = await response.json(); console.log(data);
    if( data != 0 ){
        alert('수정완료')
        location.href=`/post/view.jsp?pno=${pno}`
    }else{
        alert('수정실패')
    }
    }catch (error){console.log(error);}

}