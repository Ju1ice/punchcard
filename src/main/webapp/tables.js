
document.addEventListener("DOMContentLoaded", function(){
    //ajax call (XMLHttpRequest : xhr) to fetch artists

    var xhr = new XMLHttpRequest();
    //ready state 0
    xhr.open('GET', 'http://localhost:8080/chinook/api/artist');

    //ready state 1
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState === 4 && xhr.status ===200){
            //parse http body 
            var json = JSON.parse(xhr.responseText);
            console.log(json);
            artistification(json);
        }
    };
});
