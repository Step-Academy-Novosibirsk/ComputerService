async function loadClients(){
  let response =  await fetch("http://localhost:8080/api/Clients/");
  if(response.ok) {
      let clients = await response.json();
      let table = document.getElementById('Clients');
      for(let i=0;i<clients.length;i++) {
          let str = document.createElement('tr');
          let name = document.createElement('td');
          let view = document.createElement('a');
          view.href = "http://localhost:8080/clients/view.html?id="+clients[i].id;
          view.innerText = clients[i].name;
          name.appendChild(view);
          str.appendChild(name);
          let address = document.createElement('td');
          address.innerText = clients[i].address;
          str.appendChild(address);
          let phone = document.createElement('td');
          phone.innerText = clients[i].phone;
          str.appendChild(phone);
          let edit = document.createElement('td');
          let editLink = document.createElement('a');
          editLink.href = "http://localhost:8080/clients/edit.html?id="+clients[i].id;
          editLink.innerText = "edit";
          edit.appendChild(editLink);
          str.appendChild(edit);
          table.appendChild(str);
      }
  }
  else
      alert("request has been failed");
}
async function loadClient(id){
    let response = await fetch("http://localhost:8080/api/Clients/Client/"+id);
    if(response.ok){
        return await response.json();
    }
    throw "request was failed";
}
function getIdClient(){
    let searchParams = new URLSearchParams(document.location.search);
    return searchParams.get("id");
}
async function viewClient(){
    let id = getIdClient();
    let client = await loadClient(id);
    let idElement = document.getElementById('Id');
    idElement.innerText = client.id;
    let nameElement = document.getElementById('Name');
    nameElement.innerText = client.name;
    let addressElement = document.getElementById('Address');
    addressElement.innerText = client.address;
    let phoneElement = document.getElementById('Phone');
    phoneElement.innerText = client.phone;
    let passwordElement = document.getElementById("Password");
    passwordElement.innerText = client.password;
}
async function editClient(){
    let id = getIdClient();
    if(id==null)
        return;
    let client = await loadClient(id);
    let idElement = document.getElementById('Id');
    idElement.value = client.id;
    let nameElement = document.getElementById('Name');
    nameElement.value = client.name;
    let addressElement = document.getElementById('Address');
    addressElement.value = client.address;
    let phoneElement = document.getElementById('Phone');
    phoneElement.value = client.phone;
    let passwordElement = document.getElementById("Password");
    passwordElement.value = client.password;
}
function getClientParameters(){
    let idElement = document.getElementById('Id');
    let nameElement = document.getElementById('Name');
    let addressElement = document.getElementById('Address');
    let phoneElement = document.getElementById('Phone');
    let passwordElement = document.getElementById("Password");
    return {
        id:  idElement.value,
        name: nameElement.value,
        address: addressElement.value,
        phone: phoneElement.value,
        password: passwordElement.value
    };
}
async function updateClient(){
    let client = getClientParameters();
    if(client.id.length===0){
        await addClient(client);
        return;
    }
    let response = await fetch('http://localhost:8080/api/Clients/Client/Update/'+client.id,{
       method: 'PUT',
       headers:{
           'Content-Type':'application/json'
       },
        body: JSON.stringify(client)
    });
    if(response.ok){
        window.location = "http://localhost:8080/clients/list.html";
    }
    else{
        alert('ошибка обновления данных');
    }

}
async function loadOrders(id){

}
async function addClient(){
    let client = getClientParameters();
    client.id =0;
    let response = await fetch('http://localhost:8080/api/Clients/Add',{
        method: 'POST',
        headers:{
            'Content-Type':'application/json;charset=utf-8'
        },
        body: JSON.stringify(client)
    });
    if(response.ok) {
        window.location = "http://localhost:8080/clients/list.html";
    }
    else{
        alert('ошибка добавления данных');
    }
}