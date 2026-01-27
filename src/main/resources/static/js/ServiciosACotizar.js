

// PROTECCIÓN DE SESIÓN

window.onload = function(){
   const correo = localStorage.getItem("usuarioCorreo");
   if(!correo){
      window.location.replace("/login.html");
   }
}


// Detectar la opción seleccionada
const opcionRadios = document.querySelectorAll('input[name="opcion"]');
const divCotizacion = document.getElementById("cotizacionBase");
const divVisita = document.getElementById("visitaTecnica");
const mensaje = document.getElementById("mensaje");

// Cuando el usuario selecciona una opción
opcionRadios.forEach(radio => {
  radio.addEventListener("change", () => {
    if (radio.value === "base") {
      divCotizacion.style.display = "block";
      divVisita.style.display = "none";
    } else if (radio.value === "visita") {
      divVisita.style.display = "block";
      divCotizacion.style.display = "none";
    }
    mensaje.textContent = ""; // limpiar mensaje anterior
  });
});

// Enviar Cotización Base 
// Al enviar checklist
document.getElementById("formChecklist").addEventListener("submit", e => {
  e.preventDefault();

  const items = Array.from(document.querySelectorAll('input[name="item"]:checked'))
                   .map(i => ({ idServicio: parseInt(i.value) }));

  if(items.length == 0){
    mensaje.textContent = "Selecciona al menos un ítem";
    mensaje.style.color="red";
    return;
  }

  const correo = localStorage.getItem("usuarioCorreo");

  const data = {
     fechaSolicitud: new Date().toISOString().split("T")[0],
     usuario: { correoUsuario: correo },
     detalles: items
  };

  fetch("http://localhost:8081/api/servicios/guardar",{
    method:"POST",
    headers:{ "Content-Type":"application/json"},
    body: JSON.stringify(data)
  })
  .then(res => res.json())
  .then(() => {
     window.location.href="ObraBlanca.html";
  });
});


// Enviar solicitud de Visita Técnica
document.getElementById("formVisita").addEventListener("submit", e => {
 e.preventDefault();

 const correo = localStorage.getItem("usuarioCorreo");

 const data = {
   tipoSolicitud: "VISITA",
   fechaVisita: document.getElementById("fecha_visita").value,
   horaVisita: document.getElementById("hora_visita").value,
   lugarVisita: document.getElementById("lugar_visita").value,
   usuario: { correoUsuario: correo }
 };

 fetch("http://localhost:8081/api/servicios/guardar",{
   method:"POST",
   headers:{ "Content-Type":"application/json"},
   body: JSON.stringify(data)
 })
 .then(res => res.json())
 .then(()=> {
    mensaje.textContent="Visita técnica agendada correctamente";
    mensaje.style.color="green";
 });
});



// CERRAR SESIÓN
function cerrarSesion(){
   localStorage.removeItem("usuarioCorreo");
   window.location.replace("/login.html");
}

