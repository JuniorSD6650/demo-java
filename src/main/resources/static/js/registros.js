$(document).ready(function() {
    // Obtener lista de registros de hábitos
    $.get("/registros", function(data) {
        let registrosHtml = "";
        data.forEach(registro => {
            registrosHtml += `<tr>
                <td>${registro.usuario.nombre}</td>
                <td>${registro.habito.nombre}</td>
                <td>${registro.fecha}</td>
                <td>
                    <button onclick="eliminarRegistro(${registro.id})" class="btn btn-sm btn-danger">Eliminar</button>
                </td>
            </tr>`;
        });
        $("#registros-table").html(registrosHtml);
    });

    // Obtener usuarios para el formulario
    $.get("/usuarios", function(data) {
        let usuariosHtml = "";
        data.forEach(usuario => {
            usuariosHtml += `<option value="${usuario.id}">${usuario.nombre}</option>`;
        });
        $("#usuarioId").html(usuariosHtml);
    });

    // Obtener hábitos para el formulario
    $.get("/habitos", function(data) {
        let habitosHtml = "";
        data.forEach(habito => {
            habitosHtml += `<option value="${habito.id}">${habito.nombre} (${habito.frecuencia})</option>`;
        });
        $("#habitoId").html(habitosHtml);
    });

    // Registrar un nuevo hábito
    $("#registrarHabito").click(function() {
        let usuarioId = $("#usuarioId").val();
        let habitoId = $("#habitoId").val();
        let fecha = $("#fecha").val();

        $.ajax({
            url: "/registros",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                usuario: { id: usuarioId },
                habito: { id: habitoId },
                fecha: fecha
            }),
            success: function() { location.reload(); }
        });
    });
});

// Eliminar un registro de hábito
function eliminarRegistro(id) {
    $.ajax({
        url: "/registros/" + id,
        method: "DELETE",
        success: function() { location.reload(); }
    });
}
