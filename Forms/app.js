
// var firstname = document.getElementById("firstname").value
var lastname = document.getElementById("lname").value
var designation = document.getElementById("desg").value
var company = document.getElementById("comp").value
var YOE = document.getElementById("yoe").value
var technology = document.getElementById("tech").value

function showdata(){
    // document.querySelector('textarea').innerHTML = lastname+"\n"+designation
    // +"\n"+company+"\n"+YOE+"\n"+technology
    alert("The data submitted is:"+lastname+"\n"+designation
    +"\n"+company+"\n"+YOE+"\n"+technology)


}

window.onload = function(){
    console.log('Data logging...')
    console.log('Printing to textarea...')
    showdata()
}