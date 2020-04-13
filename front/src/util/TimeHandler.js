export function transUTCtoLocal(time) {
    return new Date(Date.parse(time)).toLocaleString();
}