<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入jstl -->
<%@ include  file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
   <head>
      <title>秒杀详情页</title>
     <%@ include  file="common/head.jsp"%>
   </head>
   <body>
   	<div class="container">
   		<div class="panel panel-default text-center">
   			<div class="panel-heading">
   				${seckill.name}
   			</div>
   			<div class="panel-body">
   				<table class="table table-hover">
   					<thead>
   						<tr>
   							<th>名称</th>
   							<th>库存</th>
   							<th>开始时间</th>
   							<th>结束时间</th>
   						</tr>
   					</thead>
   					<tbody>
   						<tr>
   							<th>${seckill.name}</th>
   							<th>${seckill.number}</th>
   							<th><fmt:formatDate value="${seckill.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></th>
   							<th><fmt:formatDate value="${seckill.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></th>
   						</tr>
   					</tbody>
   				</table>
   			</div>
   		</div>
   	</div>
   </body>
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="https://code.jquery.com/jquery.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="http://apps.bdimg.com/lib/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</html>
