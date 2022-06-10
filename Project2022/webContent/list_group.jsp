<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="tn.iit.authentification.model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="common/Menu.jsp"></jsp:include>
				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Liste des Groupes</h1>
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div style="text-align: right; margin: 20px;">
							<a href="GroupController?action=add"
								class="btn btn-primary btn-icon-split"><span class="text">Create
									groupe</span> </a>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<c:choose>
									<c:when test="${currentuser.role == 0}">
										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<th>ID</th>
													<th>Label</th>
													<th>Nombre des etudiants</th>
													<th>Actions</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="group">
													<tr>
														<td>${group.id}</td>
														<td>${group.label}</td>
														<td>${group.nb_etd }</td>
														<th><a class="btn btn-success"
															href="GroupController?id=${group.id }&action=edit"> <i
																class="fa fa-edit"></i>
														</a> <a class="btn btn-danger"
															href="GroupController?id=${group.id }&action=delete">
																<i class="fa fa-trash"></i>
														</a></th>
													</tr>
												</c:forEach>
											</tbody>


										</table>
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${currentuser.role == 1 || currentuser.role == 3}">
										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<th>ID</th>
													<th>Label</th>
													<th>Nombre des etudiants</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listEns}" var="group">
													<tr>
														<td>${group[0]}</td>
														<td>${group[1]}</td>
														<td>${group[2] }</td>
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

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.jsp">Logout</a>
				</div>
			</div>
		</div>
	</div>

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