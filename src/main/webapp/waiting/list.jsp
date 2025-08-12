<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 20px;
    }

    h3 {
        color: #343a40;
    }

    a {
        display: inline-block;
        margin-bottom: 15px;
        padding: 8px 16px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border-radius: 4px;
    }

    a:hover {
        background-color: #0056b3;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background-color: white;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    th, td {
        border: 1px solid #dee2e6;
        padding: 12px;
        text-align: center;
    }

    th {
        background-color: #e9ecef;
        font-weight: bold;
    }

    tr:nth-child(even) {
        background-color: #f1f3f5;
    }

    tr:hover {
        background-color: #f8f9fa;
    }

    div {
        max-width: 900px;
        margin: 0 auto;
    }
</style>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
    
    <jsp:include page="/waiting/header.jsp"></jsp:include> <!-- 헤더.jsp 불러오기 -->
    <div>
        <h3> 대기목록 전체 조회 페이지</h3>
        <a href="/waiting/add.jsp"> 글쓰기 </a>
        <table border="1">
            <thead>
                <tr>
                    <th> 대기번호 </th>
                    <th> 연락처 </th>
                    <th> 인원수 </th>
                    <th> 등록 일시 </th>
                </tr>
            </thead>
            <tbody id="waitingTbody">

            </tbody>
        </table>
    </div>
    
    <script src="/waiting/list.js"></script> <!-- list.js 불러오기-->
</body>
</html>