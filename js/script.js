if (navigator.geolocation) {
  navigator.geolocation.getCurrentPosition(showPosition, showError);
} else {
  console.log("Geolocalização não é suportada pelo seu navegador.");
}

function showPosition(position) {
  var latitude = position.coords.latitude;
  var longitude = position.coords.longitude;
  console.log("Latitude: " + latitude + ", Longitude: " + longitude);
}

function showError(error) {
  switch(error.code) {
    case error.PERMISSION_DENIED:
      console.log("Usuário negou a solicitação de Geolocalização.");
      break;
    case error.POSITION_UNAVAILABLE:
      console.log("Informações de localização não estão disponíveis.");
      break;
    case error.TIMEOUT:
      console.log("A solicitação para obter a localização do usuário expirou.");
      break;
    case error.UNKNOWN_ERROR:
      console.log("Um erro desconhecido ocorreu.");
      break;
  }
}