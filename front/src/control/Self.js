import axios from 'axios'

export function getCusSelfInfo() {
    return axios.get('/api/self/own')
}

export function getCusBasicInfo(cusId) {
    return axios.get('/api/self/basic?cusId=' + cusId);
}

export function getCusCountInfo(cusId) {
    return axios.get('/api/self/count?cusId=' + cusId);
}

export function getCusSelfDynamic(cusId, page, pageSize) {
    return axios.get('/api/self/dynamic?cusId=' + cusId + '&page=' + page + '&pageSize=' + pageSize);
}