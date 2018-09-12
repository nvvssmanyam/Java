<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="/resources/js/jquery.dataTables.min.js"></script> 
<script src="/resources/js/datatables.min.js"></script>
<script src="/resources/js/dataTables.bootstrap.min.js"></script>
<script	src="/resources/js//dataTables.scroller.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/css/datatables.min.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<title>Stores</title>
</head>
<body>
    <div class="container">
      <div>
        <h3 class="text-center">Departmental Stores</h3>
      </div>
      <!-- Button Launch Stores -->
      <input type="button" class="btn btn-primary pull-left" id="launchStores" value="Launch Stores"/>
      <!-- Button trigger modal -->
      <input type="button" class="btn btn-primary pull-right" id="lnchstoresTree" value="Launch Tree view" />
      
      
      <!-- Modal -->
      <div class="modal fade entityModel" id="addEntityModal" tabindex="-1" role="dialog" aria-labelledby="modalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="modalEntityTitle">Add Location</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <form id="addEntityForm" action="" method="POST">
                <div class="form-group">
                  <label for="name" id="addEntityLabel">Name:</label>
                  <input type="text" class="form-control" id="entityName" name="entityName">
                </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              <button type="submit" class="btn btn-primary">Save</button>
          </form>
            </div>
          </div>
        </div>
      </div>
    
      <div class="row form-group"></div>
    
      <div class="container">
        <div class="well clearfix">
          <div class="col-md-12">
            <!--Tree view panel -->
            <div class="panel panel-default treeDiv">
              <div class="panel-heading">Department Stores Treeview</div>
              <div class="panel-body">
                <div class="row">
                  <div class="col-md-8 treeview" id="treeview_json">
                    <!-- Tree will be show here -->
                  </div>	
                </div>
              </div>	
            </div>
            <!-- Location table panel -->
            <div class="panel panel-default storesDiv">
              <div class="panel-heading">Store Locations</div>
              <div class="panel-body">
                  <button type="button" class="btn btn-primary pull-left addEntityModalBtn" data-toggle="modal" data-target="#addEntityModal">
                      Add Location
                  </button>
                  <div class="row form-group"></div>
                  <table id="storesTable" class="table table-striped table-bordered display" style="width: 100%">
                      <thead>
                        <tr>
                          <th>Type</th>
                          <th>Name</th>
                          <th>Load Child</th>
                          <th>Status</th>
                        </tr>
                      </thead>
                      <tbody></tbody>
                  </table>
              </div>
            </div>
            <!-- Departments table panel -->
            <div class="panel panel-default deptsDiv">
                <div class="panel-heading">Store Departments</div>
                <div class="panel-body">
                    <button type="button" class="btn btn-primary pull-left addEntityModalBtn" data-toggle="modal" data-target="#addEntityModal">
                        Add Department
                    </button>
                    <div class="row form-group"></div>
                    <table id="deptsTable" class="table table-striped table-bordered display" style="width: 100%">
                        <thead>
                          <tr>
                            <th>Type</th>
                            <th>Name</th>
                            <th>Load Child</th>
                            <th>Status</th>
                          </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
              </div>
              
              <!-- Categories table panel -->
              <div class="panel panel-default catgsDiv">
                  <div class="panel-heading">Store Categories</div>
                  <div class="panel-body">
                      <button type="button" class="btn btn-primary pull-left addEntityModalBtn" data-toggle="modal" data-target="#addEntityModal">
                          Add Category
                      </button>
                      <div class="row form-group"></div>
                      <table id="catgsTable" class="table table-striped table-bordered display" style="width: 100%">
                          <thead>
                            <tr>
                              <th>Type</th>
                              <th>Name</th>
                              <th>Load Child</th>
                              <th>Status</th>
                            </tr>
                          </thead>
                          <tbody></tbody>
                      </table>
                  </div>
                </div>
                <!-- Sub Categories table panel -->
              <div class="panel panel-default subCatgsDiv">
                  <div class="panel-heading">Store Sub Categories</div>
                  <div class="panel-body">
                      <button type="button" class="btn btn-primary pull-left addEntityModalBtn" data-toggle="modal" data-target="#addEntityModal">
                          Add SubCategory
                      </button>
                      <div class="row form-group"></div>
                      <table id="subCatgsTable" class="table table-striped table-bordered display" style="width: 100%">
                          <thead>
                            <tr>
                              <th>Type</th>
                              <th>Name</th>
                              <th>Status</th>
                            </tr>
                          </thead>
                          <tbody></tbody>
                      </table>
                  </div>
                </div>
          </div>
        </div>

        <!-- Alert Div -->
              <div id="alert-message" class="alert alert-danger" role="alert">
                  <button type="button" class="close" data-dismiss="alert">&times;</button>
                  test error message
              </div>

      </div>
    
    </div>
  
    <script type="text/javascript">
    
      function getDepts(locId){
        $.ajax({
          url : "/api/v1/location/"+locId+"/department",
          type : "GET",
          success : function(response) {
            if (response != null) {
              $("#deptsTable tbody").html("");
              var content = "";
              if(response.length == 0) {
                content="<span class='label label-default label-md'>No records found</span>"
              } else {
                $.each(response, function(key, value) {
                  content += "<tr><td>Department</td><td>"+value.deptName+"</td><td><button type='button' onclick='getCategories("
                  +locId+","+value.deptId+")' id="+value.deptId+" class='btn btn-success btn-sm loadDeptBtn'>Categories <span class='glyphicon glyphicon-plus'></span></button></td><td><button type='button' onclick='deleteRecord("
                  +locId+","+value.deptId+")' id="+value.deptId+" class='btn btn-danger btn-sm delRecord'><span class='glyphicon glyphicon-trash'></span></button></td></tr>";
                });
              }
              $("#deptsTable tbody").append(content);
              $(".deptsDiv").show();
            } 
          }
        });
      }
      function getCategories(locId, deptId){
        $.ajax({
          url : "/api/v1/location/"+locId+"/department/"+deptId+"/category",
          type : "GET",
          success : function(response) {
            if (response != null) {
              $("#catgsTable tbody").html("");
              var content = "";
              if(response.length == 0) {
                content="<span class='label label-default label-md'>No records found</span>"
              } else {
                $.each(response, function(key, value) {
                  content += "<tr><td>Category</td><td>"+value.catName+"</td><td><button type='button' onclick='getSubCategories("
                  +locId+","+deptId+","+value.catId+")' id="+value.catId+" class='btn btn-success btn-sm loadDeptBtn'>Sub Categories <span class='glyphicon glyphicon-plus'></span></button></td><td><button type='button' onclick='deleteRecord("
                  +locId+","+deptId+","+value.catId+")' id="+value.catId+" class='btn btn-danger btn-sm delRecord'><span class='glyphicon glyphicon-trash'></span></button></td></tr>";
                });
              }
              $("#catgsTable tbody").append(content);
              $(".catgsDiv").show();
            } 
          }
        });
      }
      function getSubCategories(locId, deptId, catId){
        $.ajax({
          url : "/api/v1/location/"+locId+"/department/"+deptId+"/category/"+catId+"/subcategory",
          type : "GET",
          success : function(response) {
            if (response != null) {
              $("#subCatgsTable tbody").html("");
              var content = "";
              if(response.length == 0) {
                content="<span class='label label-default label-md'>No records found</span>"
              } else {
                $.each(response, function(key, value) {
                  content += "<tr><td>Sub Category</td><td>"+value.subCatName+"</td><td><button type='button' onclick='deleteRecord("
                  +locId+","+deptId+","+catId+","+value.subCatId+")' id="+value.subCatId+" class='btn btn-danger btn-sm delRecord'><span class='glyphicon glyphicon-trash'></span></button></td></tr>";
                });
              }
              $("#subCatgsTable tbody").append(content);
              $(".subCatgsDiv").show();
            } 
          }
        });
      }
      function deleteRecord(locId, deptId, catId, subCatId) {
        debugger;
        if(subCatId != undefined) {
          urlString = "/api/v1/location/"+locId+"/department/"+deptId+"/category/"+catId+"/subcategory/"+subCatId;
        } else if (catId != undefined ){
          urlString = "/api/v1/location/"+locId+"/department/"+deptId+"/category/"+catId;
        } else if (deptId != undefined) {
          urlString = "/api/v1/location/"+locId+"/department/"+deptId;
        } else if (locId != undefined) {
          urlString = "/api/v1/location/"+locId;
        }
        $.ajax({
          url : urlString,
          type : "DELETE",
          success : function(response) {
            if(response == 1) {
              $("#alert-message").attr('class', 'alert alert-success');
              $("#alert-message").text("Record deleted sucessfully.");
              $("#alert-message").show();
              $("#launchStores").click();
            } else {
              $("#alert-message").attr('class', 'alert alert-danger');
              $("#alert-message").text("Record not deleted. Unique contraint error.")
              $("#alert-message").show();
            }
          },
          error : function(error) {
            $("#alert-message").attr('class', 'alert alert-danger');
            $("#alert-message").text("Record not deleted. Unique contraint error.")
            $("#alert-message").show();
          }
        });
      }
      
      function initTree(treeData) {
        $('#treeview_json').treeview({data: treeData});
      }

        var createEntityUrls = {
          "Location": "/api/v1/location/",
          "Department": "/api/v1/location/1/department/",
          "Category": "/api/v1/location/1/department/1/category/",
          "SubCategory": "/api/v1/location/1/department/1/category/1/subcategory"
        };
      
      $(document).ready(function() {
        $(".treeDiv").hide();
        $(".storesDiv").hide();
        $(".deptsDiv").hide();
        $(".catgsDiv").hide();
        $(".subCatgsDiv").hide();
        $("#alert-message").hide();

        $(".addEntityModalBtn").click(function() {
          var title = this.textContent.trim();
          var entity = title.split(" ")[1];
          $("#modalEntityTitle").text(title);
          $("#entityName").attr("name", "locName");
          $.each(createEntityUrls, function(key,value) {
            if(entity == key) {
              formURL=value;
            }
          }); 
        });

        $("#launchStores").click(function() {
          var sotresMode = $(".storesDiv").is(":visible");
          if(sotresMode) {
            $(".storesDiv").hide();
          } else {
            $.ajax({
              url : "/api/v1/location",
              method : "GET",
              success : function(response) {
                if (response != null) {
                  $("#storesTable tbody").html("");
                  var content = "";
                  $.each(response, function(key, value) {
                    content += "<tr><td>Location</td><td>"+value.locName+"</td><td><button type='button' onclick='getDepts("
                    +value.locId+")' id="+value.locIid+" class='btn btn-success btn-sm loadDeptBtn'>Departments <span class='glyphicon glyphicon-plus'></span></button></td><td><button type='button' onclick='deleteRecord("
                    +value.locId+")' id="+value.locIid+" class='btn btn-danger btn-sm delRecord'><span class='glyphicon glyphicon-trash'></span></button></td></tr>";
                  });
                  $("#storesTable tbody").append(content);
                } 
              }
            });
            $(".storesDiv").show();
          }
        });

        $("#lnchstoresTree").click(function() {
           var mode = $("#treeview_json").is(":visible");
           if(mode) {
            $(".treeDiv").hide();
           } else {
            $.ajax({
              url : "/api/v1/location",
              success : function(response) {
                if (response != null) {
                  $.each(response, function(key, value) {
                    response = JSON.parse(JSON.stringify(response).split('"locName":').join('"text":'));
                    response = JSON.parse(JSON.stringify(response).split('"deptName":').join('"text":'));
                    response = JSON.parse(JSON.stringify(response).split('"catName":').join('"text":'));
                    response = JSON.parse(JSON.stringify(response).split('"subCatName":').join('"text":'));
                    response = JSON.parse(JSON.stringify(response).split('"departments":').join('"nodes":'));
                    response = JSON.parse(JSON.stringify(response).split('"categories":').join('"nodes":'));
                    response = JSON.parse(JSON.stringify(response).split('"subCategories":').join('"nodes":'));
                  });
                  initTree(response);
                  $(".treeDiv").show();
                }
              }
            }); 
           }
        });
        $(".expandBtn").click(function() {
          alert();
        });
        
        $("#addEntityForm").submit(function(e) {
          debugger;
          var entitykey = $("#entityName").attr("name");
          var entityval = $("#entityName").val();
          var entity = {
            entitykey: entityval
          }
          
          var jsonData = JSON.stringify(entity);
          
          //if(title != "" && name != "" && phone != "" && ext != "" && fax != "" && email != "") {
              $.ajax({
                   type: "POST",
                   url: formURL,
                   data: jsonData,
                   contentType: 'application/json; charset=utf-8',
                   dataType: 'json',
                   success: function(data)
                   {
                     debugger;
                       console.log(data); // show response from the php script.
                       $('#addEntityModal').modal('hide');
                       $("#lnchstoresTree").click();
                   },
                   error: function(data)
                   {
                     debugger;
                     console.log(data);
                     alert(data.status);
                   }
                 });
          //}				
  
            e.preventDefault(); // avoid to execute the actual submit of the form.
        });
        
      });
    </script>
  </body>
</html>