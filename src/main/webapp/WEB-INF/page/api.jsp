<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="${pageContext.request.contextPath }/resources/asset/img/icon.png" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/asset/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath }/resources/asset/js/jquery-2.1.4.js"></script>
<script src="${pageContext.request.contextPath }/resources/asset/js/bootstrap.min.js"></script>
<style>
	.left{
		padding-left:20px;
	}
	textarea
	{
	  border:1px solid #999999;
	  width:100%;
	  margin:5px 0;
	  padding:3px;
	  font-size: 15px;
	  font-family: courier;
	}
	p.service{
		border:1px solid #000;
		padding: 10px;
	}
	
</style>
</head>
<body>
<div class="jumbotron">
  <h1 class="left">Article Web Service API</h1>
</div>

<div class="container-fluid">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#user">User</a></li>
    <li><a data-toggle="tab" href="#article">Article</a></li>
  </ul>

  <div class="tab-content">
    <div id="user" class="container tab-pane fade in active">
      <h3>User</h3>
      <hr>
      <div class="row">
      		<p class="service">URL : <b>/api/user/hrd_r001</b><br>
      		Service name : <b>Retrieve all user</b><br>
      		Method : <b>POST</b>
      		</p>
      		<textarea rows="4" cols="100" id="ta_user_r001"></textarea>
      		<button class="btn btn-success" id="user_r001">Send</button>
      		<textarea rows="10" cols="100" id="rs_user_r001"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/user/hrd_c001</b><br>
      		Service name : <b>Insert user</b><br>
      		Method : <b>POST</b><br>
      		roles : <b>User</b>&nbsp;or&nbsp;<b>Admin</b>
      		</p>
      		<textarea rows="6" cols="100" id="ta_user_c001"></textarea>
      		<button class="btn btn-success" id="user_c001">Send</button>
      		<textarea rows="5" cols="100" id="rs_user_c001"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/user/hrd_u001</b><br>
      		Service name : <b>Update user</b><br>
      		Method : <b>POST</b><br>
      		roles : <b>User</b>&nbsp;or&nbsp;<b>Admin</b>
      		</p>
      		<textarea rows="8" cols="100" id="ta_user_u001"></textarea>
      		<button class="btn btn-success" id="user_u001">Send</button>
      		<textarea rows="5" cols="100" id="rs_user_u001"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/user/hrd_d001</b><br>
      		Service name : <b>Remove user</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="3" cols="2" id="ta_user_d001"></textarea>
      		<button class="btn btn-success" id="user_d001">Send</button>
      		<textarea rows="5" cols="100" id="rs_user_d001"></textarea>
      </div>
      
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/user/hrd_e001</b><br>
      		Service name : <b>Enable or Disable user</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="3" cols="2" id="ta_user_e001"></textarea>
      		<button class="btn btn-success" id="user_e001">Send</button>
      		<textarea rows="5" cols="100" id="rs_user_e001"></textarea>
      </div>
      
      
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/user/hrd_det001</b><br>
      		Service name : <b>Detail user</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="3" cols="2" id="ta_user_det001"></textarea>
      		<button class="btn btn-success" id="user_det001">Send</button>
      		<textarea rows="10" cols="100" id="rs_user_det001"></textarea>
      </div>
      
      
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/login</b><br>
      		Service name : <b>User Login</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="5" cols="2" id="ta_user_login"></textarea>
      		<button class="btn btn-success" id="user_login">Send</button>
      		<textarea rows="10" cols="100" id="rs_user_login"></textarea>
      </div>
      
      
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/user/search/{ username }</b>&nbsp;<input type="text" id="searchUser" placeholder="username" /><br>
      		Service name : <b>Search user</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="5" cols="2" id="ta_user_search"></textarea>
      		<button class="btn btn-success" id="user_search">Send</button>
      		<textarea rows="10" cols="100" id="rs_user_search"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/user/upload_image</b><br>
      		Service name : <b>Upload user image</b><br>
      		Method : <b>POST</b><br>
      		Type : <b>File</b><br>
      		Name : <b>USR_IMG</b><br>
      		</p>
      		<form id="userImage" method="post" enctype="multipart/form-data">
      			<input type="file" name="USR_IMG" /><br>
      			<input type="submit" value="Send" class="btn btn-success" />
      		</form>
      		<br>
      		<textarea rows="5" cols="100" id="rs_user_upload_image"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/user/update_image/{ userId }</b>&nbsp;<input type="number" id="userId" placeholder="UserId" /><br>
      		Service name : <b>Update user image</b><br>
      		Method : <b>POST</b><br>
      		Type : <b>File</b><br>
      		Name : <b>USR_IMG</b><br>
      		</p>
      		<form id="updateUserImage" method="post" enctype="multipart/form-data">
      			<input type="file" name="USR_IMG" /><br>
      			<input type="submit" value="Send" class="btn btn-success" />
      		</form>
      		<br>
      		<textarea rows="5" cols="100" id="rs_user_update_image"></textarea>
      </div>
      <br><br><br>
    </div>
    <div id="article" class="container tab-pane fade">
      <h3>Article</h3>
      <hr>
      <div class="row">
      		<p class="service">URL : <b>/api/article/hrd_r001</b><br>
      		Service name : <b>Retrieve all article</b><br>
      		Method : <b>POST</b>
      		</p>
      		<textarea rows="4" cols="100" id="ta_article_r001"></textarea>
      		<button class="btn btn-success" id="article_r001">Send</button>
      		<textarea rows="10" cols="100" id="rs_article_r001"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/article/hrd_c001</b><br>
      		Service name : <b>Insert article</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="6" cols="100" id="ta_article_c001"></textarea>
      		<button class="btn btn-success" id="article_c001">Send</button>
      		<textarea rows="5" cols="100" id="rs_article_c001"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/article/hrd_u001</b><br>
      		Service name : <b>Update article</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="8" cols="100" id="ta_article_u001"></textarea>
      		<button class="btn btn-success" id="article_u001">Send</button>
      		<textarea rows="5" cols="100" id="rs_article_u001"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/article/hrd_d001</b><br>
      		Service name : <b>Remove article</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="3" cols="2" id="ta_article_d001"></textarea>
      		<button class="btn btn-success" id="article_d001">Send</button>
      		<textarea rows="5" cols="100" id="rs_article_d001"></textarea>
      </div>
      <br>
      <br>
      <br>
      
      <div class="row">
      		<p class="service">URL : <b>/api/article/hrd_e001</b><br>
      		Service name : <b>Enable or Disable article</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="3" cols="2" id="ta_article_e001"></textarea>
      		<button class="btn btn-success" id="article_e001">Send</button>
      		<textarea rows="5" cols="100" id="rs_article_e001"></textarea>
      </div>
      <br>
      <br>
      <br>
      
      <div class="row">
      		<p class="service">URL : <b>/api/article/hrd_det001</b><br>
      		Service name : <b>Detail article</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="3" cols="2" id="ta_article_det001"></textarea>
      		<button class="btn btn-success" id="article_det001">Send</button>
      		<textarea rows="10" cols="100" id="rs_article_det001"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/article/search/{ title }</b>&nbsp;<input type="text" id="searchArticle" placeholder="Title" /><br>
      		Service name : <b>Search Article</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="5" cols="2" id="ta_article_search"></textarea>
      		<button class="btn btn-success" id="article_search">Send</button>
      		<textarea rows="10" cols="100" id="rs_article_search"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/article/user/{ id }</b>&nbsp;<input type="text" id="articleUserId" placeholder="User id" /><br>
      		Service name : <b>View user article</b><br>
      		Method : <b>POST</b><br>
      		</p>
      		<textarea rows="5" cols="2" id="ta_article_user"></textarea>
      		<button class="btn btn-success" id="article_user">Send</button>
      		<textarea rows="10" cols="100" id="rs_article_user"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/article/upload_image</b><br>
      		Service name : <b>Upload article image</b><br>
      		Method : <b>POST</b><br>
      		Type : <b>File</b><br>
      		Name : <b>ART_IMG</b><br>
      		</p>
      		<form id="articleImage" method="post" enctype="multipart/form-data">
      			<input type="file" name="ART_IMG" /><br>
      			<input type="submit" value="Send" class="btn btn-success" />
      		</form>
      		<br>
      		<textarea rows="5" cols="100" id="rs_article_upload_image"></textarea>
      </div>
      <br>
      <br>
      <br>
      <div class="row">
      		<p class="service">URL : <b>/api/article/update_image/{ articleId }</b>&nbsp;<input type="number" id="articleId" placeholder="Article Id" /><br>
      		Service name : <b>Update article image</b><br>
      		Method : <b>POST</b><br>
      		Type : <b>File</b><br>
      		Name : <b>ART_IMG</b><br>
      		</p>
      		<form id="updateArticleImage" method="post" enctype="multipart/form-data">
      			<input type="file" name="ART_IMG" /><br>
      			<input type="submit" value="Send" class="btn btn-success" />
      		</form>
      		<br>
      		<textarea rows="5" cols="100" id="rs_article_update_image"></textarea>
      </div>
      <br><br><br>
    </div>
  </div>      
</div>


<script>
	$(document).ready(function(){
		
		//set default value to User textarea
		var json = $.parseJSON('{"row":"10","pageCount":"1"}');
		$('#ta_user_r001').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"username":"xxx","password":"xxx","roles":"User","photo":""}');
		$('#ta_user_c001').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"id":"000","username":"xxx","password":"xxx","roles":"User","enabled":"true","photo":""}');
		$('#ta_user_u001').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"id":"000"}');
		$('#ta_user_d001').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"id":"000"}');
		$('#ta_user_e001').val(JSON.stringify(json, null, 4));

		json = $.parseJSON('{"id":"000"}');
		$('#ta_user_det001').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"username":"xxx","password":"xxx"}');
		$('#ta_user_login').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"row":"10","pageCount":"1"}');
		$('#ta_user_search').val(JSON.stringify(json, null, 4));
		
		//set default value to Article textarea
		var json = $.parseJSON('{"row":"10","pageCount":"1"}');
		$('#ta_article_r001').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"title":"xxx","description":"xxx","userId":"000","image":""}');
		$('#ta_article_c001').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"id":"000","title":"xxx","description":"xxx","enabled":"true","userId":"000","image":""}');
		$('#ta_article_u001').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"id":"000"}');
		$('#ta_article_d001').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"id":"000"}');
		$('#ta_article_e001').val(JSON.stringify(json, null, 4));

		json = $.parseJSON('{"id":"000"}');
		$('#ta_article_det001').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"row":"10","pageCount":"1"}');
		$('#ta_article_search').val(JSON.stringify(json, null, 4));
		
		json = $.parseJSON('{"row":"10","pageCount":"1"}');
		$('#ta_article_user').val(JSON.stringify(json, null, 4));
		
		
		//retrieve all user
	    $("#user_r001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_user_r001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/user/hrd_r001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_user_r001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_user_r001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
		
		//insert user
	    $("#user_c001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_user_c001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/user/hrd_c001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_user_c001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_user_c001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
		
	  	//update user
	    $("#user_u001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_user_u001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/user/hrd_u001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_user_u001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_user_u001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	  	
	  	//remove user
	    $("#user_d001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_user_d001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/user/hrd_d001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_user_d001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_user_d001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	  	
	  	
	  	//enabled user
	    $("#user_e001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_user_e001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/user/hrd_e001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_user_e001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_user_e001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	  	
	  	//detail user
	    $("#user_det001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_user_det001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/user/hrd_det001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_user_det001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_user_det001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	  	
	  	//user login
	    $("#user_login").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_user_login').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/login',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_user_login').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_user_login').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	  	
	  	//search user
	    $("#user_search").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_user_search').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/user/search/' + $("#searchUser").val() ,
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_user_search').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_user_search').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	    
	  	//upload user image
	    $("#userImage").submit(function(e) {
			e.preventDefault();
			$.ajax({
				type : "POST",
				url : '${pageContext.request.contextPath }/api/user/upload_image',
				enctype : 'multipart/form-data',
				data : new FormData(document.getElementById("userImage")),
				processData : false, // tell jQuery not to process the data
				contentType : false, // tell jQuery not to set contentType
				success : function(data) {
					$('#rs_user_upload_image').val(JSON.stringify(data, null, 4));
				},
				error : function(data) {
					$('#rs_user_upload_image').val(JSON.stringify(data, null, 4));
				}
			})
		});
	  	
	  	//update user image
	    $("#updateUserImage").submit(function(e) {
			e.preventDefault();
			$.ajax({
				type : "POST",
				url : '${pageContext.request.contextPath }/api/user/update_image/' + $('#userId').val(),
				enctype : 'multipart/form-data',
				data : new FormData(document.getElementById("updateUserImage")),
				processData : false, // tell jQuery not to process the data
				contentType : false, // tell jQuery not to set contentType
				success : function(data) {
					$('#rs_user_update_image').val(JSON.stringify(data, null, 4));
				},
				error : function(data) {
					$('#rs_user_update_image').val(JSON.stringify(data, null, 4));
				}
			})
		});
	  	
	  	//Article
	  	
	  	//retrieve all article
	    $("#article_r001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_article_r001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/article/hrd_r001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_article_r001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_article_r001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	  	
	  	//insert article
	    $("#article_c001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_article_c001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/article/hrd_c001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_article_c001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_article_c001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
		
	  	//update article
	    $("#article_u001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_article_u001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/article/hrd_u001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_article_u001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_article_u001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
		
	  	//remove article
	    $("#article_d001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_article_d001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/article/hrd_d001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_article_d001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_article_d001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	  	
	  	//enable article
	    $("#article_e001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_article_e001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/article/hrd_e001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_article_e001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_article_e001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	  	
	  	//detail article
	    $("#article_det001").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_article_det001').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/article/hrd_det001',
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_article_det001').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_article_det001').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	  	
	  	//search article
	    $("#article_search").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_article_search').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/article/search/' + $("#searchArticle").val() ,
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_article_search').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_article_search').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	  	
	  	//view user article
	    $("#article_user").click(function(){
	    	var JSONObject = $.parseJSON($('#ta_article_user').val());
	    	
	    	$.ajax({
	            url: '${pageContext.request.contextPath }/api/article/user/' + $("#articleUserId").val() ,
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	$('#rs_article_user').val(JSON.stringify(data, null, 4));
	            },
	            error: function(data){
	            	$('#rs_article_user').val(JSON.stringify(data, null, 4));
	            }
	        });	    	
	    });
	  	
	  	//upload article image
	    $("#articleImage").submit(function(e) {
			e.preventDefault();
			$.ajax({
				type : "POST",
				url : '${pageContext.request.contextPath }/api/article/upload_image',
				enctype : 'multipart/form-data',
				data : new FormData(document.getElementById("articleImage")),
				processData : false, // tell jQuery not to process the data
				contentType : false, // tell jQuery not to set contentType
				success : function(data) {
					$('#rs_article_upload_image').val(JSON.stringify(data, null, 4));
				},
				error : function(data) {
					$('#rs_article_upload_image').val(JSON.stringify(data, null, 4));
				}
			})
		});
	  	
	  	//update article image
	    $("#updateArticleImage").submit(function(e) {
			e.preventDefault();
			$.ajax({
				type : "POST",
				url : '${pageContext.request.contextPath }/api/article/update_image/' + $('#articleId').val(),
				enctype : 'multipart/form-data',
				data : new FormData(document.getElementById("updateArticleImage")),
				processData : false, // tell jQuery not to process the data
				contentType : false, // tell jQuery not to set contentType
				success : function(data) {
					$('#rs_article_update_image').val(JSON.stringify(data, null, 4));
				},
				error : function(data) {
					$('#rs_article_update_image').val(JSON.stringify(data, null, 4));
				}
			})
		});
	  	
		
	});
</script>	

</body>
</html>