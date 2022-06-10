<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="tn.iit.authentification.model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="common/Menu.jsp"></jsp:include>
				<div class="container">

					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<!-- Nested Row within Card Body -->
							<div class="row">

								<div class="col-lg-12">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">Update Affectation
												Enseignant</h1>
										</div>

										<form class="user"
											action="GroupEnseignantMatiere?action=edit1" method="post">
											<input type='hidden' name="id" value="${GEM.id}">
											<div class="form-group row">
												<div class="col-sm-6" style="margin-bottom: 2%;">
													<select name="user" class="form-control"
														style="font-size: .8rem; border-radius: 10rem;" required>
														<option value="">--Please choose teacher--</option>
														<c:forEach items="${list_enseignant}" var="user">
															<option value="${user.id}"
																${user.id==GEM.enseignant_id.id ? 'selected="selected"' : ''}>${user.firstName}
															</option>
														</c:forEach>
													</select>
												</div>
												<div class="col-sm-6">
													<select name="groupe" class="form-control"
														style="font-size: .8rem; border-radius: 10rem;" required>
														<option value="">--Please choose Group--</option>
														<c:forEach items="${list_groupe}" var="group">
															<option value="${group.id}"
																${group.id==GEM.groupe_id.id ? 'selected="selected"' : ''}>${group.label}
															</option>
														</c:forEach>
													</select>
												</div>
												<div class="col-sm-6">
													<select name="matiere" class="form-control"
														style="font-size: .8rem; border-radius: 10rem;" required>
														<option value="">--Please choose subject--</option>
														<c:forEach items="${list_matiere}" var="matiere">
															<option value="${matiere.id}"
																${matiere.id==GEM.matiere_id.id ? 'selected="selected"' : ''}>${matiere.label}
															</option>
														</c:forEach>
													</select>
												</div>

											</div>
											<div class="row" style="text-align: center; display: block;">


												<button type="submit" class="btn btn-primary btn-user"
													style="width: 25%;">Save</button>
												<a href="GroupEnseignantMatiere?action=list"
													class="btn btn-primary btn-user "
													style="width: 25%; background-color: #ff0000b8;">Back</a>

											</div>


												<hr>
										</form>
										<hr>

									</div>
								</div>
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