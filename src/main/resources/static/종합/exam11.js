// 1. 연동 확인
console.log("1.exam11.js");

// 2. 함수 연동 확인
// 일반 함수 선언 : function 함수명(){ }
// 람다식 함수 선언 : const 함수명 = ( ) => { }
const boardWrite = ( ) => {
    console.log("boardWrite() exe")
    // 3. 함수 기능 구현 - fetch
    // (1) 보낼 데이터 객체 준비 - 샘플
    let data = { "bcontent" : "JS테스트중" , "bwriter" : "유재석"} //
    // (2) fetch 옵션 : 3가지 ( method , header , body )
    let option = {
    method : "POST", // (1) method
    headers : { "Content-Type" : "application/json" } , // (2) headers
    body : JSON.stringify( data )    // (3) body
    } // option end
    // (3) fetch( URL , option )
    // .then( response => response.json() ) // 응답자료를 타입변환
    // .then( data => { } )                 // 타입반환된 자료
    // .catch( error => { } )
    fetch( "/board" , option ).then( response => response.json() )
    .then( data => { console.log(data) } )
    .catch( error => { console.log(error) } )
} // func end

// 미리 const boardPrint() => 작성 시 연동 오류발생!

// 3. 전체조회
const boardPrint = ( ) => {
    console.log( "boardPrint() exe" )
    // (1) 보낼 데이터 - 없음
    // (2) fetch option , GET생략가능
    let option = { method : "GET" }
    // (3) fetch 실행
    fetch( "/board" , option)
    .then( response => response.json() )
    .then( data => {console.log(data) } )
    .catch( error => {console.log(error) } )
} // func end

// 4. 삭제
const boardDelete = ( ) => {
    console.log( "boardDelete() exe")
    // (1) 보낼 데이터 준비 - 샘플
    let bno = 3; // 존재하는 bno 아무거나
    // (2) fetch option
    let option = { method : "DELETE" }
    // (3) fetch 실행 , 쿼리스트링? 을 `백틱으로 표현
    fetch( `/board?bno=${bno}` , option )
        .then( response => response.json)
        .then( data => {console.log(data) } )
        .catch( error => {console.log(error) } )
} // func end

// 5. 수정
const boardUpdate = ( ) => {
    console.log("boardUpdate() exe")
    // (1) 보낼 데이터 준비 - 샘플
    let data = { bno : 5  , bcontent : "수정할내용" }
    let option = {
        method : "PUT", // (1) method
        headers : { "Content-Type" : "application/json" } , // (2) headers
        body : JSON.stringify( data )    // (3) body
        }
    fetch("/board" , option)
    .then( response => response.json)
    .then( data => {console.log(data) } )
    .catch( error => {console.log(error) } )
}