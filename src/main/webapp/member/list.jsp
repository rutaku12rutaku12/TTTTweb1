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
            <h3> 화면목록조회/수정</h3>
            <table border="1">
                <thead>
                    <tr>
                        <th>회원번호</th><th>회원성명</th><th>전화번호</th><th>주소</th><th>가입일자</th><th>고객등급</th><th>거주지역</th>
                    </tr>
                </thead>
                <tbody id="memberTbody">

                </tbody>
            </table>
        </div>
    
        <script src="/member/list.js"></script>
</body>
</html>