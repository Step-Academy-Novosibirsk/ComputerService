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
async function addOrder(){
    let orderDescription = document.getElementById('orderDescription');
    let orderComment = document.getElementById('orderComment');
    let newClient = document.getElementById("-1");
    let client;
    if(newClient.selected){
        let clientName = document.getElementById('Name');
        let clientAddress = document.getElementById('Address');
        let clientPhone = document.getElementById('Phone');
        let clientPassword = document.getElementById('Password');
        client = {
            'name': clientName.value,
            'address': clientAddress.value,
            'password': clientPassword.value,
            'phone': clientPhone.value
        }
    }
    else {
        let select = document.getElementById('orderClients');
        for(let i=0;i<select.childElementCount;i++)
        {
            if(select.children[i].selected) {
                client = {
                    'id': select.children[i].value
                }
                break;
            }
        }
    }
    let order = {
        'description': orderDescription.value,
        'comment': orderComment.value,
        'client': client
    }
    let response = await fetch('http://localhost:8080/api/Orders/Add',{
        method: 'POST',
        headers: {
            'Content-Type':'application/json;charset=utf-8'
        },
        body: JSON.stringify(order)
    })
    if(response.ok){
        alert('заказ успешно добавлен');
    }
    else{
        alert('при добавлении заказа возникла ошибка');
        alert(response.status);
    }
}