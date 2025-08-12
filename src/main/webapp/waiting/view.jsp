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
            <h3> 대기 등록 상세 페이지</h3>
            연락처 : <div class="phoneBox"></div>
            인원수 : <div class="countBox"></div>
            등록 일시 : <div class="wdateBox"></div>
            <button type="button" onclick="waitingUpdateView()"> 수정 </button>
            <button type="button" onclick="waitingDelete()"> 삭제 </button>
        </div>
        
        <script src="/waiting/view.js"></script>
</body>
</html>