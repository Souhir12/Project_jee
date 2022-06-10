<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="common/Menu.jsp"></jsp:include>

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">

					<div class="col-lg-12">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Create Groupe</h1>
							</div>
							<form class="user" action="GroupController?action=add1"
								method="post">
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="exampleFirstName" placeholder="label" name="label"
											required>
									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											id="exampleLastName" placeholder="Nombre des etudiant"
											name="nb_etd" required>
									</div>
								</div>
								<div class="row" style="text-align: center; display: block;">


									<button type="submit" class="btn btn-primary btn-user"
										style="width: 25%;">Save</button>
									<a href="GroupController?action=list"
										class="btn btn-primary btn-user "
										style="width: 25%; background-color: #ff0000b8;">Back</a>

								</div>
							 
							</form>
							 
						</div>
					</div>
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

</body>

</html>