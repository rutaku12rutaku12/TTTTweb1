
console.log('find.js open');

const findId = async() =>{ console.log('findId exe');  
    try{ // fetch 실행
        const option = { method : "GET"}
        const response = await fetch( "/member/find" , option );
        const data = await response.json();

    }catch (error){console.log(error);}
    
} 
