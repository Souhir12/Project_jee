<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="common/Menu.jsp"></jsp:include>

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">

					<div class="col-lg-12">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Create Cour</h1>

							</div>

							<form class="user" action="CourController?action=add1"
								method="post" enctype="multipart/form-data">
								<div class="form-group row">
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											id="exampleLastName" placeholder="Nombre des copie"
											name="nb_copie" required>
									</div>
									<div class="col-sm-6">
										<select name="gem_id" class="form-control"
											style="font-size: .8rem; border-radius: 10rem;" required>
											<option value="">Choix de Groupe - Matière</option>
											<c:forEach items="${list}" var="matiere">
												<option value="${matiere[2]}">${matiere[0]}-
													${matiere[1]}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0 row">
										<div class="col-md-4">
											<label>date de tirage :</label>
										</div>
										<div class="col-md-8">
											<input class="form-control form-control-user"
												type="datetime-local" id="meeting-time" name="tiragedate"
												value="2022-06-14T15:08">
										</div>

									</div>
									<div class="col-sm-6 mb-3 mb-sm-0 row">
										<div class="col-md-4">
											<label>document :</label>
										</div>
										<div class="col-md-8">
											<input class="form-control form-control-user" type="file"
												name="file" value="document" required />
										</div>

									</div>
								</div>
								<div style="color: red;">
									<%
									if (request.getAttribute("erreur") != null) {
										out.append(request.getAttribute("erreur").toString());
									}
									%>
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