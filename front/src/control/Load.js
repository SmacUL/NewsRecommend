import axios from 'axios'

export function getArtTypes() {
    return axios.get('/api/load/type')
}

export function getHotArtOnePage(hotPage, hotPageSize) {
    return axios.get('/api/load/hot?page=' + hotPage + '&pageSize=' + hotPageSize)
}

export function getTinyArtOnePageByType(artType, page, pageSize) {
    return axios.get('/api/load/tiny?artType=' + artType + '&page=' + page + '&pageSize=' + pageSize)
}

export function getFullArtWithCus(artId) {
    return axios.get('/api/load/main?artId=' + artId)
}