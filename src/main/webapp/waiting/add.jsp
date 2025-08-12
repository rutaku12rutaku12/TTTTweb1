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
    <jsp:include page="/waiting/header.jsp"></jsp:include> <!-- 헤더.jsp 불러오기 -->
    
    <div>
        <h3> 대기 등록 페이지 </h3>
        연락처: <input class="phone"/></br>
        인원수: <input class="count"/></br>
        <button type="button" onclick="waitingAdd()"> 등록 </button>
    </div>
    
    <script src="/waiting/add.js"></script>
</body>
</html>