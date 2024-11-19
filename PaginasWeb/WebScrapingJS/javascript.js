const axios = require("axios");
const cheerio = require("cheerio");

const url = "https://pt.wikipedia.org/wiki/Oscar_de_melhor_filme";

async function getMovies() {
    const { data } = await axios.get(url);
    const $ = cheerio.load(data);

    const list = [];
    $(".wikitable tbody tr").each((i, elem) => {
        const winners = $(elem).find('td[style*="background:#FAEB86"]');
        const name = winners.last().text().replace("\n", "");
        if (name !== "") {
            const year = winners.first().prev("td").text().replace("\n", "").slice(-4);
            movie = { name, year };
            list.push(movie);
        }
    });
    console.log(list);
    return list;  
}
(function escreverNaTela(document) {
    'use strict';
    var lista = getMovies();
    var texto = JSON.stringify(lista);
    console.log(typeof(list));
    var container = document.querySelector("#container");
    container.innerHTML =texto;
});

escreverNaTela();
    