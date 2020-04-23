import axios from 'axios'

let base = '/api/search/';

export function searchContentSimple(key, page, pageSize) {
    let config = {
        params: {
            key: key,
            page: page,
            pageSize: pageSize
        }
    };
    return axios.get(base + 'simple', config);
}

// export function searchContentByKeyAndTagTypePage(key, tag, type, page, pageSize) {
//     return axios.get('/api/search/key?key=' + key + '&tag=' + tag + '&type=' + type + '&page=' + page + '&pageSize=' + pageSize)
// }