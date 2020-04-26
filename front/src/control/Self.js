import axios from 'axios'

let base = '/api/self/';

export function cusLogin(cusName, cusPass) {
    let data = new FormData();
    data.append('cusName', cusName);
    data.append('cusPass', cusPass);
    return axios.post(base + 'login', data);
}

export function quitLogin() {
    return axios.get(base + 'quit');
}

export function cusRegister(cusName, cusPass) {
    let data = new FormData();
    data.append('cusName', cusName);
    data.append('cusPass', cusPass);
    return axios.post(base + 'register', data)
}

export function getCusBasicInfo(cusId) {
    let config = {
        params: {
            cusId: cusId
        }
    };
    return axios.get(base + 'basic', config)
}

export function setCusBasicInfo(customer) {
    let config = {
        params: {
            customer: customer
        }
    };
    return axios.get(base + 'modify', config);
}

export function setCusFollow(cusId) {
    let config = {
        params: {
            cusId: cusId
        }
    };
    return axios.get(base + 'follow', config);
}


export function getCusFeatureInfo(cusId) {
    let config = {
        params: {
            cusId: cusId
        }
    };
    return axios.get(base + 'feature', config);
}

export function getCusSelfDynamic(cusId, page, pageSize) {
    let config = {
        params: {
            cusId: cusId,
            page: page,
            pageSize: pageSize
        }
    };
    return axios.get(base + 'dynamic', config);
}

export function checkCusFollow(cusId) {
    let config = {
        params: {
            cusId: cusId
        }
    };
    return axios.get(base + 'chefollow', config)
}