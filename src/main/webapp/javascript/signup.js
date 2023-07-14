const passwordInput = document.querySelector("#password");
const showPasswordButton = document.querySelector("#show-password");
const showIcon = '<i class="fas fa-eye"></i>';
const hideIcon = '<i class="fas fa-eye-slash"></i>';

showPasswordButton.addEventListener("click", function() {
	const type =
		passwordInput.getAttribute("type") === "password" ? "text" : "password";
	passwordInput.setAttribute("type", type);
	this.innerHTML = type === "password" ? showIcon : hideIcon;
});

console.log("Ajax...")
//Ajax
$(document).ready(function() {
	console.log("Loading...")

	$('#signup-form').on('submit', function(event) {
		event.preventDefault();

		let form = new FormData(this);

		$("#submit-btn").hide();
		$("#loader").show();

		// Wait for 3 seconds before submitting the form
		setTimeout(function() {
			//send SignupServlet
			$.ajax({
				url: "../SignupServlet",
				type: "POST",
				data: form,
				success: function(data, textStatus, jqXHR) {
					console.log(data)
					$("#submit-btn").show();
					$("#loader").hide();
					if (data.trim() === "You have registered successfully.") {
						swal("You have registered successfully.")
							.then((value) => {
								window.location = "login.jsp"
							});
					} else {
						swal(data);
					}
				},
				error: function(jqXHR, textStatus, errorThrown) {
					$("#submit-btn").show();
					$("#loader").hide();
					swal("Something went wrong. Try again!!!");
				},
				processData: false,
				contentType: false
			});
		}, 3000); // 3 seconds delay
	});
});
