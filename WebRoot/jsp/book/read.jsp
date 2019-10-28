<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/read.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/iziModal.css">
	
	<script src="${pageContext.request.contextPath}/js/dropdown.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/js/wow.js"></script>
	<script src="${pageContext.request.contextPath}/js/iziModal.js"></script>

</head>
  
<body>
<!--导航-->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container wow bounceInRight" data-wow-delay="0.3s">
		<div class="col-md-3 col-xs-2">
			<a href="${pageContext.request.contextPath}/index.jsp" class="navbar-brand">EJBook</a>
		</div>
		<div class="col-md-6 col-xs-6">
			<div class="input-group">
				<input type="text" placeholder="输入小说名" class="form-control input-lg"><span class="input-group-addon btn btn-primary">搜索</span>
			</div>
		</div>
		<div class="col-md-3 col-xs-4">
				<ul class="nav navbar-nav navbar-right text-center">
					<c:if test="${empty sessionScope.user}">
						<li><a href="#" class="trigger-custom">登录/注册</a></li>
					</c:if>
					<c:if test="${not empty sessionScope.user}">
						<li><a href="" onclick="window.open('${pageContext.request.contextPath}/jsp/user/user-description.jsp');">欢迎您：${sessionScope.user.username}</a></li>
						<li><a href="" onclick="window.location.href='${pageContext.request.contextPath}/logout.action';">注销</a></li>
					</c:if>
				</ul>
<!--			<a href=""><img src="../img/wall_street.jpg" width="60" height="60" class="img-circle" alt=""></a>-->
		</div>
	</div>
</nav>
<!--导航-->

<!--阅读内容-->
<section id="read">
	<div class="container">
		<div class="row">
			<h1 class="text-center">第${bookContent.chapter_id}章</h1>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<c:forEach items="${bookContentList}" var="li">
					<p>${li.contents}</p>
				</c:forEach>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
	<div class="container" style="margin: 40px auto; line-height: 50px;">
		<div class="row text-center">
			<div class="col-md-4">
				<c:if test="${bookContent.chapter_id>total}">
					<input value="${bookContent.chapter_id=total}" type="hidden">
				</c:if>
				<c:if test="${bookContent.chapter_id!=1}">
					<a href="${pageContext.request.contextPath}/jsp/book/findAllContent.action?bookContent.book_id=${bookContent.book_id}&bookContent.chapter_id=${bookContent.chapter_id-1}">上一章</a>
				</c:if>
			</div>
			<div class="col-md-4">
				<a href="">目录</a>
			</div>
			
			
			<div class="col-md-4">
			<c:if test="${bookContent.chapter_id==total}">
					<input value="${bookContent.chapter_id=total}" type="hidden">
			</c:if>
			<c:if test="${bookContent.chapter_id<total}">
				<a href="${pageContext.request.contextPath}/jsp/book/findAllContent.action?bookContent.book_id=${bookContent.book_id}&bookContent.chapter_id=${bookContent.chapter_id+1}">下一章</a>
			</c:if>
			</div>
			
		</div>
	</div>
</section>
<!--阅读内容-->
</body>
</html>
<script>
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
</script>
