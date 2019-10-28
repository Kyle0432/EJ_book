<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/book.css">
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
				<input id="searchContent" type="text" placeholder="输入小说名" class="form-control input-lg"><span id="search" class="input-group-addon btn btn-primary">搜索</span>
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

<!--banner-->
<div id="banner">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3 col-xs-12">
				<section id="book-type">
					<h4 class="text-center">分类</h4>
					<hr>
					<ul id="type" class="wow bounceIn" data-wow-delay="0.3s">
						
						<div class="clearfix"></div>
					</ul>
				</section>
			</div>
			<div class="col-md-9 col-xs-12">
				<div class="container-fluid wow fadeInLeft" data-wow-delay="0.8s">
					<div class="col-md-12">
						<div id="carousel-banner" class="carousel slide">
							<ol class="carousel-indicators">
								<li class="active" data-target="#carousel-banner" data-slide-to="0"></li>
								<li data-target="#carousel-banner" data-slide-to="1"></li>
								<li data-target="#carousel-banner" data-slide-to="2"></li>
								<li data-target="#carousel-banner" data-slide-to="3"></li>
							</ol>

							<div class="carousel-inner">
								<div class="item active">
									<img src="${pageContext.request.contextPath}/img/banner1.jpg" class="img-responsive" alt="img1">
								</div>
								<div class="item">
									<img src="${pageContext.request.contextPath}/img/banner2.jpg" class="img-responsive" alt="img2">
								</div>
								<div class="item">
									<img src="${pageContext.request.contextPath}/img/banner3.jpg" class="img-responsive" alt="img3">
								</div>
								<div class="item">
									<img src="${pageContext.request.contextPath}/img/banner4.jpg" class="img-responsive" alt="img4">
								</div>
							</div>

							<div>
								<a class="left carousel-control" href="#carousel-banner" role="button" data-slide="prev">
									<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
									<span class="sr-only">Previous</span>
								</a>
								<a class="right carousel-control" href="#carousel-banner" role="button" data-slide="next">
									<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
									<span class="sr-only">Next</span>
								</a>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--banner-->

<!--排行-->
<section id="rank">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3">
				<h4 class="text-center">排行榜<em>TOP10</em></h4>
				<hr>
				<ul>
					<li>&nbsp;&nbsp;1<a href="">围城</a><em><span>112222</span></em></li>
					<li>&nbsp;&nbsp;2<a href="">骆驼祥子</a><em><span>98888</span></em></li>
					<li>&nbsp;&nbsp;3<a href="">老人与海</a><em><span>75555</span></em></li>
					<li>&nbsp;&nbsp;4<a href="">巴黎圣母院</a><em><span>66666</span></em></li>
					<li>&nbsp;&nbsp;5<a href="">呼啸山庄</a><em><span>55555</span></em></li>
					<li>&nbsp;&nbsp;6<a href="">茶花女</a><em><span>44444</span></em></li>
					<li>&nbsp;&nbsp;7<a href="">傲慢与偏见</a><em><span>33333</span></em></li>
					<li>&nbsp;&nbsp;8<a href="">罪与罚</a><em><span>22222</span></em></li>
					<li>&nbsp;&nbsp;9<a href="">红与黑</a><em><span>11111</span></em></li>
					<li>10<a href="">三国演义</a><em><span>9999</span></em></li>
				</ul>
			</div>
			<div class="col-md-9">
				<div class="container">
					<input type="hidden" id="currentPage" value="1">
					<div class="row" id="books">
						<!--书卡片-->
						<!-- <div class="col-md-4 col-sm-4">
							<div class="book-card">
								<div class="container-fluid">
									<h4>斗罗大陆</h4>
									<hr>
									<div class="row">
										<div class="col-md-4 col-sm-3">
											
											<img src="../img/douluodalu.jpg" alt="">
									
										</div>
										<div class="col-md-8 col-sm-9">
											<h5>章数：236</h5>
											<h5>简述：</h5>“当初，我之所以一再提醒你，得到魂骨后不要急于吸收，就是出于这个原因。这块魂骨虽然不适合你，但却会适合别人。最......
										</div>
									</div>
									<hr>
									<h4>更新状态：<a href=""><span>99又是一块魂骨(下)</span></a></h4>
								</div>
							</div>
						</div> -->
						
					</div>
				</div>
				<div class="container">
					<div class="row text-center">
						<div class="col-md-4 text-center"><h4 id="p"></h4></div>
						<div class="col-md-4">
							<a class="btn btn-default currentPage">上一页</a>
							<a class="btn btn-default currentPage">下一页</a>
						</div>
						<div class="col-md-4"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--排行-->

<!--脚部-->
<footer class="text-center">
<hr>
	<h3>Jackie</h3>
</footer>
<!--脚部-->

</body>
</html>
<script>
$(function(){


ajaxBook("",$("#currentPage").val());



$("#search").click(function(){
	ajaxBook($("#searchContent").val(),$("#currentPage").val());
});

$(".currentPage").click(function(){
	if($(this).text()=="上一页"){
		ajaxBook($("#searchContent").val(),parseInt($('#currentPage').val())-1);
	}else if($(this).text()=="下一页"){
		ajaxBook($("#searchContent").val(),parseInt($('#currentPage').val())+1);
	}
});



//*********************************
//查找书籍类型
function ajaxType(){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/jsp/book/findAll.action",
		dataType:"json",
		processData:false,
		success:function(data){
			var selobj=$("#type");
			selobj.empty();
			var list=data.bookTypeList;
			for(var i=0;i<list.length;i++){
				$('<li><span class="ab">'+list[i].type_name+'</span></li>').appendTo(selobj);
			}
			
		}
	});
}


//ajax查找所有书籍
function ajaxBook(keyWord,currentPage){
	$.ajax({
	type:"POST",
	url:"${pageContext.request.contextPath}/jsp/book/findAllBook.action?keyWord="+keyWord+"&currentPage="+currentPage,
	dataType:"json",
	processData:false,
	success:function(data){
		var selobj=$("#books");
		selobj.empty();
		var list=data.bookList;
		
		$('#currentPage').val(data.currentPage);
		for(var i=0;i<list.length;i++){
			$('<div class="col-md-4 col-sm-4 book-card"><a href="${pageContext.request.contextPath}/jsp/book/findBookById.action?book.book_id='+list[i].book_id+'"><div class="container-fluid"><h4>'+list[i].book_name+'</h4><hr><div class="row"><div class="col-md-4 col-sm-3"><img src="${pageContext.request.contextPath}/'+list[i].poster+'" alt=""></div><div class="col-md-8 col-sm-9"><h5>章数：'+list[i].bookdescription.chapter_count+'</h5><h5>简述：</h5>'+list[i].bookdescription.explain+'</div></div><hr><h4>更新状态：<a href=""><span>99又是一块魂骨(下)</span></a></h4></div></a></div>').appendTo('#books');
			if((i+1)%3==0){
				$('<div class="clearfix"></div>').appendTo(selobj);
			}
			$('#p').empty();
			$('#p').text('第'+data.currentPage+'页 / 共'+data.totalPages+'页');
		}
		ajaxType();
	}
	});
}


});
</script>

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