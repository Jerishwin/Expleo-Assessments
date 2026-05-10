// validate.js

window.onload = function () {
  document.querySelector("form").addEventListener("submit", function (e) {
    e.preventDefault();
    let valid = true;

    function showError(_input, id, msg) {
      let err = document.getElementById(id);
      if (!err) {
        err = document.createElement("span");
        err.id = id;
        err.style.color = "red";
        err.style.fontSize = "13px";
        _input.insertAdjacentElement("afterend", err);
      }
      err.textContent = msg;
    }

    function clearError(id) {
      let err = document.getElementById(id);
      if (err) err.textContent = "";
    }

    let name = document.getElementById("name").value.trim();
    if (name === "") {
      showError(document.getElementById("name"), "err-name", "Full Name must not be empty.");
      valid = false;
    } else {
      clearError("err-name");
    }

    let email_ = document.getElementById("email");
    let email = email_.value.trim();
    if (!email.includes("@") || !email.endsWith(".com")) {
      showError(email_, "err-email", "Email must contain '@' and end with '.com'.");
      valid = false;
    } else {
      clearError("err-email");
    }

    let dob = document.getElementById("dob").value;
    if (!dob) {
      showError(document.getElementById("dob"), "err-dob", "Date of Birth must not be empty.");
      valid = false;
    } else {
      clearError("err-dob");
    }


    let course = document.getElementById("course");
    if (!course.value) {
      showError(course, "err-course", "Please select a course.");
      valid = false;
    } else {
      clearError("err-course");
    }

    if (valid) {
      alert("Form submitted successfully!");

    }
  });
};