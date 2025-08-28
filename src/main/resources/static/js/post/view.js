
console.log('view.js open');

// [*] 현재 URL 경로상의 pno 매개변수값 가져오기 ( searchParams == queryString == ?매개변수명=값 )
const params = new URL( location.href).searchParams;
const pno = params.get('pno');

// [1] 개별조회
const getPost = async ()=>{
    try{// 1. 어디에 // fetch로 부터 출력할 게시물 조회 요청
        const response = await fetch( `/post/view?pno=${pno}`); // GET은 옵션생략 가능
        const data = await response.json();
        // 2. 무엇을 // 응답받은 자료를 특정한 html에 출력한다
        document.querySelector('.mid').innerHTML = data.mid;
        document.querySelector('.pview').innerHTML = data.pview;
        document.querySelector('.pdate').innerHTML = data.pdate;
        document.querySelector('.ptitle').innerHTML = data.ptitle;
        document.querySelector('.pcontent').innerHTML = data.pcontent;
        // 3. 출력 // 내가 쓴글이면 삭제버튼과 수정버튼 만들기
        if( data.host ){
            document.querySelector('.etcBox').innerHTML = 
                            `<button type="button" onclick="deletePost()"> 삭제 </button>
                            <button type="button" onclick="location.href='update.jsp?pno=${pno}'"> 수정 </button>
                            `
        }
    }catch(e){console.log(e)}
} // func end

// [2] 개별삭제
const deletePost = async() =>{
    // 1. fetch 
    const option = { method : "DELETE"}
    const response = await fetch( `/post?pno=${pno}`,option);
    const data = await response.json();
    // 2. fetch 응답
    if( data == true ){
        alert('삭제 성공');
        location.href = 'post.jsp?cno=1'
    }else{
        alert('삭제 실패');
    }
} // func end

// [3] 조회중인 게시물의 댓글쓰기

const writeReply = async () => {
    // 1. 전달할 데이터 준비
    const rcontent = document.querySelector('.rcontent').value;
    const obj = { pno , rcontent }
    // 2. fetch
    const option = {
        method : "POST" ,
        headers : {"content-type" : "application/json"},
        body : JSON.stringify(obj)
    }
    const response = await fetch(`/post/reply` , option);
    const data = await response.json();
    // 3. 
    if( data == 0){alert('등록실패');
    }else{alert('등록성공');
        // 전체 댓글 조회 재렌더링(재호출)
        findAllReply();
    }
} // func end

// [4] 조회중인 게시물의 전체 댓글 조회
const findAllReply = async () =>{
    try{// 1. fetch 이용한 현재 게시물의 전체 댓글 요청
        const response = await fetch( `/post/reply?pno=${pno}`); // GET은 옵션생략 가능
        const data = await response.json();
        // 2. fetch 응답 자료 html 형식으로 출력
        const replyList = document.querySelector('.replyList');
        // 3. 출력 
        let html = '';
            data.forEach( (reply) => { // data : [ {},{},{}], repley : {}}
                html +=`<div style="margin : 20px,0px;">
                            <div> 
                            작성자 : <span> ${reply.mid}</span>
                            작성일 : <span> ${reply.rdate}</span>
                            </div>
                            <div>
                                ${reply.rcontent}
                            </div>
                        </div>`
            })
            replyList.innerHTML=html;
    }catch(e){console.log(e)}
}

getPost(); // 최초 1회 실행
findAllReply();