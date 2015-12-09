<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Article</title>
	<link href="${pageContext.request.contextPath}/resources/asset/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/asset/css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/asset/jasny-bootstrap/css/jasny-bootstrap.min.css">
	<style type="text/css">
		.clearPadding{
			padding-left: 0px;
			padding-right: 0px;
		}
	</style>
</head>
<body>
	<!-- header -->
	<div class="container-fluid head">
		<div class="row">
			<div class="col-xs-12">
					<h2>Well Come Article Manegement</h2>
			</div>
		</div>
	</div>
    <br/>
   	<div class='container-fluid'>
				<div class='row'>
					<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2" >
						<div class="panel panel-primary">
						  <div class="panel-heading ">menu</div>
						  <div class="panel-body">
						  		<ul class="nav  bg-info">
							        <li><a href='${pageContext.request.contextPath}/'>Article</a></li>
							        <li><a href='${pageContext.request.contextPath}/user'>User</a></li>
							        <li><a href='${pageContext.request.contextPath}/api/document' target="_blank">API</a></li>
							     </ul>
						  </div> 
						   
						</div>
					</div>
					
					<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
						<div id="demo" class="collapse">
						<div class='row' >
							
							<div class="panel panel-primary">
							  <div class="panel-heading ">Form </div>
							  <div class="panel-body">
									<div class="box-body">
									<form action="" id="formstudent" enctype="multipart/form-data">
											<div class="form-horizontal"  >
											<!-- Input name -->
											<div class="form-group" >
												<label for="input-text" class="col-sm-2 control-label">Article Title</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" id="title" name="title" value=""  required="required" />
													<!-- <input type="hidden"  id="art_id" name="art_id" value="" /> -->
													<p style='display:none' id="url">${pageContext.request.contextPath}/api/article/hrd_c001</p>
													<p style='display:none' id="method">post</p>
													<p style='display:none' id="id"></p>
												</div>
											</div>
											<div class="form-group" >
												<label for="input-text" class="col-sm-2 control-label">Description</label>
												<div class="col-sm-10">
													<textarea class="form-control" rows="5" id="description"    name="description" value="" required="required"></textarea>
												</div>
											</div>
											<div class="form-group" id="myEnable" style="display: none; ">
												<label for="input-text" class="col-sm-2 control-label">Enable</label>
												<div class="col-sm-10">
													 <select class="form-control" id="enabled" name="enabled">
													    <option value="1">true</option>
													    <option value="0">false</option>
													  </select>
												</div>
											</div>
											
											
											<div class="form-group" >
												<label for="input-text" class="col-sm-2 control-label">Image</label>
												<div class="col-sm-10">
													<div class="fileinput fileinput-new" data-provides="fileinput">
													  <div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 100px; height:100px;"></div>
													  <div>
														<span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span class="fileinput-exists">Change</span>
														<input type="file" id="ART_IMG"   name="ART_IMG">
														<input type="hidden" class="form-control" id="OLD_IMG"   name="OLD_IMG"  ></span>
														<a href="#" id="re_image" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
													  </div>
													</div>
													
												</div>
											</div>
										
											<!-- submit button-->
												<div class="form-group">
													<label class="col-sm-2 control-label"></label>
													<div class="col-sm-5">
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="TOKEN"/>
														<input type="hidden" name="user" value="" id="user"/>
														<input type="submit" value="Save"  class="btn btn-success">
														<button id="clear" onclick="myClear()" class="btn btn-success">Clear</button>
														
													</div>
												</div>
											</div>
											
										</div>
									</form>
									
								 
							
							  </div>  
							</div>
						</div>
						</div> 
						<!-- inser and search-->
						<div class="row" >
							<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 clearPadding">
								<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Insert Form</button>
								
							</div>
							<div class="col-xs-12 col-sm-1 col-md-1 col-lg-1 clearPadding">
								 	 <select class="form-control" id="enabled" name="enabled">
									    <option value="5">5</option>
									    <option value="10">10</option>
									    <option value="20">20</option>
									    <option value="50">50</option>
									    <option value="100">100</option>
									  </select>
								 
							</div>
							<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9 clearPadding">
								<form action="${pageContext.request.contextPath}/searchpro"  method="POST">
									<div class="input-group">
									  <input type="text" class="form-control" id="key" name="key" placeholder="Search for...">
									  <span class="input-group-btn">
										<button class="btn btn-success" onclick="search();" type="button">Search</button>
									  </span>
									</div>
								</form>
							</div>
						</div>
						<br/>
						<!-- Table -->
						<div class="row" >
							<div class="panel panel-primary">
							  <div class="panel-heading ">List Article</div>
								<div class="panel-body">
									
									<div id="showresult"></div>
									 
		      						<div id="content"></div>
    								<div id="demo4_top" class="demo4_top"></div>
    	
									<!-- pagegination -->
									<div id="recordresult"></div>
         							<div id="pageresult"></div>
								
								</div>  
							</div>
						</div>
					</div>
						
				</div>
					
					
			</div>
		
			
	<!-- footer -->
	<div class="container-fluid foot">
		<div class="row">
			<div class="col-xs-12">
					<h4>Copy Right@2015</h4>
			</div>
		</div>
	</div>
	
	<!-- alert veiw -->
	<div class='modal fade' id='myModal' role='dialog'>
    <div class='modal-dialog modal-lg'>
    
      <!-- Modal content-->
      <div class='modal-content'>
        <div class='modal-header'>
          <button type='button' class='close' data-dismiss='modal'>&times;</button>
          <h4 class='modal-title'>Profile</h4>
        </div>
        <div class='modal-body'>
		  	<div id="myView"></div>  
        </div>
        <div class='modal-footer'>
          <button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>
        </div>
      </div>
      
    </div>
  </div>
	
	
	<!-- script references -->
	
	<script src="${pageContext.request.contextPath}/resources/asset/js/jquery-2.1.4.js"></script>
	<script src="${pageContext.request.contextPath}/resources/asset/bootstrap/js/bootstrap.min.js"></script>
	 <script src="${pageContext.request.contextPath}/resources/asset/jasny-bootstrap/js/jasny-bootstrap.min.js"></script>
	 <script src="${pageContext.request.contextPath}/resources/asset/js/bootpag.js"></script>
	 <script src="${pageContext.request.contextPath}/resources/asset/ckeditor/ckeditor.js"></script>
	 <!-- <script src="//raw.github.com/botmonster/jquery-bootpag/master/lib/jquery.bootpag.min.js"></script> -->
	<%-- <script src="${pageContext.request.contextPath}/resources//ckeditor/ckeditor.js"></script> --%>
	<script>
	
	var mypage=1;
	var totalofrecord =0;
	
	function loadPagination(){

		$('.demo4_top').bootpag({
	        total: numofpage,
	        
	        maxVisible: 5,
	        leaps: true,
	        firstLastUse: true,
	        first: '&#8592;',
	        last: '&#8594;',
	        wrapClass: 'pagination',
	        activeClass: 'active',
	        disabledClass: 'disabled',
	        nextClass: 'next',
	        prevClass: 'prev',
	        lastClass: 'last',
	        firstClass: 'first'
	    }).on("page", function(event, num){
	   		  displayPage(num);
	    }); 
	}
	 
	function displayPage(mypage){
		
		$.ajax({
			method : "GET",
			url : "displaypage",
			data : {
				stuname : $("#searchf").val(),
				page : mypage
				
			},
			success : function(data){
				  $("#result").html(listTB(data));  
				
				 
			}
		});
	} 
	
	
	
	
	
	
	
	
	
	
	 $('#formstudent').submit(function(e){
		e.preventDefault();
		var mypath="${pageContext.request.contextPath}/";
		var id=$("#id").text();
		var t=$("#title").val();
		var d=$("#description").val();
		///alert(d);
		var u="2";
		var e=$("#enabled").val();;
		var img=$("#ART_IMG").val();
		var o_img=$("#OLD_IMG").val();
		
		//insert no image
		if(img =="" && o_img ==""){
			myInsert(t,d,u,img);
		}
		//idrect update
		else if(img =="" && o_img.length !== 0 ){
			updateProcess(id,t,d,e,u,o_img);
		}
		//insert image and update
		else if(img.length !== 0 && o_img.length !== 0 ){
			 $.ajax({
					type : "POST",
					url : '${pageContext.request.contextPath }/api/article/upload_image',
					enctype : 'multipart/form-data',
					data : new FormData(document.getElementById("formstudent")),
					processData : false, 
					contentType : false, 
					success : function(data) {
						if(data.STATUS =='1'){
							updateProcess(id,t,d,e,u,data.ART_IMG);
						}
					},
					error : function(data) {
						alert("0 unsuccess data");
					}
				}) 
		}
		//insert with image
		else {
			$.ajax({
				type : "POST",
				url : '${pageContext.request.contextPath }/api/article/upload_image',
				enctype : 'multipart/form-data',
				data : new FormData(document.getElementById("formstudent")),
				processData : false, // tell jQuery not to process the data
				contentType : false, // tell jQuery not to set contentType
				success : function(data) {
					if(data.STATUS =='1'){
						myInsert(t,d,u,data.ART_IMG);
					}
				},
				error : function(data) {
					alert("1 unsuccess data");
				}
			})
		}
	});
	 
	 //isnert process
	 function myInsert(t,d,u,i){
			var JSONObject = $.parseJSON('{"title":"'+t+'","description":"'+d+'", "userId":"'+u+'" , "image":"'+i+'"}');
	    	
			$.ajax({
	            url: "${pageContext.request.contextPath}/api/article/hrd_c001",
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	if(data.STATUS =='1'){
		            	myClear();
					}
	            	listAll();
	            },
	            error: function(data){
	            	alert("2 unsuccess data");
	            }
	        });	    	
		} 
	 
	 //update process
	 function updateProcess(id,t,d,e,u,i){
		 	var eanble ="true";
		 	if(e=='1'){
		 		eanble ="true";
		 	}else{
		 		eanble ="false";
		 	}
		 	
			var JSONObject = $.parseJSON('{"id":"'+id+'","title":"'+t+'","description":"'+d+'","enabled":"'+eanble+'", "userId":"'+u+'" , "image":"'+i+'"}');
	    	//alert("Id="+id+"title="+t+"description="+d+"enable="+e+"user="+u+"image="+i);
			$.ajax({
	            url: "${pageContext.request.contextPath}/api/article/hrd_u001",
	            type: 'post',
	            contentType: 'application/json;charset=utf-8',
	            data: JSON.stringify(JSONObject),
	            success: function(data){
	            	/* if(data.STATUS =='1'){
		            	myClear();
					} */
	            	listAll();
	            },
	            error: function(data){
	            	alert("3 unsuccess data");
	            }
	        });	    	
		} 
	
 	function myEdite(id){
		var mypath="${pageContext.request.contextPath}/";
		var JSONObject = $.parseJSON('{"id":"'+id+'"}');
	 	$.ajax({  
		       url:'${pageContext.request.contextPath}/api/article/hrd_det001',  
		       type:'post',
		       contentType: 'application/json;charset=utf-8', // type of data
		       data: JSON.stringify(JSONObject),
		       success: function(data) { 
		    	   			
				    	    var Enable=0;
			   	   			if(data.RES_DATA.enabled == true){
			   	   				Enable =1;
			   	   			}else{
			   	   				Enable =0;
				   	   			}
				   	   		$("#myEnable").show();
		    	   			$("#enabled").val(Enable);
		    	   			
		    	   			$("#id").text(data.RES_DATA.id);
		    	   			$("#url").text(mypath+'/api/article/hrd_u001');
		    	   			$("#method").text('post');
		    	   		 	$("#title").val(data.RES_DATA.title);
				    	    $("#description").val(data.RES_DATA.description);
				    	    $("#OLD_IMG").val(data.RES_DATA.image); 
				    	  
		                console.log("Success..." + data);
		       }  ,  
		   		error: function(data){
		   		alert("Unsuccess" + data);
		   		console.log("ERROR..." + data);
		   	}
		   }); 
	} 
	

	
	 function myView(id){
		var JSONObject = $.parseJSON('{"id":"'+id+'"}');
    	
    	$.ajax({
            url: '${pageContext.request.contextPath }/api/article/hrd_det001',
            type: 'post',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            success: function(data){
            	$("#myView").html(showView(data));
            },
            error: function(data){
            	alert("unsuccess data");
            }
        });	    	
	} 
	
	 function showView(data) {
		var view="";
		view +="<div class=''>"+
				"<br/>"+
				"<div class='row'>"+
					"<div class='col-xs-2'>"+
						"<img src='"+path+ data.RES_DATA.image+"' width='100%'/>"+
					"</div>"+
					"<div class='col-xs-10'>"+
						"<a href='#'>"+ data.RES_DATA.title+"</a><br/>"+
						"<div class='glyphicon glyphicon-calendar'>Date:"+ data.RES_DATA.publishDate+"</div><br/>"+
						"<div>"+ data.RES_DATA.description+"</div> "+
					"</div>"+
				"</div>"+
			"</div>";
		return view
	}  

	
	function myClear() {
	
		$("#title").val("");//url
		$("#description").val("");
		$("#re_image").click();
		$("#OLD_IMG").val("");
		$("#url").text("${pageContext.request.contextPath}/api/article/hrd_c001");
	}
	
	//delete user
	$('body').on('click', '.del', function(){
		var id=$(this).attr("artid");
		var othis=$(this);
		var JSONObject = $.parseJSON('{"id":"'+id+'"}');
			$.ajax({
				url:'${pageContext.request.contextPath}/api/article/hrd_d001',
				type:'POST',
				data: JSON.stringify(JSONObject),
		        contentType: 'application/json;charset=utf-8', // type of data
		        success: function(data) { 
		        	//alert(data.STATUS);
		        	if(data.STATUS =="1"){
		        		othis.parents("tr").remove();
		        	}
		        },
		        headers: {
				    "X-CSRF-TOKEN" : $("#TOKEN").val(),
				    "content-type" : "application/json"
				},
		    	error: function(data){
		    		alert("unsuccess delete");
		    		console.log("ERROR..." + data);
		    	}
			});
			
	});

	
	
	listAll();
	function listAll(){
		
    	var JSONObject = $.parseJSON('{"row":"10","pageCount":"1"}');
    	
    	$.ajax({
            url: '${pageContext.request.contextPath }/api/article/hrd_r001',
            type: 'post',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            success: function(data){
            	//alert(data);
            	$("#showresult").html(listarticles(data));
            },
            error: function(data){
            	alert("unseccess data");
            }
        });	    	
		   
	}
	
	function listarticles(data){
		 path ='${pageContext.request.contextPath}/';
		 //alert(path);
		var str="";
			str ="<table class='table table-hover'>"+
					"<thead>"+
					  "<tr class='info'>"+
						"<th width='5%'>ID</th>"+
						"<th width='25%'>Title Article</th>"+
						"<th width='10%'>Enable</th>"+
						"<th width='10%'>Public Date</th>"+
						"<th width='5%'>Image</th>"+
						"<th width='20%'>Action</th>"+
					 "</tr>"+
					"</thead>"+
					"<tbody>";
			for(var i=0; i<data.RES_DATA.length ; i++){
				str += "<tr>"+
							"<td>"+ data.RES_DATA[i].id +"</td>"+
							"<td>"+ data.RES_DATA[i].title +"</td>"+
							"<td>"+ data.RES_DATA[i].enabled+"</td>"+
							"<td>"+ data.RES_DATA[i].publishDate +"</td>"+
							"<td><img src='"+path+ data.RES_DATA[i].image+"'  width='80%'/></td>"+
							"<td>"+
								"<button onclick=myView("+data.RES_DATA[i].id+") class='btn btn-success btn-sm' data-toggle='modal' data-target='#myModal'>View</button>"+ '&nbsp;&nbsp;'+
								"<button onclick=myEdite("+data.RES_DATA[i].id+") class='btn btn-primary btn-sm' data-toggle='collapse' data-target='#demo'>Edit</button> "+ '&nbsp;&nbsp;'+
								"<button class='btn btn-danger btn-sm del' artid="+data.RES_DATA[i].id+">Delete</button>"+ 
							"</td>";
						"</tr>";
			}
					
			str += "</tbody></table>";
			return str;
	}
	
 	function search(){
		var key =$("#key").val();
		var JSONObject = $.parseJSON('{"row":"10","pageCount":"1"}');
		$.ajax({  
		       url:'${pageContext.request.contextPath}/api/article/search/'+key,  
		       type:'post',
		       contentType: 'application/json;charset=utf-8', // type of data
		       data: JSON.stringify(JSONObject),
		       success: function(data) { 
		    	   		//alert(data);
		    	   		$("#showresult").html(listarticles(data));
		                console.log("Success..." + data);
		       }  ,  
		   		error: function(data){
		   		alert("Unsuccess" + data +"OR Empty");
		   		console.log("ERROR..." + data);
		   	}
		   });
	
	} 


 	
 	 /*  window.onload = function() {
         CKEDITOR.replace( 'description' );
 	};   */
 	
	</script>
	
	
</body>
</html>