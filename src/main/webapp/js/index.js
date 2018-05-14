const API_URL = "http://localhost:8080/hotels";

let hotels = [];

$(document).ready(function () {
    getData();
});

function getData() {
    hotels = [];
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", API_URL, false); // false for synchronous request
    xmlHttp.send();
    hotels = JSON.parse(xmlHttp.responseText);
    table = document.getElementById("data").innerHTML = "";
    hotels.forEach(populateData);
}

function searchData() {

    hotels = [];

    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", API_URL, false); // false for synchronous request
    xmlHttp.send();
    hotels = JSON.parse(xmlHttp.responseText);
    table = document.getElementById("data").innerHTML = "";
    hotels.forEach(populateData);

}

function populateData(item, index) {
    table = document.getElementById("data");
    table.innerHTML = table.innerHTML +
        "<tr>" +
            "<td>" + item.id + "</td>" +
            "<td>" + item.nombre +"</td>" +
            "<td>" + item.numHabitaciones +"</td>" +
            "<td>" + item.precio +"</td>" +
        "</tr>";
}