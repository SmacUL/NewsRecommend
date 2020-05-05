import axios from 'axios'

let base = '/api/edit/';

export function addNewArt(article) {
    return axios.post(base + 'add', article);
}
