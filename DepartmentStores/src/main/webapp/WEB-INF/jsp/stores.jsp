<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script> 
<script src="resources/js/datatables.min.js"></script>
<script src="resources/js/dataTables.bootstrap.min.js"></script>
<script	src="resources/js/dataTables.scroller.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>
<script type="text/javascript" src=resources/js/stores.js></script>
<link rel="stylesheet" type="text/css" href="resources/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/datatables.min.css">
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
        <div class="well clearfix col-md-12">
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
                <div class="panel-heading"><span>Store Departments</span></div>
                <div class="panel-body">
                    <button type="button" class="btn btn-primary pull-left addEntityModalBtn" data-toggle="modal" data-target="#addEntityModal">
                        Add Department
                    </button>
                    <intpu type="hidden" id="deptsOfLoc"/>
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
                  <div class="panel-heading"><span>Store Categories</span></div>
                  <div class="panel-body">
                      <button type="button" class="btn btn-primary pull-left addEntityModalBtn" data-toggle="modal" data-target="#addEntityModal">
                          Add Category
                      </button>
                      <intpu type="hidden" id="catgsOfDept"/>
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
                <div class="panel-heading"><span>Store Sub Categories</span></div>
                <div class="panel-body">
                    <button type="button" class="btn btn-primary pull-left addEntityModalBtn" data-toggle="modal" data-target="#addEntityModal">
                        Add SubCategory
                    </button>
                    <input type="hidden" id="subCatgsOfCatgs"/>
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

        <!-- Alert Div 
        <div id="alert-message" class="alert alert-danger" role="alert">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            test error message
        </div> -->
        <!-- Alert Model -->
        <div class="modal fade" id="alert-modal" role="dialog" aria-labelledby="modalCenterTitle" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered">
          
            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close alertClose" data-dismiss="modal" aria-label="Close">
	                <span aria-hidden="true">&times;</span>
	              </button>
                <h4 class="modal-title" id="alert-header">Modal Header</h4>
              </div>
              <div class="modal-body">
                <p id="alert-message"></p>
              </div>
            </div>
            
          </div>
        </div>      

      </div>
    
    </div>
  
  </body>
</html>