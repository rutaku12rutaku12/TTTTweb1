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
    <jsp:include page="/header.jsp"></jsp:include>

    <div id="container">
        <div id="map" style="width:100%;height:450px;">

        </div>
        <div id="productDiv">

        </div>
    </div>

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b594c9ba2d5a4fcb4a34dffa19dd7a11&libraries=clusterer"></script>
    <script src="/js/kakao/position.js"></script>
    <script src="/js/product/list.js"></script>   
</body>
</html>