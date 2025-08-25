<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='/css/member/find.css'>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    
    <div id="container">      
        <h3> 아이디 찾기 </h3>
        <div> 이름 : <input type="text" class = "mname"/> </div>
        <div> 연락처 : <input type="text" class = "mphone"/> </div> <br/>
        <button type="button" onclick="findId()"> 아이디 찾기  </button>
        <br/>
        <h3> 비밀번호 찾기 </h3>
        <div> 아이디 : <input type="text" class = "mid"/></div>
        <div> 연락처 : <input type="text" class = "mphone2"/> </div> <br/>
        <button type="button" onclick="findPwd()"> 비밀번호 찾기  </button>
    </div>

    <script src="/js/member/find.js"></script>
</body>
</html>
