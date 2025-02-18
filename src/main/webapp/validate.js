document.addEventListener("DOMContentLoaded", function () {
  const form = document.querySelector("form");

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const username = document.getElementById("uname").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("pword").value.trim();
    const city = document.getElementById("city").value.trim();
    const fullname = document.getElementById("fname").value.trim();
    const mobile = document.getElementById("phno").value.trim();

    // Username validation (minimum 3 characters)
    if (username.length < 3) {
      alert("Username must be at least 3 characters long.");
      return;
    }

    // Email validation using regex
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailPattern.test(email)) {
      alert("Please enter a valid email address.");
      return;
    }

    // Password validation (minimum 6 characters)
    if (password.length < 6) {
      alert("Password must be at least 6 characters long.");
      return;
    }

    // City validation (not empty)
    if (city === "") {
      alert("Please enter your city name.");
      return;
    }

    // Full name validation (only letters and spaces allowed)
    const namePattern = /^[a-zA-Z\s]+$/;
    if (!namePattern.test(fullname)) {
      alert("Full name can only contain letters and spaces.");
      return;
    }

    // Mobile number validation (10 digits)
    const mobilePattern = /^[0-9]{10}$/;
    if (!mobilePattern.test(mobile)) {
      alert("Please enter a valid 10-digit mobile number.");
      return;
    }

    alert("Form submitted successfully!");
    form.submit();
  });
});
