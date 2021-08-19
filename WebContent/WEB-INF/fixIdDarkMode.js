let preUrl = window.location.toString().search;
let darkMode = document.getElementById("darkMode");
let postUrl = new URL(darkMode.href);
let params = new URLSearchParams(postUrl.search);
params.delete('darkMode');
darkMode.href = window.location.href.split('?')[0] +"?"+ window.location.href.split('?')[1].split('&')[0] +"&"+postUrl.search.substring(1,postUrl.search.length);
