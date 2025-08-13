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
            <h3> 홈쇼핑 회원 정보 수정 </h3>
            회원번호 : <div class="custno"></div>
            회원성명 : <div class="custname"></div>
            회원전화 : <div class="phone"></div>
            회원주소 : <div class="address"></div>
            가입일자 : <div class="joindate"></div>
            고객등급[A:VIP,B:일반,C:직원] : <div class="grade"></div>
            도시코드 : <div class="city"></div>
            <button type="button" onclick="memberUpdate()"> 수정 </button>
            <button type="button" onclick="memberPrint()"> 조회 </button>
        </div>
    
        <script src="/member/update.js"></script>
</body>
</html>



<!-- 
            회원번호 : <div class="custnoBox"></div>
            회원성명 : <div class="custnameBox"></div>
            회원전화 : <div class="phoneBox"></div>
            회원주소 : <div class="addressBox"></div>
            가입일자 : <div class="joindateBox"></div>
            고객등급[A:VIP,B:일반,C:직원] : <div class="gradeBox"></div>
            도시코드 : <div class="cityBox"></div>
-->