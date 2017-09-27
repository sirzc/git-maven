<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>common/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>common/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>common/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/easyui-lang-zh_CN.js" ></script>

</head>
  
 <body> 
	
	<div style="width:100%">
		<table id="dg" class="easyui-datagrid"></table>	
	</div>		
	<script type="text/javascript">
			var tool = [];
			tool.push();
			tool.push({
				text : '查询',
				iconCls : 'icon-search',
				handler : function() {			     
					loadGrid();
				}
			});
			tool.push( '-');
			tool.push({
				text : '重置',
				iconCls : 'icon-reload',
				handler : function() {
				  document.getElementById('searchform').reset();
				}
			});
			tool.push('-');
			tool.push({
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					$('#knowform').form("clear");
					openNewKnow();		    	
				}		
			});
			
		$(function() {	//初始化信息
			loadGrid();			
		})
		function loadGrid() {	
			$('#dg').datagrid({
				height:850,
				url:'<%=path%>/roles/loadGrid',
				// pageSize: 20,
				//< pageList : [10, 20,30,40 ], 
				rownumbers : true,	//<!--显示带有行号的列。-->
				pagination : true,	//<!--显示分页工具栏-->
				title:'角色管理',
				toolbar:tool,
				loadMsg : '数据装载中......',			
				columns:[[{
						field : 'ck',
						checkbox : true
					},{
						field : 'rowId',  //行id
						hidden: 'true'
					},{
						field : 'id',
						align : 'left',
						width : 95,
						title : '编号'   //
					},{
						field:'name',
						title:'角色名称（英文）',   //
						width : 200,
						align : 'left'
					},{
						field:'description',
						title:' 简介（中文）',   //
						width : 200,
						align : 'left'
					}
				]],
			});
	}
	</script>
</body>
</html>
