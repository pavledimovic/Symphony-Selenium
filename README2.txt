S obzirom da nisam bio u mogucnosti da pristupim serveru saljem vam mali primer smoke testa koji sam radio koriscenjem Postman-a.
  
GET request:  https://jsonplaceholder.typicode.com/todos/1

Test:

console.log("test");

function IsValidJson(str) {

    try {
        JSON.parse(str);
    
}
    catch (e) {
      
  return false;
    }
    return true;

}


var contentTypeHeaderExists = responseHeaders.hasOwnProperty("Content-Type");

pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});


pm.test("Has Content-Type", function () {
    contentTypeHeaderExists;
})
 
if (contentTypeHeaderExists) {

pm.test("Content-Type is application/json", function(){
        
responseHeaders["Content-Type"].has("application/json");
 })

   
 pm.test("response is valid JSON", function() {
        IsValidJson(responseBody);
    })
}

pm.test("Assert that title node text is: delectus aut autem", function () {
    
pm.expect(pm.response.text()).to.include("delectus aut autem");
});

pm.test("Assert that a node called title exists", function () {
    pm.expect(pm.response.text()).to.include("title");
});

let response = pm.response.json(),
    
savedData = JSON.stringify(response);


pm.environment.set("savedData", savedData);

if(IsValidJson(responseBody)){
  
  var responseJSON = JSON.parse(responseBody);
   
 var completed = responseJSON.completed;

  
  pm.test("completed is false", function(){
        
!completed;
    })
}