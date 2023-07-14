const minusBtns = document.querySelectorAll(".minus-btn");
const plusBtns = document.querySelectorAll(".plus-btn");
const inputFields = document.querySelectorAll(".cart-input");

for (let i = 0; i < minusBtns.length; i++) {
	minusBtns[i].addEventListener("click", function() {
		if (inputFields[i].value > 1) {
			inputFields[i].value = parseInt(inputFields[i].value) - 1;
		}
	});
}

for (let i = 0; i < plusBtns.length; i++) {
	plusBtns[i].addEventListener("click", function() {
		if (inputFields[i].value < 999) {
			inputFields[i].value = parseInt(inputFields[i].value) + 1;
		}
	});
}