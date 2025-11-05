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
document.getElementById("formChecklist").addEventListener("submit", event => {
  event.preventDefault();
  const items = Array.from(document.querySelectorAll('input[name="item"]:checked'))
                     .map(i => i.value);

  if (items.length === 0) {
    mensaje.textContent = "Por favor selecciona al menos un ítem.";
    mensaje.style.color = "red";
    return;
  }

  // Simular envío al servidor
  console.log("Cotización base enviada:", items);
  mensaje.textContent = "Cotización base enviada correctamente.";
  mensaje.style.color = "green";
});

// Enviar solicitud de Visita Técnica
document.getElementById("formVisita").addEventListener("submit", event => {
  event.preventDefault();

  const fecha = document.getElementById("fecha_visita").value;
  const hora = document.getElementById("hora_visita").value;
  const lugar = document.getElementById("lugar_visita").value;

  if (!fecha || !hora || !lugar) {
    mensaje.textContent = "Por favor completa todos los campos.";
    mensaje.style.color = "red";
    return;
  }

  const solicitud = { fecha, hora, lugar };
  console.log("Visita técnica agendada:", solicitud);

  // Aquí puedes agregar un fetch() para guardar en la BD si deseas
  mensaje.textContent = "Visita técnica agendada correctamente.";
  mensaje.style.color = "green";
});
