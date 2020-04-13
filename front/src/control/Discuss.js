import axios from 'axios'

export function getCommentList(artId) {
    return axios.get('/api/discuss/page?artId=' + artId)
}

export function cusAddComment(comment) {
    return axios.post('/api/discuss/comment', comment)
}

export function cusAddReply(reply) {
    return axios.post('/api/discuss/reply', reply)
}

export function cusComPreference(comId, preference) {
    return axios.get('/api/discuss/precom?comId=' + comId + '&preference=' + preference)
}

export function cusRepPreference(repId, preference) {
    return axios.get('/api/discuss/prerep?repId=' + repId + '&preference=' + preference)
}