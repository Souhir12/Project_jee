<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="tn.iit.authentification.model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="common/Menu.jsp"></jsp:include>
				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Liste des utilisateurs</h1>
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3"></div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>ID</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>CIN</th>
											<th>User Name</th>
											<th>E-mail</th>
											<th>Status</th>
											<th>Role</th>
											<th>Password</th>
											<th>Actions</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="user">
											<tr>
												<td>${user.id}</td>
												<td>${user.firstName}</td>
												<td>${user.lastName }</td>
												<td>${user.cin }</td>
												<td>${user.username }</td>
												<td>${user.email }</td>
												<td>${'1'== user.status ? 'Actif' : 'inactif'}</td>
												<td>${'1'== user.role ? 'Enseignant' :'2'== user.role ?'Agent':'3'== user.role ?'Administration': 'Super Admin'}</td>
												<td>${user.password }</td>
												<td><c:choose>
														<c:when test="${'1'== user.status}">
															<a class="btn btn-secondary"
																href="InscriptionController?id=${user.id}&action=inActif">
																<i class="fa fa-ban"></i>
															</a>

														</c:when>
														<c:otherwise>
															<a class="btn btn-success"
																href="InscriptionController?id=${user.id}&action=Actif">
																<i class="fa fa-check"></i>
															</a>
														</c:otherwise>
													</c:choose><a class="btn btn-warning"
													href="InscriptionEditController?id=${user.id }&action=Edit">
														<i class="fa fa-edit"></i>
												</a> <a class="btn btn-danger"
													href="InscriptionController?id=${user.id }&action=delete">
														<i class="fa fa-trash"></i>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>


								</table>
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