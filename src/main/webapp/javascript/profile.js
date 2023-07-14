const logoutLink = document.getElementById('logout-link');
const overlay = document.getElementById('confirmation-overlay');
const yesButton = document.getElementById('yes-button');
const noButton = document.getElementById('no-button');

logoutLink.addEventListener('click', function(event) {
	event.preventDefault();
	overlay.style.display = 'block';
});

yesButton.addEventListener('click', function() {
	window.location.href = "${pageContext.request.contextPath}/LogoutServlet";
});

noButton.addEventListener('click', function() {
	overlay.style.display = 'none';
});