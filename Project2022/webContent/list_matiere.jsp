<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="tn.iit.authentification.model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="common/Menu.jsp"></jsp:include>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Liste des Matiere</h1>
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div style="text-align: right; margin: 20px;">
							<a href="MatiereController?action=add"
								class="btn btn-primary btn-icon-split"><span class="text">Create
									Matiere</span> </a>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<c:choose>
									<c:when test="${currentuser.role == 0 }">

										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<th>ID</th>
													<th>Label</th>
													<th>Actions</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="matiere">
													<tr>
														<td>${matiere.id}</td>
														<td>${matiere.label}</td>
														<th><a class="btn btn-success"
															href="MatiereController?id=${matiere.id }&action=edit">
																<i class="fa fa-edit"></i>
														</a> <a class="btn btn-danger"
															href="MatiereController?id=${matiere.id }&action=delete">
																<i class="fa fa-trash"></i>
														</a></th>
													</tr>
												</c:forEach>
											</tbody>


										</table>
									</c:when>
								</c:choose>
								
								<!-- Version enseignant -->
								<c:choose>
									<c:when test="${currentuser.role == 1 || currentuser.role == 3}">

										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<th>ID</th>
													<th>Label</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listEns}" var="matiere">
													<tr>
														<td>${matiere[0]}</td>
														<td>${matiere[1]}</td>
													</tr>
												</c:forEach>
											</tbody>


										</table>
									</c:when>
								</c:choose>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2020</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->
 

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>

</body>

</html>