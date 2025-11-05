
document.getElementById("formLogin").addEventListener("submit", function(event) {
    event.preventDefault();

    // Obtenemos los valores del formulario
    const correo = document.getElementById("correo_usuario").value;
    const contrasena = document.getElementById("contrasena_usuario").value;

    // Creamos el objeto a enviar
    const usuario = {
        correoUsuario: correo,
        contrasenaUsuario: contrasena
    };

    // Llamamos al endpoint del backend
    fetch("http://localhost:8081/api/usuarios/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(usuario)
    })
    .then(async response => {
        const msg = document.getElementById("mensaje");

        if (!response.ok) {
            const errorText = await response.text();
            msg.textContent = errorText || "Correo o contraseña incorrectos.";
            msg.style.color = "red";
            throw new Error(errorText);
        }

        return response.json(); // Si la respuesta es correcta, la convertimos a JSON
    })
    .then(data => {
        const msg = document.getElementById("mensaje");
        msg.textContent = "Inicio de sesión exitoso. Redirigiendo...";
        msg.style.color = "green";

        // Guardar el correo para usarlo en la siguiente pantalla (por ejemplo, obraBlanca.html)
        localStorage.setItem("usuarioCorreo", data.correoUsuario);

        // Redirigir a obraBlanca.html
        setTimeout(() => window.location.href = "obraBlanca.html", 2000);
    })
    .catch(error => console.error("Error:", error));
});