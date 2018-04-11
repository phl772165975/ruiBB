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
            <h1 class="page-title">菜谱</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/orderServlet">主页</a> <span class="divider">/</span></li>
            <li class="active">菜谱</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
            	<c:if test="${menuAdd=='no'}">
				    <div class="alert alert-error">
				        <button type="button" class="close" data-dismiss="alert">×</button>
				        <strong>小提示：</strong> 添加失败！！
				    </div>
			      </c:if>
            <div class="page-header" ></div>
            <form action="${pageContext.request.contextPath}/orderAddSave" method="post" class="form-horizontal"  >    
            <div class="row-fluid">
               <div class="span7">  	
					<div class="control-group">
							<label class="control-label" for="tableid">桌 号</label>
							<div class="controls">
							<select  name="tableid" class="input-xlarge focused">
								<c:forEach items="${oid }" var="olist">
									<option value="${olist.id}">${olist.id}</option>
								</c:forEach>
							</select>
							</div>
					</div>
					<div class="control-group">
							<label class="control-label" for="personNum">人数</label>
							<div class="controls">
							<input name="personNum" class="input-xlarge focused" id="price" type="text" value="">
							</div>
					</div>
					<div class="control-group">
							<label class="control-label" for="menuname">菜单</label>
							<div class="controls">
							<c:forEach items="${menu}" var="mlist">
								<input name="menuname" 
								class="input-xlarge focused" id="menuname" type="checkbox" value="${mlist.mid }">${mlist.name}
								<c:if test="${mlist.mid % 6 == 0}">
									<br> 
								</c:if>
							</c:forEach>
							</div>
					</div>
					<div class="control-group">
							<label class="control-label" for="personNum">是否已付款</label>
							<div class="controls">
							<input name="idpay" class="input-xlarge focused" id="price" type="text" value="">
							<span class="help-inline">"1"表示已付款, "0"表示未付款</span>
							</div>
					</div>
					<input id="menutype" type="hidden"  name="menutype" value="1">
					<div class="control-group">
							<label class="control-label" for="remark">备 注</label>
							<div class="controls">
							<textarea rows="4" cols="20" name="remark" id="remark"></textarea>
							</div>
					</div>
					
               </div>
				<div class="span5">
					
               </div>
               </div>
               <div class="form-actions">
								<button type="submit" class="btn btn-primary">添 加</button>
								<button  class="btn" onclick="javascript:history.back(-1)">返 回</button>
				</div>
               </form>
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
		</script>
  </body>
</html>
