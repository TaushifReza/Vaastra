/** //Ajax
$(document).ready(function() {
	console.log("Loading...")

	$('#update-form').on('submit', function(event) {
		event.preventDefault();

		let form = new FormData(this);

		$("#btn-container").hide();
		$("#loader").show();

		// Wait for 5 seconds before submitting the form
		setTimeout(function() {
			//send SignupServlet
			$.ajax({
				url: "../CustomerEditProfile",
				type: "GET",
				data: form,
				success: function(data, textStatus, jqXHR) {
					console.log(data)
					$("#btn-container").show();
					$("#loader").hide();
					if (data.trim() === "Profile Updated.") {
						swal("Profile Updated.")
							.then((value) => {
								window.location = "profile.jsp"
							});
					} else {
						swal(data);
					}
				},
				error: function(jqXHR, textStatus, errorThrown) {
					$("#btn-container").show();
					$("#loader").hide();
					swal("Something went wrong. Try again!!!");
				},
				processData: false,
				contentType: false
			});
		}, 2000); // 3 seconds delay
	});
});**/