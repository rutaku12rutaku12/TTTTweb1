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
            <h3> 회원매출조회 </h3>
            <table border="1">
                <thead>
                    <tr>
                        <th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th>
                    </tr>
                </thead>
                <tbody id="priceTbody">

                </tbody>
            </table>
        </div>
        <script src="/member/price.js"></script>
</body>
</html>