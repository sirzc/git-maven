<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style>
		* {
			margin: 0;
			padding: 0;
			overflow: hidden;
		}
		
		div {
			list-style: none;
		}
		
		a,
		a:hover {
			text-decoration: none;
		}
		
		body {
			background: url(common/img/body.jpg);
		}
		/* 标志  */
			#header_box {
				width: 100%;
				height: 40px;
				background: url(common/img/index_img/header.jpg);
			}
			
			#header_box img {
				height: 40px;
				margin: 0px 40px;
			}
			/* 导航栏   start */
			#breadLine_box {
				height: 25px;
				background: url(common/img/index_img/nav.jpg) left top repeat-x;
				border: 1px solid #CCC;
				border-top: 0px;
				border-left: 0px;
			}
			
			#breadLine_box .line_box {
				width: 240px;
				height: 25px;
				float: left;
				text-align: center;
			}
			
			#breadLine_box .line_box span {
				width: 25px;
				height: 25px;
				left: 10px;
				background: url(common/img/index_img/index.png) no-repeat;
				background-size: 25px;
				position: absolute;
				cursor: pointer;
			}
			
			#breadLine_box .rLine_box {
				float: right;
				font-size: 14px;
				color: #9d2145;
				line-height: 25px;
				font-weight: bold;
				margin-right: 10px;
			}
			
			#breadLine_box .line_box a {
				left: 40px;
				font-size: 14px;
				color: #9d2145;
				line-height: 25px;
				font-weight: bold;
				position: absolute;
				cursor: pointer;
			}
			/* 导航栏 end */
			/* 菜单栏 start */
			#main_box {
				width: 100%;
				height: 990px;
			}
			
			#main_box #tree {
				width: 240px;
				height: 990px;
				overflow-y: auto;
				/* 超过560自动显示滚动条  */
				position: absolute;
			}
			
			#main_box #mainform {
				width: auto;
				/* 设置左边自适应  margin-left值大于或者等于 左边固定值 */
				height: 990px;
				margin-left: 250px;
				/*position: absolute;*/
			}
			/* 菜单栏 end */
	</style>
	
		<link rel="stylesheet" href="<%=basePath%>common/css/zTreeStyle/zTreeStyle.css" />
 	    <link rel="stylesheet" href="<%=basePath%>common/css/index.css" />   
		<script type="text/javascript" src="<%=basePath%>common/js/common.js"></script>
		<script type="text/javascript" src="<%=basePath%>common/js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath%>common/js/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript">
			var menu = {
		 			path : '${pageContext.request.contextPath}',
					node : null,
					init : function() {
						this.nodes();
					},
					nodes : function() {
						var $this = this;
						$.ajax({
							type : "get",
							url : "${pageContext.request.contextPath}/index/menu",
							async : false,
							success : function(data) {
 								for (var i = 0; i < data.length; i++) {
									if(data[i].opurl!=null){
										data[i].opurl =$this.path + data[i].opurl;
									}
								}
								$this.node = data;
							}
						});
					}
			}
			var setting = {
					view: {
						showLine: false, //是否显示连线
						showIcon: true, //是否显示图标
						selectedMulti: false, //禁止多点选中  
						dblClickExpand: false //双击节点时，是否自动展开父节点的标识
					},
					data: {
						simpleData: {
							enable: true,
							idKey: "id",
							pIdKey: "pId"
						}
					},
					callback: {
						beforeClick: function(treeId, treeNode) {
							//[leve]查看当前被选中的节点的级数
							//							alert(treeNode.level);
							if(treeNode.level == 0 && (treeNode.opurl == "" || treeNode.opurl == undefined)) {
								var zTree = $.fn.zTree.getZTreeObj("tree");
								zTree.expandNode(treeNode, !treeNode.open);
								return false;
							}
							return true;
						},
						onClick: function(event, treeId, treeNode) {
							if(treeNode.opurl != "" && treeNode.opurl != undefined) {
								$("#pageContent").attr("src", treeNode.opurl);
							}
						}
					}
				};
			$(function() {
				menu.init();
				$.fn.zTree.init($("#tree"), setting, menu.node);
			}); 
		</script>

	</head>

	<body>
		<div id="header_box">
			<img src="common/img/index_img/logo1.png" alt="" />
		</div>
		<div id="breadLine_box">
			<div class="line_box">
				<span></span>
				<a href="">【首页】 </a>
			</div>
			<div class="rLine_box">
				<p>
					<%-- 欢迎您，${user.username}  --%>
					<shiro:principal property="name"></shiro:principal>&nbsp;&nbsp;&nbsp;现在是
					<span class="time"></span>
					<shiro:hasRole name="/user/editPsw">
						<span>修改密码</span>
					</shiro:hasRole>
					<a href="<%=request.getContextPath()%>/index/logout" target="_top">退出</a>
				</p>
			</div>
		</div>
		<div id="main_box">
			<div id="tree" class="ztree"></div>
			<div id="mainform" class="mainform">
				<iframe id="pageContent" src="" width="100%" height="100%" style="border:0"></iframe>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		var snailIndex = {
				time:null,
				init:function(){
					this.setTime();
				},
				setTime:function(){
 					this.time = showTime();
 					$('#breadLine_box .rLine_box .time').html(this.time);
					setTimeout("snailIndex.setTime()", 1000);
				}
		}
		
		$(function() {
			snailIndex.init();
		})
	</script>
</html>