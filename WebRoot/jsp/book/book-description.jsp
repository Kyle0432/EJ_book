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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/book-description.css">
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
					<li><a href="" class="trigger-custom">登录/注册</a></li>
				</ul>
<!--			<a href=""><img src="../img/wall_street.jpg" width="60" height="60" class="img-circle" alt=""></a>-->
		</div>
	</div>
</nav>
<!--导航-->

<!--登录注册-->
<div id="modal-custom" class="iziModal">
	<button data-iziModal-close class="icon-close"></button>
	<header>
		<c:if test="${empty sessionScope.user}">
						<li><a href="#" class="trigger-custom">登录/注册</a></li>
					</c:if>
					<c:if test="${not empty sessionScope.user}">
						<li><a href="" onclick="window.open('${pageContext.request.contextPath}/jsp/user/user-description.jsp');">欢迎您：${sessionScope.user.username}</a></li>
						<li><a href="" onclick="window.location.href='${pageContext.request.contextPath}/logout.action';">注销</a></li>
					</c:if>
	</header>
	<section class="hide">
		<form action="">
			<input type="text" placeholder="用户名(6-16位字符或数字)" name="username">
			<input type="password" placeholder="密码(6-16位字符或数字)" name="password">
		<footer>
			<button data-iziModal-close>取消</button>
			<button type="submit">登录</button>            
		</footer>
		</form>
	</section>
	<section>
		<form action="">
			<input type="text" placeholder="用户名(6-16位字符或数字)" name="username">
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

<!--书详情-->
<section id="book-description">
	<div class="container">
		<div class="row">
			<div class="col-md-3 text-right">
				<img src="${pageContext.request.contextPath}/${book.poster}" alt="">
			</div>
			<div class="col-md-9" style="border-left: 1px solid #DDDDDD">
				<h1>${book.book_name}</h1>
				<h5><span>${book.alternate_name}</span> <em>著</em></h5>
				<p>${book.booktype.type_name}</p>
			
				<hr>
				<a href="${pageContext.request.contextPath}/jsp/book/findAllContent.action?chapter_id=1&book_id=${book.book_id }" class="btn btn-default btn-lg btn-primary" style=" color:#fff;">免费试读</a>
				<a href="${pageContext.request.contextPath}/jsp/book/" class="btn btn-default btn-lg btn-danger" style=" color:#fff;">收藏<span>154612</span></a>
			</div>
		</div>
	</div>
</section>
<!--书详情-->

<!--书信息、章节-->
<section id="book-infor">
	<div class="container">
		<div class="row">
			<ul id="myTab" class="nav nav-tabs">
			   <li class="active"><a href="#infor" data-toggle="tab">作品信息</a></li>
			   <li><a href="#catalog" data-toggle="tab">目录</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<!--书信息-->
			   <div class="tab-pane fade in active" id="infor">
				  <div class="container-fluid">
					<p style="max-width: 700px; line-height: 25px; margin: 20px 0;">${book.bookdescription.explain}</p>
			  		<hr>
			  		<p>最近更新 第${book.bookdescription.chapter_count}章</p>
				  </div>
			   </div>
			   <!--书信息-->
				<!--章节-->
			   <div class="tab-pane fade" id="catalog">
				  <div class="container-fluid">
				  	<div id="chapter" class="row">
				  		
				  	</div>
				  </div>
			   </div>
			   <!--章节-->
			</div>
		</div>
	</div>
</section>
<!--书信息、章节-->


</body>
</html>



<script>
$(function(){
$.ajax({
	type:"POST",
	url:"${pageContext.request.contextPath}/jsp/book/findBookByBookId.action?bookChapter.book_id=${book.book_id}",
	dataType:"json",
	processData:false,
	success:function(data){
		var selobj=$("#chapter");
		selobj.empty();
		for(var i=0;i<data.bookChapterList.length;i++){
			$('<div class="col-md-4"><a href="${pageContext.request.contextPath}/jsp/book/findAllContent.action?bookContent.book_id='+data.bookChapterList[i].book_id+'&bookContent.chapter_id='+data.bookChapterList[i].chapter_id+'">第'+data.bookChapterList[i].chapter_id+'章</a></div>').appendTo(selobj);
		}
	}
});
});



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