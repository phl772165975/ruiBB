<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <title>无线点餐后台</title>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-select.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/font-awesome/css/font-awesome.css">
    

	<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap-select.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap-file-input.js"></script>
   
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-switch.css" />
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap-switch.js"></script>


    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    
  </head>
  <body class=""> 
  <!--<![endif]-->
    
       <%@ include file="/WEB-INF/views/pages.jsp" %>
    
    <!-- 内容 开始 -->
<div class="content">
        
        <div class="header">
            <h1 class="page-title">订单添加</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/orderServlet">主页</a> <span class="divider">/</span></li>
             <li><a href="${pageContext.request.contextPath}/orderServlet">订单</a> <span class="divider">/</span></li>
            <li class="active">订单添加</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
            	
            <div class="page-header" ></div>
            
            <div class="row-fluid">
            <div class="span1"></div>
               <div class="span4">  	
					<h2>
					<span class="label"> 人 数 : </span> 
					<span class="label label-success" > ${order.personNum}</span>
					</h2>
						<h2>
					<span class="label"> 桌 号 : </span>
					<span class="label label-success" > ${order.table.id}</span>
					</h2>
					<h2>
					<span class="label">下单时间 : </span> 
					<span class="label label-success" > ${order.orderTime}</span>
					</h2>
					<h2>
					<span class="label">是否结账 : </span> 
					<c:if test="${order.idPay==1}">
            	  <span class="label label-success" >已结账</span>
             	</c:if>
             	<c:if test="${order.idPay==0}">
            	<span class="label label-success" >待结账</span>
            	 </c:if>
					</h2>
					<h2>
					<span class="label">总 价 : </span> 
					<c:set var="totalPrice" value="${0}"></c:set>      
					<c:forEach items="${menu}"  var="od_list">       
 			 		 <c:set var="totalPrice" value="${totalPrice+ od_list.menu.price}"/>
						</c:forEach>
					<span class="label label-success" > ${totalPrice}</span>
					</h2>
					<h2>
					<span class="label"> 备 注 : </span> 
					</h2>
					<p class="text-success">${order.oremark}</p>
					
               </div>
				<div class="span5">
					<h3>菜单</h3>
					<div class="page-header" ></div>
						<div class=" pre-scrollable">
		    <table class="table table-striped table-bordered bootstrap-datatable datatable">
		      <thead>
		        <tr>
		          <th>菜名</th>
		          <th>价格</th>
		          <th style="width: 26px;"></th>
		        </tr>
		      </thead>
		      <tbody>
		      <c:forEach items="${menu}" var="tbl">
		        <tr>
		          
		          <td>${tbl.menu.name}</td>
		        	<td>${tbl.menu.price}</td>
		        </tr>
		        </c:forEach>
		      </tbody>
		    </table>
			</div>
					
					
					
					
					
               </div>
               </div>
               <div class="form-actions">
								<button  class="btn" onclick="javascript:history.back(-1)">返 回</button>
				</div>
			<footer>
			<hr>
			<p class="pull-right">
				&copy; 2013.8 <a href="#" target="_blank"> shun_fzll</a>
			</p>
			</footer>

            </div>
        </div>
    </div>




			<script type="text/javascript">
			$('.selectpicker').selectpicker({
			      style: 'btn-info',
			      size: 4
			  });
			  
			$(document).ready(function(){ 
			$('#mySelect').change(function(){ 
			//alert($(this).children('option:selected').val()); 
			var p1=$(this).children('option:selected').val();//这就是selected的值 
			//改变隐藏域中的值
			$('#menutype').val(p1);
			//var p2=$('#menutype').val();
			//alert(p2)
			}) 
			}) 	
			$('input[type=file]').bootstrapFileInput();
		$('.file-inputs').bootstrapFileInput();		
			</script>
  </body>
</html>
