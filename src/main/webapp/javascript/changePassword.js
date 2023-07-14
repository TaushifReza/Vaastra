// Get the form and the password input elements
const form = document.querySelector(".editForm");
const newPasswordInput = document.getElementById("newPasswor");
const confirmPasswordInput = document.getElementById("confirmPassword");

// Get the overlay and error message elements
const overlay = document.getElementById("overlay");
const closeBtn = document.getElementById("closeBtn");
const errorMessage = document.getElementById("errorMessage");

// Add an event listener to the form's submit event
form.addEventListener("submit", (event) => {
	// Get the values of the password input elements
	const newPassword = newPasswordInput.value;
	const confirmPassword = confirmPasswordInput.value;

	// Check if the passwords match
	if (newPassword !== confirmPassword) {
		// If the passwords don't match, prevent the form from submitting
		event.preventDefault();

		// Show the overlay with the error message
		errorMessage.textContent =
			"New password and confirm password didnot match.";
		overlay.style.display = "block";
	}
});

// Add an event listener to the close button
closeBtn.addEventListener("click", () => {
	// Hide the overlay
	overlay.style.display = "none";
});