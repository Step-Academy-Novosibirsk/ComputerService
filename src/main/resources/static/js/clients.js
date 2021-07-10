async function loadClients(){
  let response =  await fetch("http://localhost:8080/api/Clients/");
  if(response.ok) {
      let clients = await response.json();
      let list = document.getElementById('Clients');
      for(let i=0;i<clients.length;i++) {
          let name = document.createElement('li');
          name.innerText = clients[i].name;
          list.appendChild(name);
      }
  }
  else
      alert("request has been failed");
}