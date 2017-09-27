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
				url:'<%=path%>/users/loadGrid',
				// pageSize: 20,
				//< pageList : [10, 20,30,40 ], 
				rownumbers : true,	//<!--显示带有行号的列。-->
				pagination : true,	//<!--显示分页工具栏-->
				title:'用户管理',
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
						align : 'center',
						width : 95,
						title : '编号'   //
					},{
						field:'username',
						title:'用户名',   //
						width : 200,
						align : 'left'
					},{
						field:'name',
						title:'名称',   //
						width : 200,
						align : 'left'
					},{
						field:'password',
						title:'用户密码',   //
						width : 260,
						align : 'left'
					},{
						field:'salt',
						title:'盐',   //
						width : 200,
						align : 'left'
					},{
						field:'empId',
						title:'所属机构',   //
						width : 200,
						align : 'left'
					},{
						field:'rolesString',
						title:'角色',   //
						width : 200,
						align : 'left' 
					},{
						field:'rolesName',
						title:'用户类型',   //
						width : 200,
						align : 'left'
					}
					
				]],
			});
	}
	</script>
</body>
</html>
