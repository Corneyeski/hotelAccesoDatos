const API_URL = "http://localhost:8080/hotels";

var hotels = [];

$(document).ready(function () {
    getData();
});

function getData() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", API_URL, false); // false for synchronous request
    xmlHttp.send();
    hotels = JSON.parse(xmlHttp.responseText);
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
            "<td></td>" +
            "<td>" +
                "<button type='button' class='btn btn-warning btn-sm' onclick='editHotel(" + index + ")'>Edit</button>" +
                "<button type='button' class='btn btn-danger btn-sm' onclick='deleteHotel(" + index + ")'>Delete</button>" +
            "</td>" +
        "</tr>";
}

function editHotel(hotelId) {
    table = document.getElementById("tableData");
    table.hidden = true;
    form = document.getElementById("form");
    form.hidden = false;
    var hotel = hotels[hotelId];
    populateHotel(hotel);
}

function onSave() {
    var hotel = {
        id: document.getElementById("hotelId").value,
        nombre: document.getElementById("hotelName").value,
        numHabitaciones: document.getElementById("hotelRooms").value,
        precio: document.getElementById("hotelPrice").value
    };
    saveHotel(hotel);
}

function saveHotel(hotel) {
    console.log(hotel);
    var xmlHttp = new XMLHttpRequest();
    if (hotel.id == null) {
        xmlHttp.open("POST", API_URL, false); // false for synchronous request
    } else {
        xmlHttp.open("PUT", API_URL, false); // false for synchronous request
    }
    xmlHttp.setRequestHeader("Content-type", "application/json");
    xmlHttp.send(hotel);
}

function populateHotel(hotel) {
    document.getElementById("hotelId").value = hotel.id;
    document.getElementById("hotelName").value = hotel.nombre;
    document.getElementById("hotelRooms").value = hotel.numHabitaciones;
    document.getElementById("hotelPrice").value = hotel.precio;
}

function deleteHotel(hotelId) {

}