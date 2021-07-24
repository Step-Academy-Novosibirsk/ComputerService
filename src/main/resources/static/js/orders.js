async function loadClients() {
    let response = await fetch("http://localhost:8080/api/Clients/");
    if(response.ok) {
        let clients = await response.json();
        let select = document.getElementById("orderClients");
        for(let i=0;i<clients.length;i++){
            let option = document.createElement('option');
            option.label = clients[i].name;
            option.value = clients[i].id;
            option.onclick = selectionChanged;
            select.appendChild(option);
        }
    }
}
function selectionChanged(){
    let newClient = document.getElementById("-1");
    let clientForm = document.getElementById('clientForm');
    clientForm.hidden = !newClient.selected;
}