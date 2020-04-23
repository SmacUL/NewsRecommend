import axios from 'axios'

let base = '/api/discuss/';

export function getComList(artId) {
    let config = {
        params: {
            artId: artId,
        }
    };
    return axios.get(base + 'page', config);
}

export function addNewCom(comment) {
    return axios.post(base + 'com', comment)
}

export function cusAddReply(reply) {
    return axios.post(base + 'rep', reply)
}

// export function cusComPreference(comId, preference) {
//     return axios.get('/api/discuss/precom?comId=' + comId + '&preference=' + preference)
// }
//
// export function cusRepPreference(repId, preference) {
//     return axios.get('/api/discuss/prerep?repId=' + repId + '&preference=' + preference)
// }