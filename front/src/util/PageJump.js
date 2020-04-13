import router from '@/router/index.js'

export function jumpInCurPage(road) {
    let route = router.resolve(road);
    window.open(route.href, '_self');
}

export function jumpInNewPage(road) {
    let route = router.resolve(road);
    window.open(route.href, '_blank');
}