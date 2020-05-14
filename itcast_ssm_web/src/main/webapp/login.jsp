<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>小土猫的社员管理系统 | 登录页面</title>

<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="all-admin-index.html"><b>SEATEC</b>社员管理系统</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">登录系统</p>

			<form action="${pageContext.request.contextPath}/login.do" method="post">

				<div class="form-group has-feedback">
					<input type="text" name="username" class="form-control"
						placeholder="用户名" oninput=OnInputN(event) id="username">
					<span
							class="glyphicon glyphicon-envelope form-control-feedback"></span>
					<span id="span" style="color: red"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" id="password" class="form-control"
						placeholder="密码" oninput=OnInputP(event)>
					<span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
					<span id="pspan" style="color: red"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label><input type="checkbox"> 记住 下次自动登录</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" id="login"
								class="btn btn-primary btn-block btn-flat" disabled="disabled">登录</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<a href="#">忘记密码</a><br>


		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.2.3 -->
	<!-- Bootstrap 3.3.6 -->
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
	<script>

        //动态监控用户名框
        function OnInputN(event){
            var login=document.getElementById("login");
            var password=document.getElementById("password").value;
            var pspan=document.getElementById("pspan");
            var span=document.getElementById("span");
            //用户名密码都不为空，按钮可用
            if(event.target.value.length>0 && password.length>0){
                login.removeAttribute("disabled");
                span.innerText="";
                pspan.innerText="";
            }else{
                if(password.length==0 && event.target.value.length==0){
                    pspan.innerText="密码不能为空，请输入密码";
                    span.innerText="用户名不能为空，请输入用户名";
                }else if(event.target.value.length==0){
                    span.innerText="用户名不能为空，请输入用户名";
                    pspan.innerText="";
                }else{
                    span.innerText="";
                    pspan.innerText="密码不能为空，请输入密码";
                }
                login.setAttribute("disabled","disabled");
            }
        }

        //动态监控密码框
        function OnInputP(event){
            var login=document.getElementById("login");
            var username=document.getElementById("username").value;
            var pspan=document.getElementById("pspan");
            var span=document.getElementById("span");
            if(event.target.value.length>0 && username.length>0){
                span.innerText="";
                pspan.innerText="";
                login.removeAttribute("disabled");
            }else{
                if(username.length==0 && event.target.value.length==0){
                    pspan.innerText="密码不能为空，请输入密码";
                    span.innerText="用户名不能为空，请输入用户名";
                }else if(event.target.value.length==0){
                    span.innerText="";
                    pspan.innerText="密码不能为空，请输入密码";
                }else{
                    pspan.innerText="";
                    span.innerText="用户名不能为空，请输入用户名";
                }
                login.setAttribute("disabled","disabled");
            }
        }

		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>

</html>