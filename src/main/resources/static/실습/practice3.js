console.log("1.practice3 open")

const waitingAdd = ( ) => {
    console.log( "waitingAdd exe")
    let data = { wphone : "010-2424-5532" , wcount : 5 }
    let option = {
        method : "POST",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify( data )
    }
    fetch( "/waiting", option )
    .then( response => response.json() )
    .then( data => {console.log(data) } )
    .catch( error => {console.log(error) } ) 
}

const waitingPrint = ( ) => {
    console.log( "waitingPrint exe")
    let option = { method : "GET"}
    fetch( "/waiting" , option)
    .then( response => response.json() )
    .then( data => {console.log(data) } )
    .catch( error => {console.log(error) } )
}

const waitingDelete = ( ) => {
    console.log( "waitingDelete exe")
    let wno = 6; // 아무 wno 값
    let option = { method: "DELETE"}
    fetch(`/waiting?wno=${wno}`,option)
        .then( response => response.json() )
        .then( data => { console.log(data) } )
        .catch( error => {console.log(error) } )
}

const waitingUpdate = ( ) => {
    console.log("waitingUpdate exe")
    let data = { wno : 8 , wcount: 10 }
    let option = {
        method : "PUT" ,
        headers : { "Content-Type" : "application/json"} ,
        body : JSON.stringify( data )
    }
    fetch("/waiting" , option )
        .then( response => response.json())
        .then( data => {console.log(data) } )
        .catch( error => {console.log(error) } )
}






























