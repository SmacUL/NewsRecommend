import axios from 'axios'

let base = '/api/load/';

export function getArtTypes() {
    return axios.get(base + 'type');
}

export function getTinyArtOnePageByType(artType, page, pageSize) {
    let config = {
        params: {
            artType: artType,
            page: page,
            pageSize: pageSize
        }
    };
    return axios.get(base + 'tiny', config);
}

export function getHotArtOnePage(page, pageSize) {
    let config = {
        params: {
            page: page,
            pageSize: pageSize
        }
    };

    return axios.get(base + 'hot', config);
}

export function getFullArt(artId) {
    let config = {
        params: {
            artId: artId
        }
    };
    return axios.get(base + 'main', config);
}

export function setArtPreference(artId, type) {
    let config = {
        params: {
            artId: artId,
            type: type
        }
    };
    return axios.get(base + 'prefer', config);
}