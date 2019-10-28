<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <title>的个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-user-description.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/iziModal.css">
	
	<script src="${pageContext.request.contextPath}/js/dropdown.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.singlePageNav.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/iziModal.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.toTop.js"></script>
	<script src="${pageContext.request.contextPath}/js/wow.js"></script>
  </head>
  
  <body>
    <!--导航-->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container wow slideInDown" data-wow-delay="0.3s">
		<div class="col-md-3">
			<a href="${pageContext.request.contextPath}/index.jsp" class="navbar-brand">EJBook</a>
		</div>
		<div class="col-md-6">
			
		</div>
	</div>
</nav>
<!--导航-->

<!--个人信息-->
<section id="user-description" style="margin-top:50px;">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-xs-12">
				<img src="../../img/timg.jpg" class="img-circle img-responsive" alt="" />
			</div>
			<div class="col-md-3 col-xs-12">
			
			</div>
			<div class="col-md-6 col-xs-12">
				<p style="margin-left:30px;margin-top:20px;">我的钱包:<input type="text" name="mywallet" style="border:0px" readonly /><a href="" class="btn btn-default btn-md btn-primary" style=" color:#fff;">充值</a></p><br>
				<p style="margin-left:30px;margin-top:20px;">我的会员:<input name="memberTypeName" type="text" style="border:0px" readonly value="" /><input type="text" name="memberType" style="display:none;" readonly></p><br>
				<p style="margin-left:30px;margin-top:20px;">到期时间:<input type="date" class="form-control" name="remaining_time" style="border:0px;width:200px;" readonly />
				<c:if test="${sessionScope.user.is_member==0}">
					<a href="" class="btn btn-default btn-md btn-primary" style=" color:#fff;">充值会员</a>
				</c:if>
				<c:if test="${sessionScope.user.is_member==1}">
					<a href="" class="btn btn-default btn-md btn-primary" style=" color:#fff;">续费</a>
				</c:if>
				</p><br>
				
			</div>
		</div>
		<div class="row">
			<ul id="myTab" class="nav nav-tabs">
			   <li class="active"><a href="#collection" data-toggle="tab">收藏夹</a> </li>
			   <li><a href="#infor" data-toggle="tab">个人信息</a></li>
			   <li><a href="#changePass" data-toggle="tab">修改密码</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<!--收藏夹-->
			   <div class="tab-pane fade in active" id="collection">
			   		<input type="hidden" id="currentPage" >
					<div class="container" id="allContext">
						<%-- <h2>所有影片</h2>
						<hr>
						<div class="row" id="ajax-getFilms">
							<c:forEach items="${filmList}" var="film" varStatus="li">
								<div class="col-md-3 movie-card text-center">
									<a href="${pageContext.request.contextPath}/movie/findById.action?film.film_id=${film.film_id}">
										<img src="${pageContext.request.contextPath}/img/movie-cover/${film.poster}" class="img-responsive" alt="">
										<hr>
										<h4>${film.film_name}</h4>
									</a>
								</div>
							</c:forEach>
						</div> --%>
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
			   <!--收藏夹-->
				<!--信息-->
			   <div class="tab-pane fade" id="infor">
				  <div class="container-fluid">
					<!--个人信息-->
				  	<form action="">
					  <div class="row">
						<div class="col-md-2 col-sm-4 text-center">
							<h4>昵称：</h4>
						</div>
						<div class="col-md-4 col-sm-8">
							<input type="text" class="form-control" name="nickname">
						</div>
					  </div>
					  <div class="row">
						<div class="col-md-2 col-sm-4 text-center">
							<h4>性别：</h4>
						</div>
						<div class="col-md-4 col-sm-8">
							<input type="text" class="form-control" name="gender">
						</div>
					  </div>
					  <div class="row">
						<div class="col-md-2 col-sm-4 text-center">
							<h4>出生日期：</h4>
						</div>
						<div class="col-md-4 col-sm-8">
							<input type="date" class="form-control" name="birthday">
						</div>
					  </div>
					  <div class="row">
						<div class="col-md-2 col-sm-4 text-center">
							<h4>年龄：</h4>
						</div>
						<div class="col-md-4 col-sm-8">
							<input type="text" readonly class="form-control" name="year_old">
						</div>
					  </div>
					  <div class="row">
						<div class="col-md-2 col-sm-4 text-center">
							<h4>个人说明：</h4>
							<em>200字以内</em>
						</div>
						<div class="col-md-4 col-sm-8">
							<textarea class="form-control" style="height: 150px; resize: none;" name="explain"></textarea>
						</div>
					  </div>
					  <div class="row">
					  	<div class="col-md-6 text-right">
					  	
					  		<button class="btn btn-primary" id="add">添加信息</button>
					  		<button class="btn btn-primary" id="update">修改</button>
						</div>
					  </div>
					</form>
				  </div>
			   </div>
			   <!--信息-->
				<!--修改密码-->
			   <div class="tab-pane fade" id="changePass">
				  <div class="container-fluid">
				  	<form action="">
					  <div class="row">
						<div class="col-md-2 col-sm-4 text-center">
							<h4>原始密码：</h4>
						</div>
						<div class="col-md-4 col-sm-8">
							<input type="text" class="form-control" name="haha">
						</div>
					  </div>
					  <div class="row">
						<div class="col-md-2 col-sm-4 text-center">
							<h4>新密码：</h4>
						</div>
						<div class="col-md-4 col-sm-8">
							<input type="text" class="form-control" name="xixi">
						</div>
					  </div>
					  <div class="row">
					  	<div class="col-md-6 text-right">
					  		<button class="btn btn-primary" type="submit">提交</button>
						</div>
					  </div>
					</form>
				  </div>
			   </div>
			   <!--修改密码-->
			</div>
		</div>
	</div>
</section>
<!--个人信息-->

</body>
</html>
<script>
$(function(){

	$("#add").click(function(){
	$.ajax({
		type: "POST" ,
		url: "${pageContext.request.contextPath}/jsp/user/addDescription.action?user_id="+${sessionScope.user.user_id}+"&nickname="+document.getElementsByName("nickname")[0].value+"&gender="+document.getElementsByName("gender")[0].value+"&birthday="+document.getElementsByName("birthday")[0].value+"&explain="+document.getElementsByName("explain")[0].value ,
		dataType: "json" ,			
		success: function(data){
			alert(1);
		}
	});
	
	$("#update").click(function(){
		$.ajax({
			type: "POST" ,
			url: "${pageContext.request.contextPath}/jsp/user/updateDescription.action?user_id="+${sessionScope.user.user_id}+"&nickname="+document.getElementsByName("nickname")[0].value+"&gender="+document.getElementsByName("gender")[0].value+"&birthday="+document.getElementsByName("birthday")[0].value+"&explain="+document.getElementsByName("explain")[0].value ,
			dataType: "json" ,			
			success: function(data){
				alert(1);
			}
		});
	});

});

	ajaxBook(${sessionScope.user.user_id},1);
	
	$(".currentPage").click(function(){
		if($(this).text()=="上一页"){
			ajaxBook(${sessionScope.user.user_id},parseInt($('#currentPage').val())-1);
		}else if($(this).text()=="下一页"){
			ajaxBook(${sessionScope.user.user_id},parseInt($('#currentPage').val())+1);
		}
	});

	//ajax请求取得电影简讯
	function ajaxBook(user_id,currentPage){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/jsp/book/findAllBuy.action?keyWord="+user_id+"&user_id="+user_id+"&currentPage="+currentPage,
			dataType:"json",
			processData:false,
			success:function(data){
				var all=$("#allContext");
				all.empty();
				$('<h2>所有书籍</h2><span style="background-color:#DDDDDD;"></span><hr><div class="row" id="ajax-getBooks"></div>').appendTo(all);
				
				var selobj=$("#ajax-getBooks");
				selobj.empty();
				if(data.message=="未找到您要搜索的书籍"){
					$('<div class="col-md-12 text-center" style="font-size:16px;">'+data.message+'</div>').appendTo(selobj);
				}else{
					selobj.empty();
				}
				//向隐藏域写入当前页
				$('#currentPage').val(data.currentPage);
				
				for(var i=0;i<data.buyBookList.length;i++){
					$('<div class="col-md-3 book-card text-center"><a href="${pageContext.request.contextPath}/jsp/book/findBookById.action?book.book_id='+data.buyBookList[i].book_id+'"><img src="${pageContext.request.contextPath}/'+data.buyBookList[i].book.poster+'" class="img-responsive" alt=""><hr><h4>'+data.buyBookList[i].book.book_name+'</h4></a></div>').appendTo(selobj);
					if((i+1)%4==0){
						$('<div class="clearfix"></div>').appendTo(selobj);
					}
					//写入当前页和总页数
					$('#p').empty();
					$('#p').text('第'+data.currentPage+'页 / 共'+data.totalPages+'页');
				}
			}
		});
	}
});


$(function(){
	$.ajax({
	
		type: "POST" ,
		url: "${pageContext.request.contextPath}/jsp/member/findMemberById.action?user_id="+${sessionScope.user.user_id} ,
		dataType: "json" ,			
		success: function(data){
			var date=new Date(data.member.remaining_time);		
			//格式化日，如果小于9，前面补0
			var day = ("0" + date.getDate()).slice(-2);
			//格式化月，如果小于9，前面补0
			var month = ("0" + (date.getMonth() + 1)).slice(-2);
			//拼装完整日期格式
			var today = date.getFullYear()+"-"+(month)+"-"+(day);
			$("input[name='remaining_time']").val(today);
			ajaxMemberType(data.member.member_id);
		}
	});
});



$(function(){
	$.ajax({
	
		type: "POST" ,
		url: "${pageContext.request.contextPath}/jsp/user/findUserWalletById.action?user_id="+${sessionScope.user.user_id} ,
		dataType: "json" ,			
		success: function(data){
			$("input[name='mywallet']").val("￥"+data.userwallet.user_wallet);
		}
	});
});


$(function(){

	$.ajax({
	
		type: "POST" ,
		url: "${pageContext.request.contextPath}/jsp/user/findById.action?user_id="+${sessionScope.user.user_id} ,
		dataType: "json" ,			
		success: function(data){
			var date=new Date(data.userdescription.birthday);		
			//格式化日，如果小于9，前面补0
			var day = ("0" + date.getDate()).slice(-2);
			//格式化月，如果小于9，前面补0
			var month = ("0" + (date.getMonth() + 1)).slice(-2);
			//拼装完整日期格式
			var today = date.getFullYear()+"-"+(month)+"-"+(day);
			$("input[name='nickname']").val(data.userdescription.nickname);
			$("input[name='gender']").val(data.userdescription.gender);
			$("input[name='birthday']").val(today);
			$("textarea[name='explain']").text(data.userdescription.explain);
			$("input[name='year_old']").val(data.userdescription.year_old);
		}
	});
});

function ajaxMemberType(member_id){
	//根据会员类型查询会员名称
	$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/jsp/member/findMemberTypeById.action?member_id="+member_id,
			dataType:"json",
			processData:false,
			success:function(data){
				$("input[name='memberTypeName']").val(data.memberType.member_name);
			}
	});	
};

</script>