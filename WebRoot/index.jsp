<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>book</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-ej.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/iziModal.css">

<script src="${pageContext.request.contextPath}/js/dropdown.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/wow.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.singlePageNav.min.js"></script>
<script src="${pageContext.request.contextPath}/js/iziModal.js"></script>
</head>
  
<body>
<!--导航-->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container wow bounceInRight" data-wow-delay="0.3s">
		<div class="col-md-3">
			<a href="index.jsp" class="navbar-brand">EJBook</a>
		</div>
		<div class="col-md-6">
			<div class="navbar-header">
				<button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right text-center">
					<li><a href="${pageContext.request.contextPath}/jsp/book/book.jsp">书籍</a></li>
					<li><a href="#art">开发</a></li>
					<li><a href="#movie">APP</a></li>
					<c:if test="${empty sessionScope.user}">
						<li><a href="#" class="trigger-custom">登录/注册</a></li>
					</c:if>
					<c:if test="${not empty sessionScope.user}">
						<li><a href="" onclick="window.open('${pageContext.request.contextPath}/jsp/user/user-description.jsp');">欢迎您：${sessionScope.user.username}</a></li>
						<li><a href="" onclick="window.location.href='${pageContext.request.contextPath}/logout.action';">注销</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="col-md-3">

		</div>
	</div>
</nav>
<!--导航-->

<!--登录注册-->
<div id="modal-custom" class="iziModal">
	<button data-iziModal-close class="icon-close"></button>
	<header>
		<a href="" id="signin">登录</a>
		<a href="" class="active">新用户</a>
	</header>
	<section class="hide">
		<form action="${pageContext.request.contextPath}/login.action" method="post">
			<input type="text" placeholder="用户名(6-16位字符或数字)" name="username">
			<input type="password" placeholder="密码(6-16位字符或数字)" name="password">
		<footer>
			<button data-iziModal-close>取消</button>
			<button type="submit">登录</button>            
		</footer>
		</form>
	</section>
	<section>
		<form action="register.action" method="post">
			<input type="text" id="username" placeholder="用户名(6-16位字符或数字)" name="username">
			<span id="isValid"></span>
			<input type="password" placeholder="密码(6-16位字符或数字)" name="password">
			<label for="check"><input type="checkbox" name="checkbox" id="check" value="1">我同意该<u>用户协议</u>.</label>
			<footer>
				<button data-iziModal-close>取消</button>
				<button type="submit">创建账号</button>            
			</footer>
		</form>

	</section>
</div>
<!--登录注册-->


<!--热门书-->
<section id="book">
	<div class="container">
		<div class="row text-center">
			<h1 class="wow bounceIn" data-wow-offset="200">热书</h1>
			<hr>
			<div class="col-md-6 col-xs-12 wow bounceInUp" data-wow-delay="0.1s">
				<a href=""><img src="img/围城.jpg" width="333" height="500" class="img-responsive" alt=""></a>
			</div>
			<div class="col-md-6 col-xs-12">
				<div class="row">
					<div class="col-md-6 col-xs-6 wow bounceInLeft" data-wow-delay="0.2s">
						<a href=""><img src="img/老人与海.jpg" class="img-responsive h" alt=""></a>
					</div>
					<div class="col-md-6 col-xs-6 wow bounceInRight" data-wow-delay="0.3s">
						<a href=""><img src="img/骆驼祥子.jpg" class="img-responsive h" alt=""></a>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6 wow bounceInLeft" data-wow-delay="0.4s">
						<a href=""><img src="img/沉沦.jpg" class="img-responsive h" alt=""></a>
					</div>
					<div class="col-md-6 col-xs-6 wow bounceInRight" data-wow-delay="0.5s">
						<a href=""><img src="img/呼啸山庄.jpg" class="img-responsive h" alt=""></a>
					</div>
				</div>
			</div>
		</div>
		<div class="row text-center">
			<a href="${pageContext.request.contextPath}/jsp/book/book.jsp" class="btn btn-default wow bounceIn" data-wow-offset="200" style="margin: 50px auto;">更多书籍＞＞</a>
		</div>
	</div>
</section>
<!--热门书-->

<!---->
<section id="art">
		<div class="container-fluid">
			<div class="row">
				<main>
					<div class="cd-fixed-bg cd-fixed-bg-content-1">
						<div class="cd-fixed-bg__content">
							<h1>在书籍中净化灵魂</h1>
							<a class="cd-nugget-info" href="${pageContext.request.contextPath}/jsp/book/book.jsp" target="_blank">点此进入</a>
						</div>
					</div> <!-- cd-fixed-bg -->

					<div class="cd-scrolling-bg cd-scrolling-bg-color">
						<div class="cd-scrolling-bg_content wow bounceIn" data-wow-offset="200">
							<p>
								<h1>书籍是人类进步的阶梯  ——————高尔基</h1>
							</p>
						</div> <!-- cd-scrolling-bg__content -->
					</div> <!-- cd-scrolling-bg -->

					<div class="cd-fixed-bg cd-fixed-bg-content-2">
						<h2></h2>
					</div>
				</main>
			</div>
		</div>
	</section>
<!---->
</body>
</html>
<script>

$(function(){
	//注册用户名重复
	$("#username").bind(' input propertychange',function(){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/judge.action?username="+document.getElementById("username").value,
			dataType:"json",
			processData:false,
			success:function(data){
				$("#isValid").html(data);
			}
		});
	});
});
	
//注册判断
if("${message}"=="registerSuccess"){
	alert("注册成功");
}
	new WOW().init();
	
	
	//初始化izimodal
	$("#modal-custom").iziModal({
	        overlayClose: false,
	        width: 600,
	        autoOpen: false,
	        overlayColor: 'rgba(0, 0, 0, 0.6)',
	        onOpened: function() {
	            console.log('onOpened');
	        },
	        onClosed: function() {
	            console.log('onClosed');  
	        }
	    });
	    $(document).on('click', '.trigger-custom', function (event) {
	        event.preventDefault();
	        $('#modal-custom').iziModal('open');
	    });
	    $("#modal-custom").on('click', 'header a', function(event) {
	        event.preventDefault();
	        var index = $(this).index();
	        $(this).addClass('active').siblings('a').removeClass('active');
	        $(this).parents("div").find("section").eq(index).removeClass('hide').siblings('section').addClass('hide');

	        if( $(this).index() === 0 ){
	            $("#modal-custom .iziModal-content .icon-close").css('background', '#ddd');
	        } else {
	            $("#modal-custom .iziModal-content .icon-close").attr('style', '');
	        }
	    });

	    $("#modal-custom").on('click', '.submit', function(event) {
	        event.preventDefault();

	        var fx = "wobble",  //wobble shake
	            $modal = $(this).closest('.iziModal');

	        if( !$modal.hasClass(fx) ){
	            $modal.addClass(fx);
	            setTimeout(function(){
	                $modal.removeClass(fx);
	            }, 1500);
	        }
	    });
	    
	    //单页导航插件
$(function(){
	$(".nav").singlePageNav({
		offset:50
	});
});
</script>
