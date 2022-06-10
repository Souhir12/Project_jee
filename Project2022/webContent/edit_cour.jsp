<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SB Admin 2 - Register</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					
					<div class="col-lg-12">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Edit Groupe</h1>
							</div>
							<form class="user" action="GroupController?action=edit1" method="post">
								<div class="form-group row">
								<input type="hidden" class="form-control form-control-user"
											id="exampleLastName" placeholder="Nombre des etudiant" name="id" value="${groupe.id }"
											required>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="exampleFirstName" placeholder="label" value="${groupe.label }"
											name="label" required>
									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											id="exampleLastName" placeholder="Nombre des etudiant" name="nb_etd" value="${groupe.nb_etd }"
											required>
									</div>
								</div>

								<button type="submit" class="btn btn-primary btn-user btn-block">Save
									</button>
									

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