<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="true"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>後台資料庫管理系統</title>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/limonte-sweetalert2/6.6.6/sweetalert2.min.css">
  	<script charset="gb2312"　type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.6.9/sweetalert2.common.js"></script>
  	<script type="text/javascript">
  		// from spring session variable
  		var sessionToken = '<%= request.getSession().getAttribute("token") %>';
  		//var sessionToken = ${sessionScope.token};
  		// from localstorage
  		//console.log(sessionToken);
  		var token = sessionStorage.getItem('token');
  		//alert(sessionToken);
  		//alert(token);
  		//alert(typeof token);
  		if(token === null){
  			window.location.replace("unauthorized.do");
  		}
  	</script>
  </head>
  <body>
    <div id="container"></div>
  </body>
  <script type="text/javascript" language="javascript" src="cms/public/bundle.js"></script>
</html>
