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
							<form class="user" action="InscriptionEditController"
								method="post">
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="exampleFirstName" placeholder="First Name"
											value="${user.firstName}" name="first_name" required>
										<input type="hidden" class="form-control form-control-user"
											id="exampleFirstName" placeholder="First Name"
											value="${user.id}" name="id" required>
									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											id="exampleLastName" placeholder="Last Name" name="last_name"
											value="${user.lastName }" required>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											placeholder="CIN" name="cin" value="${user.cin }" required>
									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											id="exampleLastName" placeholder="User name" name="user_name"
											value="${user.username }" required>
									</div>
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user"
										id="exampleInputEmail" placeholder="E-mail" name="email"
										value="${user.email}" required>
								</div>

								<div class="form-group row">
									<div class="col-sm-6">
										<select name="role" class="form-control"
											style="font-size: .8rem; border-radius: 10rem;" required>

											<option value="">--Please choose role--</option>
											<option value="1"
												${'1'== user.role ? 'selected="selected"' : ''}>Enseignant</option>
											<option value="2"
												${'2'== user.role ? 'selected="selected"' : ''}>Agent</option>
											<option value="3"
												${'3'== user.role ? 'selected="selected"' : ''}>Administration</option>

										</select>
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user"
											id="exampleInputPassword" placeholder="Password"
											value="${user.password }" name="password" required>
									</div>


								</div>
								<div class="row" style="text-align: center; display: block;">


									<button type="submit" class="btn btn-primary btn-user"
										style="width: 25%;">Save</button>
									<a href="InscriptionController?action=list"
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

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

</body>

</html>