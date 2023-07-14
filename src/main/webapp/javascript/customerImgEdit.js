let image = document.getElementById("profileImg");
let profileImgInput = document.getElementById("profileImgInput");

profileImgInput.onchange = (e) => {
	if (profileImgInput.files[0]) {
		image.src = URL.createObjectURL(profileImgInput.files[0]);
	}
};