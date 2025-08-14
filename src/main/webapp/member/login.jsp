<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='/css/member/login.css'>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    
    <div id="container">
        <h3> 로그인 </h3>
        아이디 : <input type="text" class="idInput" id="idInput" placeholder="아이디 입력" /> <br/>
        패스워드 : <input type="password" class="pwdInput" id="pwdInput" placeholder="패스워드 입력" /> <br/>
        <button type="button" onclick="login()"> 로그인 </button> <br/>
        <a href="/member/signup.jsp"> 회원가입하기 </a>
        <a href="/memeber/find.jsp"> 아이디/비밀번호찾기 </a>
    </div>

    <script src="/js/member/login.js"></script>
</body>
</html>