$(document).ready(function() {
    // Obtener lista de hábitos
    $.get("/habitos", function(data) {
        let habitosHtml = "";
        data.forEach(habito => {
            habitosHtml += `<li class="list-group-item d-flex justify-content-between align-items-center">
                ${habito.nombre} (${habito.frecuencia})
                <div>
                    <button onclick="editarHabito(${habito.id})" class="btn btn-sm btn-warning">Editar</button>
                    <button onclick="eliminarHabito(${habito.id})" class="btn btn-sm btn-danger">Eliminar</button>
                </div>
            </li>`;
        });
        $("#habitos-list").html(habitosHtml);
    });

    // Agregar hábito
    $("#agregarHabito").click(function() {
        let nombre = $("#nombreHabito").val();
        let frecuencia = $("#frecuenciaHabito").val();

        $.ajax({
            url: "/habitos",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({ nombre: nombre, frecuencia: frecuencia }),
            success: function() { location.reload(); }
        });
    });
});

// Editar hábito
function editarHabito(id) {
    let nuevoNombre = prompt("Nuevo nombre del hábito:");
    let nuevaFrecuencia = prompt("Nueva frecuencia (Diario, Semanal, Mensual):");

    if (nuevoNombre && nuevaFrecuencia) {
        $.ajax({
            url: "/habitos/" + id,
            method: "PUT",
            contentType: "application/json",
            data: JSON.stringify({ nombre: nuevoNombre, frecuencia: nuevaFrecuencia }),
            success: function() { location.reload(); }
        });
    }
}

// Eliminar hábito
function eliminarHabito(id) {
    $.ajax({
        url: "/habitos/" + id,
        method: "DELETE",
        success: function() { location.reload(); }
    });
}
