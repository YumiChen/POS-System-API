<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>後台資料庫管理系統管理員登入</title>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/limonte-sweetalert2/6.6.6/sweetalert2.min.css">
<script charset="utf-8"　type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.6.9/sweetalert2.common.js"></script>
	<style>
		*{
			font-family: Verdana,微軟正黑體;
			box-sizing: border-box;
  			transition: all .5s;
  			position: relative;
		}
		body,html{
			height: 100vh;
		}
		.main{
			min-width: 40vw;
			border: solid 1px gray;
  			border-radius: 1em;
  			padding: 1em 2em;
			position: absolute;
			display: inline-block;
			top: 50%;
			left: 50%;
			transform: translate(-50%,-50%);
		}
		.form-check{
			text-align: center;
		}
		#send{
			left: 50%;
			transform: translateX(-50%);
		}
		.title{
		    text-align: center;
		    font-weight: bold;
		    background-color: rgb(0, 123, 255);
		    color: white;
		    width: 50%;
		    margin: .8em auto;
		    border-radius: 1em;
		    padding: 0.2em;
		    font-size: 1.2em;
		}
		#passwordHelp,#useridHelp{
			color: red;
		}
		.hide{
			opacity: 0;
		}
	</style>
	<script type="text/javascript">
			var D = true;

			window.onload = function(){
				function click(event){
					event.preventDefault();
					var userid = document.getElementById("userid").value,
					password = document.getElementById("password").value,
					smalls = document.querySelectorAll("small");

					// check if the inputs are inputted, whether should the small tags show or not
					if((userid === "" || userid === null) &&(password === "" || password === null)){
						[].forEach.call(smalls,function(small){
							small.classList.remove("hide");
							 // exit if there's no value inputted
						});
						return;
					}else if(userid === "" || userid === null ){
						small[0].remove("hide");
						return;
					}else if(password === "" || password === null){
						small[1].remove("hide");
						return;
					}else{
						[].forEach.call(smalls,function(small){
							small.classList.add("hide");
						});
					}
					
					// fetch data
//					window.fetch("json/User/showone.do?id=" + encodeURIComponent(userid))
//									.then(function(response){
//										return response.text()
//									}).then(function(text) {
//									    return text ? JSON.parse(text) : {};
//									}).then(function(data){
//										var passwordVal = data.password;
//										if(data.password === null || data.password === undefined){
//											// alert that no such user exists
//											sweetAlert('Error','您輸入的使用者ID不存在','error');
											<%--session.setAttribute("token", false);--%>
//											return;
//									}
//										if(password == passwordVal){
//											if(data.authcode != 1){
//												sweetAlert('Error','您未被授權使用此網站','error');
//												return;
//											}
//											// set session and redirect
											<%--session.setAttribute("pass", true);--%>
//											window.location.replace("cms.do");
//										}else{
//											// alert that you've inputted the wrong password
//											sweetAlert('Error','您輸入的密碼錯誤','error');
//											return;
//										}
//									})
//								.catch((error)=>{
//										if(D) console.log(error);
//							  		sweetAlert('Error','網路發生錯誤','error');
//						  		});
											
					// fetch data
					window.fetch("auth.do?id=" + encodeURIComponent(userid) + "&password=" + encodeURIComponent(password))
									.then(function(response){
										return response.text()
									}).then(function(text) {
									    return text ? JSON.parse(text) : {};
									}).then(function(data){
										// success: boolean
										console.log(data);
										var success = data.success,
											mes = data.mes;
										if(success){
											// set session 
											sessionStorage.setItem('token', mes);
											window.location.replace("cms.do");
										}else{
											switch(mes){
												case 0:
													sweetAlert('Error','您輸入的使用者ID不存在','error');
													return;
												case 1:
													sweetAlert('Error','您輸入的密碼錯誤','error');
													return;
												case 2: 
													sweetAlert('Error','您未被授權使用此網站','error');
													return;
												default:
													sweetAlert('Error','網路發生錯誤','error');
													return;
											}
										}
									})
								.catch((error)=>{
										if(D) console.log(error);
							  		sweetAlert('Error','網路發生錯誤','error');
						  		});
					
					
					
					
					}
				(document.getElementById("send")).addEventListener("click",click);
			}
	</script>
</head>
<body>
	<form class="main">
		  <p class="title">管理員登入</p>
		  <div class="form-group">
		    <label for="exampleInputEmail1">User ID</label>
		    <input type="text" class="form-control" id="userid" aria-describedby="emailHelp" placeholder="Enter user ID...">
		    <small id="useridHelp" class="hide" color="red">請填寫使用者ID</small>
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Password</label>
		    <input type="password" class="form-control" id="password" placeholder="Password...">
		 	<small id="passwordHelp" class="hide" color="red">請填寫密碼</small>
		  </div>
		  <!--<div class="form-check">
		      <label class="form-check-label">
		      <input type="checkbox" class="form-check-input">
		      Check me out
		    </label>
		  </div>-->
		  <button type="submit" class="btn btn-primary" id="send">送出</button>
	</form>
</body>
</html>