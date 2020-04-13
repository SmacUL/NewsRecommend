import axios from 'axios'

export function searchContentByKeyAndTagTypePage(key, tag, type, page, pageSize) {
    return axios.get('/api/search/key?key=' + key + '&tag=' + tag + '&type=' + type + '&page=' + page + '&pageSize=' + pageSize)
}