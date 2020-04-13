import axios from 'axios'

export function getCusSelfInfo() {
    return axios.get('/api/self/own')
}