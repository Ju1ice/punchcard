document.getElementById('login').addEventListener('submit', function(e){
    e.preventDefault();
        var username =  document.getElementById('username').value;
        var password =  document.getElementById('password').value;
        console.log("This is username " + username);


 var promise = axios({
    method: 'post',
    url: 'http://localhost:8080/punchcard/yourtime/',
    params: {
      username: username,
      password: password
    }
  });
    // 1 callback for a successfull response
promise.then(function(response){
    window.location="/punhcard/yourtime/index.html";});
    //another callback for a failed response
    promise.catch(function(response){
        window.location="login.html";});
})

