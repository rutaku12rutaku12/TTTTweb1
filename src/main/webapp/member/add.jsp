<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>

</head>
<body>
        <jsp:include page="/member/header.jsp"></jsp:include>

        <div>
            <h3> 홈쇼핑 회원 등록</h3>
            회원번호(자동발생) : <input class="custno"/><br/>
            회원성명 : <input class="custname"/><br/>
            회원전화 : <input class="phone"/><br/>
            회원주소 : <input class="address"/><br/>
            가입일자 : <input class="joindate"/><br/>
            고객등급[A:VIP,B:일반,C:직원] : <input class="grade"/><br/>
            도시코드 : <input class="city"/><br/>
            <button type="button" onclick="memberAdd()"> 등록 </button>
            <button type="button" onclick="memberPrint()"> 조회 </button>
        </div>
    
        <script src="/member/add.js"></script>
</body>
</html>