<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>

</head>
<body>
    <jsp:include page="/board/index.jsp"></jsp:include> <!-- header.jsp --> 
    <div>
        <h3> 여기는 조회 페이지 </h3>
        <a href="/board/write.jsp"> 글쓰기 </a>
        <table border="1">
            <thead>
                <tr><th> 번호 </th> <th> 내용 </th> <th> 작성자</th></tr>
            </thead>
            <tbody id="boardTbody">

            </tbody>
        </table>
    </div>

    <script src="/board/list.js"></script> <!-- js load -->
</body>
</html>