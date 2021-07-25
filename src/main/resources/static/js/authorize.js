async function authorize(){
    sessionStorage.removeItem('userKey');
    let phoneField = document.getElementById('phone');
    let passwordField = document.getElementById('password');
    let phone = phoneField.value;
    let password = passwordField.value;
    let request = {
        'phone': phone,
        'password': password
    }
    let response = await fetch('http://localhost:8080/api/authorize',{
        headers:{
            'Content-Type':'application/json'
        },
        method: 'POST',
        body: JSON.stringify(request)

    });
    if(response.ok){
        let answer = await response.json();
        sessionStorage.setItem('userKey',answer.token);
        window.location = "http://localhost:8080/clients/list.html";
    }
    else if(response.status===401){
        alert('Ошибка имени пользователя или пароля');
    }
    else {
        alert(response.status);

    }

}