$(document).ready(function() {
    // Obtener lista de usuarios
    $.get("/usuarios", function(data) {
        let usuariosHtml = "";
        data.forEach(usuario => {
            usuariosHtml += `<li class="list-group-item d-flex justify-content-between align-items-center">
                ${usuario.nombre} - ${usuario.email}
                <div>
                    <button onclick="editarUsuario(${usuario.id})" class="btn btn-sm btn-warning">Editar</button>
                    <button onclick="eliminarUsuario(${usuario.id})" class="btn btn-sm btn-danger">Eliminar</button>
                </div>
            </li>`;
        });
        $("#usuarios-list").html(usuariosHtml);
    });

    // Agregar usuario
    $("#agregarUsuario").click(function() {
        let nombre = $("#nombreUsuario").val();
        let email = $("#emailUsuario").val();

        $.ajax({
            url: "/usuarios",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({ nombre: nombre, email: email }),
            success: function() { location.reload(); }
        });
    });
});

// Editar usuario
function editarUsuario(id) {
    let nuevoNombre = prompt("Nuevo nombre del usuario:");
    let nuevoEmail = prompt("Nuevo email:");

    if (nuevoNombre && nuevoEmail) {
        $.ajax({
            url: "/usuarios/" + id,
            method: "PUT",
            contentType: "application/json",
            data: JSON.stringify({ nombre: nuevoNombre, email: nuevoEmail }),
            success: function() { location.reload(); }
        });
    }
}

// Eliminar usuario
function eliminarUsuario(id) {
    $.ajax({
        url: "/usuarios/" + id,
        method: "DELETE",
        success: function() { location.reload(); }
    });
}
